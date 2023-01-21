package main.visitor.type;

import main.ast.nodes.Program;
import main.ast.nodes.declaration.*;
import main.ast.nodes.declaration.struct.*;
import main.ast.nodes.expression.Expression;
import main.ast.nodes.expression.ListAppend;
import main.ast.nodes.expression.operators.BinaryOperator;
import main.ast.nodes.statement.*;
import main.ast.types.ListType;
import main.ast.types.NoType;
import main.ast.types.StructType;
import main.ast.types.Type;
import main.ast.types.primitives.BoolType;
import main.ast.types.primitives.IntType;
import main.ast.types.primitives.VoidType;
import main.compileError.nameError.DuplicateFunction;
import main.compileError.typeError.*;
import main.symbolTable.SymbolTable;
import main.symbolTable.exceptions.ItemAlreadyExistsException;
import main.symbolTable.exceptions.ItemNotFoundException;
import main.symbolTable.items.FunctionSymbolTableItem;
import main.symbolTable.items.StructSymbolTableItem;
import main.symbolTable.items.VariableSymbolTableItem;
import main.visitor.Visitor;

import java.util.ArrayList;

public class TypeChecker extends Visitor<Void> {
    ExpressionTypeChecker expressionTypeChecker = new ExpressionTypeChecker();
    private FunctionDeclaration currentFunction;
    private StructDeclaration currentStruct;
    private SetGetVarDeclaration currentSetGetVarDeclaration;
    private boolean isInStruct = false;
    private boolean isInSetter = false;
    private boolean isInGetter = false;
    private boolean isInFunction = false;
    private boolean isInMain = false;
    private boolean haveReturn = false;


//    public void TypeChecker(){
//        this.expressionTypeChecker = new ExpressionTypeChecker();
//    }
    //TypeChecker Koja Estefade Mishavad
    @Override
    public Void visit(Program program) {
        //Todo -
        for(StructDeclaration s:program.getStructs()) {
            s.accept(this);
        }

        for(FunctionDeclaration f:program.getFunctions()) {
            f.accept(this);
        }
        program.getMain().accept(this);
        return null;
    }

    @Override
    public Void visit(FunctionDeclaration functionDec) {
        //Todo -
        this.isInFunction = true;
        expressionTypeChecker.setIsInFunction(true);
        this.currentFunction = functionDec;
        expressionTypeChecker.setCurrentFunction(functionDec);

        SymbolTable f = new SymbolTable();
        SymbolTable.push(f);


        try {
            VariableSymbolTableItem var_item = (VariableSymbolTableItem) SymbolTable.root.getItem(VariableSymbolTableItem.START_KEY+functionDec.getReturnType().toString());
        } catch (ItemNotFoundException e) {//
            if (functionDec.getReturnType() instanceof StructType) {
                StructNotDeclared exception = new StructNotDeclared(functionDec.getLine(), ((StructType) functionDec.getReturnType()).getStructName().getName());
                functionDec.addError(exception);
            }

        }

        if(functionDec.getBody()!= null) {
            functionDec.getBody().accept(this);
        }
        this.isInFunction = false;
        expressionTypeChecker.setIsInFunction(false);

        return null;
    }

    @Override
    public Void visit(MainDeclaration mainDec) {
        //Todo -
        this.isInMain = true;
        expressionTypeChecker.setIsInMain(true);
        SymbolTable f = new SymbolTable();
        SymbolTable.push(f);
        if(mainDec.getBody()!=null) {
            mainDec.getBody().accept(this);
        }
        this.isInMain = false;
        expressionTypeChecker.setIsInMain(false);

        return null;
    }

    @Override
    public Void visit(VariableDeclaration variableDec) {
        if(variableDec.getDefaultValue() != null) {
            Type defaultValueType = variableDec.getDefaultValue().accept(expressionTypeChecker);

            if(defaultValueType instanceof NoType || variableDec.getVarType() instanceof NoType) {
                return null;
            }
            boolean isSubtype = expressionTypeChecker.isFirstSubTypeOfSecond(defaultValueType, variableDec.getVarType());
            if(!isSubtype) {
                UnsupportedOperandType exception = new UnsupportedOperandType(variableDec.getLine(), BinaryOperator.assign.name());
                variableDec.addError(exception);
            }
        }
        if (isInFunction || isInMain) {
            VariableSymbolTableItem varItem = new VariableSymbolTableItem(variableDec.getVarName());
            varItem.setType(variableDec.getVarType());
                try {
                    SymbolTable.top.put(varItem);
                } catch (ItemAlreadyExistsException e) { //

            }
        }

        else if (isInStruct) {
            if (variableDec.getVarType() instanceof StructType) {
                try {
                    VariableSymbolTableItem var_item = (VariableSymbolTableItem) SymbolTable.root.getItem(VariableSymbolTableItem.START_KEY+variableDec.getVarName().getName());
                    var_item.setType(variableDec.getVarType());
                } catch (ItemNotFoundException e) {//
                    StructNotDeclared exception = new StructNotDeclared(variableDec.getLine(), variableDec.getVarName().getName());
                    variableDec.addError(exception);
                    return null;
                }
            } 
        }
        return null;
    }

    @Override
    public Void visit(StructDeclaration structDec) {
        //Todo -
        this.isInStruct = true;
        expressionTypeChecker.setIsInStruct(true);
        this.currentStruct = structDec;
        expressionTypeChecker.setCurrentStruct(structDec);
        if(structDec.getBody() !=null) {
            structDec.getBody().accept(this);
        }
        this.isInStruct = false;
        expressionTypeChecker.setIsInStruct(false);

        return null;
    }

    @Override
    public Void visit(SetGetVarDeclaration setGetVarDec) {
        //Todo
        this.currentSetGetVarDeclaration = setGetVarDec;
        expressionTypeChecker.setCurrentSetGetVar(setGetVarDec);
        this.isInSetter = true;
        expressionTypeChecker.setIsInSetter(true);
        if(setGetVarDec.getSetterBody() != null) {
            setGetVarDec.getSetterBody().accept(this);
        }
        this.isInSetter = false;
        expressionTypeChecker.setIsInSetter(false);

        this.isInGetter = true;
        expressionTypeChecker.setIsInGetter(true);
        if(setGetVarDec.getGetterBody()!=null) {
            setGetVarDec.getGetterBody().accept(this);
        }
        this.isInGetter = false;
        expressionTypeChecker.setIsInGetter(false);

        return null;
    }

    @Override
    public Void visit(AssignmentStmt assignmentStmt) {
        //Todo - dar akhar tebghe lvalue alireza taghir dade shavad
        Type leftType = assignmentStmt.getLValue().accept(expressionTypeChecker);
        Type rightType = assignmentStmt.getRValue().accept(expressionTypeChecker);
        boolean isLeftLValue = expressionTypeChecker.isLvalue(assignmentStmt.getLValue());
        if(!isLeftLValue) {
            LeftSideNotLvalue exception = new LeftSideNotLvalue(assignmentStmt.getLine());
            assignmentStmt.addError(exception);
        }
        if(leftType instanceof NoType || rightType instanceof NoType) {
            return null;
        }
        boolean isSubtype = expressionTypeChecker.isFirstSubTypeOfSecond(rightType, leftType);
        if(!isSubtype) {
            UnsupportedOperandType exception = new UnsupportedOperandType(assignmentStmt.getLine(), BinaryOperator.assign.name());
            assignmentStmt.addError(exception);
        }
        return null;
    }

    @Override
    public Void visit(BlockStmt blockStmt) {
        //Todo -
        ArrayList<Statement> statements = blockStmt.getStatements();
        for(Statement s : statements) {
            s.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(ConditionalStmt conditionalStmt) {
        //Todo -
        if(conditionalStmt.getCondition() !=null) {
            Type conditionType = conditionalStmt.getCondition().accept(expressionTypeChecker);
            if (!(conditionType instanceof NoType) && !(conditionType instanceof BoolType)) {
                ConditionNotBool exception = new ConditionNotBool(conditionalStmt.getLine());
                conditionalStmt.addError(exception);
            }
        }
        if(conditionalStmt.getThenBody() !=null) {
            conditionalStmt.getThenBody().accept(this);
        }
        if(conditionalStmt.getElseBody() !=null) {
            conditionalStmt.getElseBody().accept(this);
        }
        // Return K Dar Har 2 Ta if Va else Bashad mande ast
        return null;
    }

    @Override
    public Void visit(FunctionCallStmt functionCallStmt) {
        //Todo Kare DigeEi Bayad Kard?
        functionCallStmt.getFunctionCall().accept(expressionTypeChecker);
        return null;
    }

    @Override
    public Void visit(DisplayStmt displayStmt) {
        //Todo -
        Type argType = displayStmt.getArg().accept(expressionTypeChecker);
        if(!(argType instanceof IntType || argType instanceof ListType ||
                argType instanceof BoolType || argType instanceof NoType)) {
            UnsupportedTypeForDisplay exception = new UnsupportedTypeForDisplay(displayStmt.getLine());
            displayStmt.addError(exception);
        }
        return null;
    }

    @Override
    public Void visit(ReturnStmt returnStmt) {
        //Todo  Taghadome Error 9 Va 10 --- Khate Aval Va Baraye Getter Age Null Bood Ch Konim

        Type retType = returnStmt.getReturnedExpr().accept(expressionTypeChecker);
        Type functionRet = null;
        if (this.currentFunction != null)
            functionRet = this.currentFunction.getReturnType();

        if(isInFunction) {
            if(functionRet instanceof VoidType && returnStmt.getReturnedExpr() != null) {
                CantUseValueOfVoidFunction exception = new CantUseValueOfVoidFunction(returnStmt.getLine());
                returnStmt.addError(exception);
            }
            if(!expressionTypeChecker.isFirstSubTypeOfSecond(retType, functionRet)) {
                ReturnValueNotMatchFunctionReturnType exception = new ReturnValueNotMatchFunctionReturnType(returnStmt.getLine());
                returnStmt.addError(exception);
            }
        }
        if(this.isInSetter || this.isInMain) {
            CannotUseReturn exception = new CannotUseReturn(returnStmt.getLine());
            returnStmt.addError(exception);
        }
        if(this.isInGetter) {
            if(!expressionTypeChecker.isFirstSubTypeOfSecond(retType, this.currentSetGetVarDeclaration.getVarType())) {
                ReturnValueNotMatchFunctionReturnType exception = new ReturnValueNotMatchFunctionReturnType(returnStmt.getLine());
                returnStmt.addError(exception);
            }
        }

        return null;
    }

    @Override
    public Void visit(LoopStmt loopStmt) {
        //Todo -
        if(loopStmt.getCondition()!=null) {
            Type loopType = loopStmt.getCondition().accept(expressionTypeChecker);
            if (!(loopType instanceof NoType) && !(loopType instanceof BoolType)) {
                ConditionNotBool exception = new ConditionNotBool(loopStmt.getLine());
                loopStmt.addError(exception);
            }
        }
        loopStmt.getBody().accept(this);
        //shayad inja kar dshte bashe bara return
        return null;
    }

    @Override
    public Void visit(VarDecStmt varDecStmt) {
        //Todo -
        if(isInGetter || isInSetter) {
            CannotUseDefineVar exception = new CannotUseDefineVar(varDecStmt.getLine());
            varDecStmt.addError(exception);
        }
        ArrayList<VariableDeclaration> variables = varDecStmt.getVars();
        for(VariableDeclaration varDec: variables) {
            varDec.accept(this);
        }

        return null;
    }

    @Override
    public Void visit(ListAppendStmt listAppendStmt) {
        //Todo -
        ListAppend append_expr = (ListAppend) listAppendStmt.getListAppendExpr();
        Type argType = append_expr.getListArg().accept(expressionTypeChecker);
        if(!(argType instanceof NoType) && !(argType instanceof ListType)) {
            AppendToNonList exception = new AppendToNonList(listAppendStmt.getLine());
            listAppendStmt.addError(exception);
            return null;
        }

        Type elementType = append_expr.getElementArg().accept(expressionTypeChecker);
        if(!(argType instanceof NoType)) {
            ListType list_type = (ListType) argType;
            if(!expressionTypeChecker.isFirstSubTypeOfSecond(elementType, list_type.getType())) {
                NewElementTypeNotMatchListType exception = new NewElementTypeNotMatchListType(listAppendStmt.getLine());
                listAppendStmt.addError(exception);
            }
        }
        return null;
    }

    @Override
    public Void visit(ListSizeStmt listSizeStmt) {
        //Todo -
        Type sizeType = listSizeStmt.getListSizeExpr().accept(expressionTypeChecker);
        if(!(sizeType instanceof NoType) && !(sizeType instanceof ListType)) {
            GetSizeOfNonList exception = new GetSizeOfNonList(listSizeStmt.getLine());
            listSizeStmt.addError(exception);
        }
        return null;
    }
}
