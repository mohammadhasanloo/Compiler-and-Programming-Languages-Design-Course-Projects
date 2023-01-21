package main.visitor.codeGenerator;

import main.ast.nodes.*;
import main.ast.nodes.declaration.*;
import main.ast.nodes.declaration.struct.*;
import main.ast.nodes.expression.*;
import main.ast.nodes.expression.operators.*;
import main.ast.nodes.expression.values.*;
import main.ast.nodes.expression.values.primitive.*;
import main.ast.nodes.statement.*;
import main.ast.types.*;
import main.ast.types.primitives.*;
import main.symbolTable.*;
import main.symbolTable.exceptions.*;
import main.symbolTable.items.FunctionSymbolTableItem;
import main.symbolTable.items.StructSymbolTableItem;
import main.symbolTable.items.VariableSymbolTableItem;
import main.visitor.Visitor;
import main.visitor.type.ExpressionTypeChecker;

import javax.lang.model.type.NullType;
import java.io.*;
import java.util.*;

public class  CodeGenerator extends Visitor<String> {
    ExpressionTypeChecker expressionTypeChecker = new ExpressionTypeChecker();
    private String outputPath;
    private FileWriter currentFile;
    private StructDeclaration currentStruct;
    private FunctionDeclaration currentFunction;
    private boolean is_in_main;
    private ArrayList<VariableDeclaration> local_vars;
    private ArrayList<VariableDeclaration> struct_fields;

    private int numOfUsedTemp;
    private int numOfUsedLabel;

    private boolean DefaultConst;

    private void copyFile(String toBeCopied, String toBePasted) {
        try {
            File readingFile = new File(toBeCopied);
            File writingFile = new File(toBePasted);
            InputStream readingFileStream = new FileInputStream(readingFile);
            OutputStream writingFileStream = new FileOutputStream(writingFile);
            byte[] buffer = new byte[1024];
            int readLength;
            while ((readLength = readingFileStream.read(buffer)) > 0)
                writingFileStream.write(buffer, 0, readLength);
            readingFileStream.close();
            writingFileStream.close();
        } catch (IOException e) {//unreachable
        }
    }

    private void prepareOutputFolder() {
        this.outputPath = "output/";
        String jasminPath = "utilities/jarFiles/jasmin.jar";
        String listClassPath = "utilities/codeGenerationUtilityClasses/List.j";
        String fptrClassPath = "utilities/codeGenerationUtilityClasses/Fptr.j";
        try{
            File directory = new File(this.outputPath);
            File[] files = directory.listFiles();
            if(files != null)
                for (File file : files)
                    file.delete();
            directory.mkdir();
        }
        catch(SecurityException e) {//unreachable

        }
        copyFile(jasminPath, this.outputPath + "jasmin.jar");
        copyFile(listClassPath, this.outputPath + "List.j");
        copyFile(fptrClassPath, this.outputPath + "Fptr.j");
    }

    private void createFile(String name) {
        try {
            String path = this.outputPath + name + ".j";
            File file = new File(path);
            file.createNewFile();
            this.currentFile = new FileWriter(path);
        } catch (IOException e) {//never reached
        }
    }

    private void addCommand(String command) {
        try {
            command = String.join("\n\t\t", command.split("\n"));
            if(command.startsWith("Label_"))
                this.currentFile.write("\t" + command + "\n");
            else if(command.startsWith("."))
                this.currentFile.write(command + "\n");
            else
                this.currentFile.write("\t\t" + command + "\n");
            this.currentFile.flush();
        } catch (IOException e) {//unreachable

        }
    }

    private String makeTypeSignature(Type t) {
        if (t instanceof IntType)
            return "java/lang/Integer";
        if (t instanceof BoolType)
            return "java/lang/Boolean";
        if (t instanceof ListType)
            return "List";
        if (t instanceof FptrType)
            return "Fptr";
        if (t instanceof StructType)
            return ((StructType)t).getStructName().getName();
        return null;
    }

    private void initializeList(ListType listType) {
        addCommand("new List");
        addCommand("dup");
        addCommand("new java/util/ArrayList");
        addCommand("dup");
        addCommand("invokespecial java/util/ArrayList/<init>()V");

//        addCommand("dup");
//
//        if(listType.getType() instanceof FptrType){
//            addCommand("aconst_null");
//            addCommand("invokevirtual java/util/ArrayList/add(Ljava/lang/Object;)Z");
//        }
////        else if (listType.getType() instanceof StructType) {
////            addCommand("new " + makeTypeSignature(listType.getType()));
////            addCommand("dup");
////            addCommand("invokespecial " + makeTypeSignature(listType.getType()) + "/<init>()V");
////            addCommand("aconst_null");
////            addCommand("invokevirtual java/util/ArrayList/add(Ljava/lang/Object;)Z");
////        }
//        if(listType.getType() instanceof IntType || listType.getType() instanceof BoolType){
//            addCommand("ldc 0");
//            if(listType.getType() instanceof IntType)
//                addCommand("invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;");
//            if(listType.getType() instanceof BoolType)
//                addCommand("invokestatic java/lang/Boolean/valueOf(Z)Ljava/lang/Boolean;");
//            addCommand("invokevirtual java/util/ArrayList/add(Ljava/lang/Object;)Z");
//        }
//        else{
//            initializeList((ListType) listType.getType());
//            addCommand("invokevirtual java/util/ArrayList/add(Ljava/lang/Object;)Z");
//        }
//
//        addCommand("pop");

        addCommand("invokespecial List/<init>(Ljava/util/ArrayList;)V");
    }

    private void addDefaultConstructor() {
        String structName = currentStruct.getStructName().getName();

        addCommand(".method public <init>()V");
        addCommand(".limit stack 128");
        addCommand(".limit locals 128");
        addCommand("aload 0");
        addCommand("invokespecial java/lang/Object/<init>()V");

        for (VariableDeclaration field: struct_fields) {
            String fieldName = field.getVarName().getName();
            Type fieldType = field.getVarType();

            if (fieldType instanceof IntType || fieldType instanceof BoolType){
                addCommand("aload 0");
                if (field.getDefaultValue() != null)
                    addCommand(field.getDefaultValue().accept(this));
                else
                    addCommand("ldc 0");
                if (fieldType instanceof IntType)
                    addCommand("invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;");
                if (fieldType instanceof BoolType)
                    addCommand("invokestatic java/lang/Boolean/valueOf(Z)Ljava/lang/Boolean;");
                addCommand("putfield " + structName + "/" + fieldName + " L" + makeTypeSignature(fieldType) + ";\n");
            }
            else if (fieldType instanceof FptrType){
                addCommand("aload 0");
                if (field.getDefaultValue() != null)
                    addCommand("ldc " + field.getDefaultValue().toString());  // ????????????????????????
                else
                    addCommand("aconst_null");
                addCommand("putfield " + structName + "/" + fieldName + " L" + makeTypeSignature(fieldType) + ";\n");
            }
            else if (fieldType instanceof StructType){
                addCommand("aload 0");
                if (field.getDefaultValue() != null)
                    addCommand("ldc " + field.getDefaultValue().toString());  // ????????????????????????
                else {
                    addCommand("new " + ((StructType) fieldType).getStructName().getName());
                    addCommand("dup");
                    addCommand("invokespecial " + makeTypeSignature(fieldType) + "/<init>()V");
                    /// baz ham barresi shavad
                }

                addCommand("putfield " + structName + "/" + fieldName + " L" + makeTypeSignature(fieldType) + ";\n");
            }
            else if (fieldType instanceof ListType) {
                addCommand("aload 0");
                initializeList((ListType) fieldType);
                addCommand("putfield " + structName + "/" + fieldName + " L" + makeTypeSignature(fieldType) + ";\n");
            }
        }
        addCommand("return");
        addCommand(".end method");
    }

    private void addStaticMainMethod() {
        addCommand(".method public static main([Ljava/lang/String;)V");
        addCommand(".limit stack 128");
        addCommand(".limit locals 128");
        addCommand("new Main");
        addCommand("invokespecial Main/<init>()V");
        addCommand("return");
        addCommand(".end method");
    }

    private int slotOf(String identifier) {
        //todo +
        int count = 1;
        if ((currentFunction != null)) {
            for (VariableDeclaration arg : currentFunction.getArgs()) {
                if (arg.getVarName().getName().equals(identifier))
                    return count;
                count++;
            }
        }
        for(VariableDeclaration var : local_vars) {
            if(var.getVarName().getName().equals(identifier))
                return count;
            count++;
        }
        if (identifier.equals("")){
            int temp = numOfUsedTemp;
            numOfUsedTemp++;
            return count + temp;
        }
        return 0;
    }

    private String getFreshLabel(){
        String label = "Label_";
        label += numOfUsedLabel;
        numOfUsedLabel++;
        return label;
    }

    @Override
    public String visit(Program program) {
        prepareOutputFolder();
        numOfUsedTemp = 0;
        numOfUsedLabel = 0;
        struct_fields = new ArrayList<>();
        local_vars = new ArrayList<>();

        for(StructDeclaration structDeclaration : program.getStructs()) {
            structDeclaration.accept(this);
        }

        createFile("Main");

        is_in_main = true;
        program.getMain().accept(this);
        is_in_main = false;
        for (FunctionDeclaration functionDeclaration: program.getFunctions()){
            currentFunction = functionDeclaration;
            functionDeclaration.accept(this);
        }

//        addCommand("return");
//        addCommand(".end method");

        return null;
    }

    @Override
    public String visit(StructDeclaration structDeclaration) {
        //todo +
        currentStruct = structDeclaration;
        try{
            String structKey = StructSymbolTableItem.START_KEY + structDeclaration.getStructName().getName();
            StructSymbolTableItem structSymbolTableItem = (StructSymbolTableItem)SymbolTable.root.getItem(structKey);
            SymbolTable.push(structSymbolTableItem.getStructSymbolTable());
        }catch (ItemNotFoundException e){//unreachable
        }
        String struct_name = structDeclaration.getStructName().getName();
        createFile(struct_name);
        addCommand(".class " + struct_name);
        addCommand(".super java/lang/Object");


        structDeclaration.getBody().accept(this);

        addDefaultConstructor();

        struct_fields.clear();
        SymbolTable.pop();
        return null;
    }

    @Override
    public String visit(FunctionDeclaration functionDeclaration) {
        //todo +
        try{
            String functionKey = FunctionSymbolTableItem.START_KEY + functionDeclaration.getFunctionName().getName();
            FunctionSymbolTableItem functionSymbolTableItem = (FunctionSymbolTableItem)SymbolTable.root.getItem(functionKey);
            SymbolTable.push(functionSymbolTableItem.getFunctionSymbolTable());
        }catch (ItemNotFoundException e){//unreachable
        }

        String header = "";
        header += ".method public " + functionDeclaration.getFunctionName().getName() + "(";
        for(VariableDeclaration arg : functionDeclaration.getArgs()){
            header += "L" + makeTypeSignature(arg.getVarType()) + ";";
        }
        if (functionDeclaration.getReturnType() instanceof VoidType)
            header += ")V";
        else
            header += ")L"  + makeTypeSignature(functionDeclaration.getReturnType()) + ";";

        addCommand(header);
        addCommand(".limit stack 128");
        addCommand(".limit locals 128");

        functionDeclaration.getBody().accept(this);

        if(functionDeclaration.getReturnType() instanceof VoidType) /// barresi shavad
            addCommand("return");

        addCommand(".end method");

        numOfUsedTemp = 0;

        local_vars.clear();
        SymbolTable.pop();
        return null;
    }

    @Override
    public String visit(MainDeclaration mainDeclaration) {
        //todo +
        try{
            String functionKey = FunctionSymbolTableItem.START_KEY + "main";
            FunctionSymbolTableItem functionSymbolTableItem = (FunctionSymbolTableItem)SymbolTable.root.getItem(functionKey);
            SymbolTable.push(functionSymbolTableItem.getFunctionSymbolTable());
        }catch (ItemNotFoundException e){//unreachable
        }

        addCommand(".class Main");
        addCommand(".super java/lang/Object");
        addStaticMainMethod();

        addCommand(".method public <init>()V");
        addCommand(".limit stack 128");
        addCommand(".limit locals 128");
        addCommand("aload 0");
        addCommand("invokespecial java/lang/Object/<init>()V");

        mainDeclaration.getBody().accept(this);


        addCommand("return");
        addCommand(".end method");

        local_vars.clear();
        SymbolTable.pop();
        return null;
    }

    @Override
    public String visit(VariableDeclaration variableDeclaration) {
        //todo +
        if (currentFunction != null) {
            local_vars.add(variableDeclaration);
        }
        else {
            struct_fields.add(variableDeclaration);
            if (is_in_main)
                local_vars.add(variableDeclaration);
            else {
                String fieldName = variableDeclaration.getVarName().getName();
                Type fieldType = variableDeclaration.getVarType();
                String signature = makeTypeSignature(fieldType);
                addCommand(".field " + fieldName + " L" + signature + ";");
                return null;
            }
        }
        int slot = slotOf(variableDeclaration.getVarName().getName());
        Type type = variableDeclaration.getVarType();

        if(type instanceof IntType || type instanceof BoolType){
            if (variableDeclaration.getDefaultValue() != null)
                addCommand(variableDeclaration.getDefaultValue().accept(this));
            else
                addCommand("ldc 0");
            if(type instanceof IntType)
                addCommand("invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;");
            if(type instanceof BoolType)
                addCommand("invokestatic java/lang/Boolean/valueOf(Z)Ljava/lang/Boolean;");
            addCommand("astore " + slot);
        }
        else if(type instanceof FptrType){
            if (variableDeclaration.getDefaultValue() != null)
                addCommand("ldc " + variableDeclaration.getDefaultValue().toString());  // ????????????????????????
            else
                addCommand("aconst_null");
            addCommand("astore " + slot);
        }
        else if(type instanceof StructType){
            if (variableDeclaration.getDefaultValue() != null)
                addCommand("ldc " + variableDeclaration.getDefaultValue().toString());  // ????????????????????????
            else {
                addCommand("new " + ((StructType) type).getStructName().getName());
                addCommand("dup");
                addCommand("invokespecial " + ((StructType) type).getStructName().getName() + "/<init>()V");
                /// baz ham barresi shavad
            }
            addCommand("astore " + slot);
        }
        else if (type instanceof ListType) {
            initializeList((ListType) type);
            addCommand("astore " + slot);
        }

        return null;
    }

    @Override
    public String visit(SetGetVarDeclaration setGetVarDeclaration) {
        return null;
    }

    @Override
    public String visit(AssignmentStmt assignmentStmt) {
        //todo +
        BinaryExpression assignment_expr = new BinaryExpression(assignmentStmt.getLValue(), assignmentStmt.getRValue(), BinaryOperator.assign);
        addCommand(assignment_expr.accept(this));
        addCommand("pop");
        return null;
    }

    @Override
    public String visit(BlockStmt blockStmt) {
        //todo +
        for (Statement stmt: blockStmt.getStatements())
            stmt.accept(this);
        return null;
    }

    @Override
    public String visit(ConditionalStmt conditionalStmt) {
        //todo +
        String labelElse = getFreshLabel();
        String labelAfter = getFreshLabel();

        addCommand(conditionalStmt.getCondition().accept(this));
        addCommand("ifeq " + labelElse);
        conditionalStmt.getThenBody().accept(this);
        addCommand("goto " + labelAfter);
        addCommand(labelElse + ":");
        if (conditionalStmt.getElseBody() != null)
            conditionalStmt.getElseBody().accept(this);
        addCommand(labelAfter + ":");
        return null;
    }

    @Override
    public String visit(FunctionCallStmt functionCallStmt) {
        //todo +
        expressionTypeChecker.setInFunctionCallStmt(true);
        addCommand(functionCallStmt.getFunctionCall().accept(this));
        Type t = functionCallStmt.getFunctionCall().accept(expressionTypeChecker);
        FptrType fptrType = (FptrType) functionCallStmt.getFunctionCall().getInstance().accept(this.expressionTypeChecker);
        if (!(fptrType.getReturnType() instanceof VoidType))
            addCommand("pop");
//        if (!(t instanceof VoidType))
//            addCommand("pop");
        expressionTypeChecker.setInFunctionCallStmt(false);
        return null;
    }

    @Override
    public String visit(DisplayStmt displayStmt) {
        addCommand("getstatic java/lang/System/out Ljava/io/PrintStream;");
        Type argType = displayStmt.getArg().accept(expressionTypeChecker);
        String commandsOfArg = displayStmt.getArg().accept(this);

        addCommand(commandsOfArg);
        if (argType instanceof IntType)
            addCommand("invokevirtual java/io/PrintStream/println(I)V");
        if (argType instanceof BoolType)
            addCommand("invokevirtual java/io/PrintStream/println(Z)V");

        return null;
    }

    @Override
    public String visit(ReturnStmt returnStmt) {
        //todo +
        Type returnType = new VoidType();
        if (returnStmt.getReturnedExpr() != null)
            returnType = returnStmt.getReturnedExpr().accept(expressionTypeChecker);

        if(returnType instanceof VoidType) {
            addCommand("return");
        }
        else {
            addCommand(returnStmt.getReturnedExpr().accept(this));
            if(returnType instanceof IntType)
                addCommand("invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;");
            if(returnType instanceof BoolType)
                addCommand("invokestatic java/lang/Boolean/valueOf(Z)Ljava/lang/Boolean;");
            addCommand("areturn");
        }
        return null;
    }

    @Override
    public String visit(LoopStmt loopStmt) {
        //todo +
        if(loopStmt.getIsDoWhile()){
            String labelStart = getFreshLabel();
            addCommand(labelStart + ":");
            if (loopStmt.getCondition() != null)
                loopStmt.getBody().accept(this); //blockstmt null return mikone
            addCommand(loopStmt.getCondition().accept(this));
            addCommand("ifne " + labelStart);
        }
        else{
            String labelStart = getFreshLabel();
            String labelExit = getFreshLabel();
            addCommand(labelStart + ":");
            if (loopStmt.getCondition() != null) {
                addCommand(loopStmt.getCondition().accept(this));
                addCommand("ifeq " + labelExit);
            }
            loopStmt.getBody().accept(this); //blockstmt null return mikone
            addCommand("goto " + labelStart);
            addCommand(labelExit + ":");
        }

        return null;
    }

    @Override
    public String visit(VarDecStmt varDecStmt) {
        //todo +
        for (VariableDeclaration vardec: varDecStmt.getVars())
            vardec.accept(this);
        return null;
    }

    @Override
    public String visit(ListAppendStmt listAppendStmt) {
        //todo +
        expressionTypeChecker.setInFunctionCallStmt(true);
        addCommand(listAppendStmt.getListAppendExpr().accept(this));
        expressionTypeChecker.setInFunctionCallStmt(false);

        return null;
    }

    @Override
    public String visit(ListSizeStmt listSizeStmt) {
        //todo +
        addCommand(listSizeStmt.getListSizeExpr().accept(this));
        addCommand("pop");
        return null;
    }

    @Override
    public String visit(BinaryExpression binaryExpression) {
        //todo +
        BinaryOperator operator = binaryExpression.getBinaryOperator();
        Type operandType = binaryExpression.getFirstOperand().accept(expressionTypeChecker);
        String commands = "";
        if (operator == BinaryOperator.add) {
            commands += binaryExpression.getFirstOperand().accept(this);
            commands += binaryExpression.getSecondOperand().accept(this);
            commands += "iadd\n";
        }
        else if (operator == BinaryOperator.sub) {
            commands += binaryExpression.getFirstOperand().accept(this);
            commands += binaryExpression.getSecondOperand().accept(this);
            commands += "isub\n";
        }
        else if (operator == BinaryOperator.mult) {
            commands += binaryExpression.getFirstOperand().accept(this);
            commands += binaryExpression.getSecondOperand().accept(this);
            commands += "imul\n";
        }
        else if (operator == BinaryOperator.div) {
            commands += binaryExpression.getFirstOperand().accept(this);
            commands += binaryExpression.getSecondOperand().accept(this);
            commands += "idiv\n";
        }
        else if((operator == BinaryOperator.gt) || (operator == BinaryOperator.lt)) {
            commands += binaryExpression.getFirstOperand().accept(this);
            commands += binaryExpression.getSecondOperand().accept(this);
            String labelFalse = getFreshLabel();
            String labelAfter = getFreshLabel();
            if(operator == BinaryOperator.gt)
                commands += "if_icmple " + labelFalse + "\n";
            else
                commands += "if_icmpge " + labelFalse + "\n";
            commands += "ldc " + "1\n";
            commands += "goto " + labelAfter + "\n";
            commands += labelFalse + ":\n";
            commands += "ldc " + "0\n";
            commands += labelAfter + ":\n";
        }
        else if(operator == BinaryOperator.eq) {
            commands += binaryExpression.getFirstOperand().accept(this);
            commands += binaryExpression.getSecondOperand().accept(this);
            String labelFalse = getFreshLabel();
            String labelAfter = getFreshLabel();
            if (!(operandType instanceof IntType) && !(operandType instanceof BoolType))
                commands += "if_acmpne " + labelFalse + "\n";
            else
                commands += "if_icmpne " + labelFalse + "\n";
            commands += "ldc " + "1\n";
            commands += "goto " + labelAfter + "\n";
            commands += labelFalse + ":\n";
            commands += "ldc " + "0\n";
            commands += labelAfter + ":\n";
        }
        else if(operator == BinaryOperator.and) {
            String labelFalse = getFreshLabel();
            String labelAfter = getFreshLabel();
            commands += binaryExpression.getFirstOperand().accept(this);
            commands += "ifeq " + labelFalse + "\n";
            commands += binaryExpression.getSecondOperand().accept(this);
            commands += "ifeq " + labelFalse + "\n";
            commands += "ldc " + "1\n";
            commands += "goto " + labelAfter + "\n";
            commands += labelFalse + ":\n";
            commands += "ldc " + "0\n";
            commands += labelAfter + ":\n";
        }
        else if(operator == BinaryOperator.or) {
            String labelTrue = getFreshLabel();
            String labelAfter = getFreshLabel();
            commands += binaryExpression.getFirstOperand().accept(this);
            commands += "ifne " + labelTrue + "\n";
            commands += binaryExpression.getSecondOperand().accept(this);
            commands += "ifne " + labelTrue + "\n";
            commands += "ldc " + "0\n";
            commands += "goto " + labelAfter + "\n";
            commands += labelTrue + ":\n";
            commands += "ldc " + "1\n";
            commands += labelAfter + ":\n";
        }
        else if(operator == BinaryOperator.assign) {
            Type firstType = binaryExpression.getFirstOperand().accept(expressionTypeChecker);
            Type secondType = binaryExpression.getSecondOperand().accept(expressionTypeChecker);
            String secondOperandCommands = binaryExpression.getSecondOperand().accept(this);
            if(firstType instanceof ListType) {
                secondOperandCommands = "new List\ndup\n" + secondOperandCommands + "invokespecial List/<init>(LList;)V\n";
            }

            if(secondType instanceof IntType)
                secondOperandCommands += "invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;\n";
            if(secondType instanceof BoolType)
                secondOperandCommands += "invokestatic java/lang/Boolean/valueOf(Z)Ljava/lang/Boolean;\n";


            if(binaryExpression.getFirstOperand() instanceof Identifier) {
                Identifier identifier = (Identifier)binaryExpression.getFirstOperand();
                int slot = slotOf(identifier.getName());
                commands += secondOperandCommands;
                commands += "astore " + slot + "\n";
                commands += "aload " + slot + "\n";
                if (secondType instanceof IntType)
                    commands += "invokevirtual java/lang/Integer/intValue()I\n";
                if (secondType instanceof BoolType)
                    commands += "invokevirtual java/lang/Boolean/booleanValue()Z\n";
            }
            else if(binaryExpression.getFirstOperand() instanceof ListAccessByIndex) {
                Expression instance = ((ListAccessByIndex) binaryExpression.getFirstOperand()).getInstance();
                Expression index = ((ListAccessByIndex) binaryExpression.getFirstOperand()).getIndex();
                commands += instance.accept(this);
                commands += index.accept(this);
                commands += secondOperandCommands;
                commands += "invokevirtual List/setElement(ILjava/lang/Object;)V\n";

                commands += instance.accept(this);
                commands += index.accept(this);
                commands += "invokevirtual List/getElement(I)Ljava/lang/Object;\n";
                commands += "checkcast " + makeTypeSignature(secondType) + "\n";
                if (secondType instanceof IntType)
                    commands += "invokevirtual java/lang/Integer/intValue()I\n";
                if (secondType instanceof BoolType)
                    commands += "invokevirtual java/lang/Boolean/booleanValue()Z\n";

            }
            else if(binaryExpression.getFirstOperand() instanceof StructAccess) {
                Expression instance = ((StructAccess) binaryExpression.getFirstOperand()).getInstance();
                Type elemType = binaryExpression.getFirstOperand().accept(expressionTypeChecker);
                String elemName = ((StructAccess) binaryExpression.getFirstOperand()).getElement().getName();
                Type instanceType = instance.accept(expressionTypeChecker);

                String className = ((StructType)instanceType).getStructName().getName();
                commands += instance.accept(this);
                commands += secondOperandCommands;
                commands += "putfield " + className + "/" + elemName + " L" + makeTypeSignature(elemType) + ";\n";

                commands += instance.accept(this);
                commands += "getfield " + className + "/" + elemName + " L" + makeTypeSignature(elemType) + ";\n";
                if (secondType instanceof IntType)
                    commands += "invokevirtual java/lang/Integer/intValue()I\n";
                if (secondType instanceof BoolType)
                    commands += "invokevirtual java/lang/Boolean/booleanValue()Z\n";

            }

        }
        return commands;
    }

    @Override
    public String visit(UnaryExpression unaryExpression){
        return null;
    }

    @Override
    public String visit(StructAccess structAccess){
        //todo +
        Type elemType = structAccess.accept(expressionTypeChecker);
        Type instanceType = structAccess.getInstance().accept(expressionTypeChecker);
        String elemName = structAccess.getElement().getName();
        String commands = "";

        String structName = ((StructType) instanceType).getStructName().getName();
        try {
            SymbolTable structSymbolTable = ((StructSymbolTableItem) SymbolTable.root.getItem(StructSymbolTableItem.START_KEY + structName)).getStructSymbolTable();
            try {
                structSymbolTable.getItem(VariableSymbolTableItem.START_KEY + elemName);
                commands += structAccess.getInstance().accept(this);
                commands += "getfield " + structName + "/" + elemName + " L" + makeTypeSignature(elemType) + ";\n";
                if (elemType instanceof IntType)
                    commands += "invokevirtual java/lang/Integer/intValue()I\n";
                if (elemType instanceof BoolType)
                    commands += "invokevirtual java/lang/Boolean/booleanValue()Z\n";

            } catch (ItemNotFoundException memberIsMethod) { //unreacable

            }
        } catch (ItemNotFoundException classNotFound) { // never reached
        }

        return commands;
    }

    public FunctionSymbolTableItem getFuncSymbolTableItem(String key) {
        try {
            return (FunctionSymbolTableItem) SymbolTable.root.getItem(key);
        } catch (ItemNotFoundException ignored) {}
        return null;
    }

    @Override
    public String visit(Identifier identifier){
        //todo +
        FunctionSymbolTableItem fsti = getFuncSymbolTableItem("Function_" + identifier.getName());
        String commands = "";
        if (fsti == null) { //Not a function name
            int slot = slotOf(identifier.getName());
            Type type = identifier.accept(expressionTypeChecker);
            commands = "aload " + slot + "\n";
            if(type instanceof IntType)
                commands += "invokevirtual java/lang/Integer/intValue()I\n";
            if(type instanceof BoolType)
                commands += "invokevirtual java/lang/Boolean/booleanValue()Z\n";
            if (type instanceof ListType) {

            }
        }
        else { //is a function name
            commands += "new Fptr\n" +
                    "dup\n" +
                    (is_in_main ? "aload 0\n" : "aload 0\n") +
                    "ldc \"" + identifier.getName() + "\"\n" +
                    "invokespecial Fptr/<init>(Ljava/lang/Object;Ljava/lang/String;)V\n";
        }
        return commands;
    }

    @Override
    public String visit(ListAccessByIndex listAccessByIndex){
        //todo +
        String commands = "";
        Type type = listAccessByIndex.accept(expressionTypeChecker);
        commands += listAccessByIndex.getInstance().accept(this);
        commands += listAccessByIndex.getIndex().accept(this);
        commands += "invokevirtual List/getElement(I)Ljava/lang/Object;\n";

        commands += "checkcast " + makeTypeSignature(type) + "\n";

        if (type instanceof IntType)
            commands += "invokevirtual java/lang/Integer/intValue()I\n";
        if (type instanceof BoolType)
            commands += "invokevirtual java/lang/Boolean/booleanValue()Z\n";
        return commands;
    }

    @Override
    public String visit(FunctionCall functionCall) {
        //todo +
        String commands = "";
        int tempIndex = slotOf("");
        ArrayList<Expression> args = functionCall.getArgs();
        Type retType = ((FptrType) functionCall.getInstance().accept(expressionTypeChecker)).getReturnType();
        commands += functionCall.getInstance().accept(this);
        commands += "new java/util/ArrayList\n";
        commands += "dup\n";
        commands += "invokespecial java/util/ArrayList/<init>()V\n";
        commands += "astore " + tempIndex + "\n";


        for(Expression arg : args){
            commands += "aload " + tempIndex + "\n";

            Type argType = arg.accept(expressionTypeChecker);

            if(argType instanceof ListType) {
                commands += "new List\n";
                commands += "dup\n";
            }

            commands += arg.accept(this);

            if(argType instanceof IntType)
                commands += "invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;\n";

            if(argType instanceof BoolType)
                commands += "invokestatic java/lang/Boolean/valueOf(Z)Ljava/lang/Boolean;\n";

            if(argType instanceof ListType) {
                commands += "invokespecial List/<init>(LList;)V\n";
            }

            commands += "invokevirtual java/util/ArrayList/add(Ljava/lang/Object;)Z\n";
            commands += "pop\n";
        }

        commands += "aload " + tempIndex + "\n";
        commands += "invokevirtual Fptr/invoke(Ljava/util/ArrayList;)Ljava/lang/Object;\n";

        if(!(retType instanceof VoidType))
            commands += "checkcast " + makeTypeSignature(retType) + "\n";

        if (retType instanceof IntType)
            commands += "invokevirtual java/lang/Integer/intValue()I\n";
        if (retType instanceof BoolType)
            commands += "invokevirtual java/lang/Boolean/booleanValue()Z\n";
        return commands;
    }

    @Override
    public String visit(ListSize listSize){
        //todo +
        String commandList = listSize.getArg().accept(this);
        String command = "";
        command += commandList;
        command += "invokevirtual List/getSize()I\n";
//        command += "invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;\n";
        return command;
    }

    @Override
    public String visit(ListAppend listAppend) {
        //todo +
        String commands = "";
        int slot = slotOf(((Identifier)listAppend.getListArg()).getName());
        commands += "aload " + slot + "\n";
//        commands += "dup\n";
//        commands += listAppend.getListArg().accept(this);
        commands += listAppend.getElementArg().accept(this);
        Type elem_type = listAppend.getElementArg().accept(expressionTypeChecker);
        if (elem_type instanceof IntType)
            commands += "invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;\n";
        else if (elem_type instanceof BoolType)
            commands += "invokestatic java/lang/Boolean/valueOf(Z)Ljava/lang/Boolean;\n";
        commands += "invokevirtual List/addElement(Ljava/lang/Object;)V\n";

        return commands;
    }

    @Override
    public String visit(IntValue intValue) {
        //todo +
        String commands = "";
        commands += "ldc " + intValue.getConstant() +"\n";
        return commands;
    }

    @Override
    public String visit(BoolValue boolValue) {
        //todo +
        String commands = "";
        if(boolValue.getConstant())
            commands += "ldc " + "1\n";
        else
            commands += "ldc " + "0\n";
        return commands;
    }

    @Override
    public String visit(ExprInPar exprInPar) {
        return exprInPar.getInputs().get(0).accept(this);
    }
}
