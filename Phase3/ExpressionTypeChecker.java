package main.visitor.type;

import main.ast.nodes.Node;
import main.ast.nodes.declaration.FunctionDeclaration;
import main.ast.nodes.declaration.struct.StructDeclaration;
import main.ast.nodes.expression.*;
import main.ast.nodes.expression.operators.BinaryOperator;
import main.ast.nodes.expression.operators.UnaryOperator;
import main.ast.nodes.expression.values.primitive.BoolValue;
import main.ast.nodes.expression.values.primitive.IntValue;
import main.ast.nodes.statement.SetGetVarDeclaration;
import main.ast.types.*;
import main.ast.types.primitives.BoolType;
import main.ast.types.primitives.IntType;
import main.ast.types.primitives.VoidType;
import main.compileError.typeError.*;
import main.symbolTable.SymbolTable;
import main.symbolTable.exceptions.ItemNotFoundException;
import main.symbolTable.items.FunctionSymbolTableItem;
import main.symbolTable.items.StructSymbolTableItem;
import main.symbolTable.items.VariableSymbolTableItem;
import main.visitor.Visitor;

import javax.lang.model.type.NullType;
import java.util.ArrayList;

public class ExpressionTypeChecker extends Visitor<Type> {

    private StructDeclaration currentStruct;
    private FunctionDeclaration currentFunction;
    private SetGetVarDeclaration currentSetGetVar;
    private boolean seenNoneLvalue = false;
    private int typeValidationNumberOfErrors;
    private boolean isInFunctionCallStmt = false;

    private boolean isInStruct = false;
    private boolean isInSetter = false;
    private boolean isInGetter = false;
    private boolean isInFunction = false;
    private boolean isInMain = false;

    public void setIsInStruct(boolean _is_in_struct) { this.isInStruct = _is_in_struct; }
    public void setIsInSetter(boolean _is_in_setter) { this.isInSetter = _is_in_setter; }
    public void setIsInGetter(boolean _is_in_getter) { this.isInGetter = _is_in_getter; }
    public void setIsInFunction(boolean _is_in_function) { this.isInFunction = _is_in_function; }
    public void setIsInMain(boolean _is_in_main) { this.isInMain = _is_in_main; }

    public void setCurrentSetGetVar (SetGetVarDeclaration _currentSetGetVar) {
        this.currentSetGetVar = _currentSetGetVar;
    }

    public void setCurrentStruct(StructDeclaration currentStruct) {
        this.currentStruct = currentStruct;
    }

    public void setCurrentFunction(FunctionDeclaration currentFunction) {
        this.currentFunction = currentFunction;
    }

    public void setIsInFunctionCallStmt(boolean inIsFunctionCallStmt) {
        isInFunctionCallStmt = inIsFunctionCallStmt;
    }

    public boolean isSameType(Type first, Type second) {
        return (first instanceof NoType) || (second instanceof NoType) ||
                (isFirstSubTypeOfSecond(first, second) && isFirstSubTypeOfSecond(second, first));
    }

    public boolean isFirstSubTypeOfSecondMultiple(ArrayList<Type> first, ArrayList<Type> second) {
        if(first.size() != second.size())
            return false;
        for(int i = 0; i < first.size(); i++) {
            if(!isFirstSubTypeOfSecond(first.get(i), second.get(i)))
                return false;
        }
        return true;
    }

    public boolean isFirstSubTypeOfSecond(Type first, Type second) {
        if(first instanceof NoType)
            return true;
        else if(first instanceof IntType || first instanceof BoolType || first instanceof VoidType) {
            if (first != null && second != null)
                return first.toString().equals(second.toString());
        }
        else if(first instanceof StructType)
            return second instanceof StructType;
        else if(first instanceof FptrType) {
            if(!(second instanceof FptrType))
                return false;
            Type firstRetType = ((FptrType) first).getReturnType();
            Type secondRetType = ((FptrType) second).getReturnType();
            if(!isFirstSubTypeOfSecond(firstRetType, secondRetType))
                return false;
            ArrayList<Type> firstArgsTypes = ((FptrType) first).getArgsType();
            ArrayList<Type> secondArgsTypes = ((FptrType) second).getArgsType();
            return isFirstSubTypeOfSecondMultiple(secondArgsTypes, firstArgsTypes);
        }
        else if(first instanceof ListType) {
            if (!(second instanceof ListType))
                return false;
            return isFirstSubTypeOfSecond(((ListType) first).getType(), ((ListType) second).getType());
        }
        return false;
    }

    public boolean isLvalue(Expression expression) {
        boolean prevSeenNoneLvalue = this.seenNoneLvalue;
        this.seenNoneLvalue = false;
        expression.accept(this);
        boolean isLvalue = !this.seenNoneLvalue;
        this.seenNoneLvalue = prevSeenNoneLvalue;
        return isLvalue;
    }

    @Override
    public Type visit(BinaryExpression binaryExpression) {
        //Todo
        this.seenNoneLvalue = true;
        BinaryOperator operator = binaryExpression.getBinaryOperator();
        Type firstType = binaryExpression.getFirstOperand().accept(this);
        Type secondType = binaryExpression.getSecondOperand().accept(this);

        if(operator == BinaryOperator.eq) {
            if(firstType instanceof NoType && secondType instanceof NoType)
                return new NoType();
            else if((firstType instanceof NoType && secondType instanceof ListType) ||
                    (secondType instanceof NoType && firstType instanceof ListType)) {
                UnsupportedOperandType exception = new UnsupportedOperandType(binaryExpression.getLine(), operator.name());
                binaryExpression.addError(exception);
                return new NoType();
            }
            else if(firstType instanceof NoType || secondType instanceof NoType)
                return new NoType();
            if(firstType instanceof IntType || firstType instanceof BoolType)
                if(firstType.toString().equals(secondType.toString()))
                    return new BoolType();
            if(firstType instanceof StructType && secondType instanceof StructType &&
                    ((StructType)firstType).getStructName().getName().equals(((StructType)secondType).getStructName().getName())) {
                return new BoolType();
            }
            if((firstType instanceof FptrType && secondType instanceof FptrType)) {
                if (isSameType(firstType, secondType))
                    return new BoolType();
            }
        }

        if((operator == BinaryOperator.gt) || (operator == BinaryOperator.lt)) {
            if(firstType instanceof NoType && secondType instanceof NoType)
                return new NoType();
            else if((firstType instanceof NoType && !(secondType instanceof IntType)) ||
                    (secondType instanceof NoType && !(firstType instanceof IntType))) {
                UnsupportedOperandType exception = new UnsupportedOperandType(binaryExpression.getLine(), operator.name());
                binaryExpression.addError(exception);
                return new NoType();
            }
            else if(firstType instanceof NoType || secondType instanceof NoType)
                return new NoType();
            if((firstType instanceof IntType) && (secondType instanceof IntType))
                return new BoolType();
        }
        if((operator == BinaryOperator.add) || (operator == BinaryOperator.sub) ||
                (operator == BinaryOperator.mult) || (operator == BinaryOperator.div)) {
            if(firstType instanceof NoType && secondType instanceof NoType)
                return new NoType();
            else if((firstType instanceof NoType && !(secondType instanceof IntType)) ||
                    (secondType instanceof NoType && !(firstType instanceof IntType))) {
                UnsupportedOperandType exception = new UnsupportedOperandType(binaryExpression.getLine(), operator.name());
                binaryExpression.addError(exception);
                return new NoType();
            }
            else if(firstType instanceof NoType || secondType instanceof NoType)
                return new NoType();
            if((firstType instanceof IntType) && (secondType instanceof IntType))
                return new IntType();
        }
        if ((operator == BinaryOperator.or) || (operator == BinaryOperator.and)) {
            if(firstType instanceof NoType && secondType instanceof NoType)
                return new NoType();
            else if((firstType instanceof NoType && !(secondType instanceof BoolType)) ||
                    (secondType instanceof NoType && !(firstType instanceof BoolType))) {
                UnsupportedOperandType exception = new UnsupportedOperandType(binaryExpression.getLine(), operator.name());
                binaryExpression.addError(exception);
                return new NoType();
            }
            else if(firstType instanceof NoType || secondType instanceof NoType)
                return new NoType();
            if((firstType instanceof BoolType) && (secondType instanceof BoolType))
                return new BoolType();
        }

        if(operator == BinaryOperator.assign) {
            boolean isFirstLvalue = this.isLvalue(binaryExpression.getFirstOperand());
            if(!isFirstLvalue) {
                LeftSideNotLvalue exception = new LeftSideNotLvalue(binaryExpression.getLine());
                binaryExpression.addError(exception);
            }
            if(firstType instanceof NoType || secondType instanceof NoType) {
                return new NoType();
            }
            boolean isSubtype = this.isFirstSubTypeOfSecond(secondType, firstType);
            if(isSubtype) {
                if(isFirstLvalue)
                    return secondType;
                return new NoType();
            }
            UnsupportedOperandType exception = new UnsupportedOperandType(binaryExpression.getLine(), operator.name());
            binaryExpression.addError(exception);
            return new NoType();
        }
        UnsupportedOperandType exception = new UnsupportedOperandType(binaryExpression.getLine(), operator.name());
        binaryExpression.addError(exception);
        return new NoType();
    }

    @Override
    public Type visit(UnaryExpression unaryExpression) {
        //Todo +
        this.seenNoneLvalue = true;
        Type operandType = unaryExpression.getOperand().accept(this);
        UnaryOperator operator = unaryExpression.getOperator();
        if(operator == UnaryOperator.not) {
            if(operandType instanceof NoType)
                return new NoType();
            if(operandType instanceof BoolType)
                return operandType;
            UnsupportedOperandType exception = new UnsupportedOperandType(unaryExpression.getLine(), operator.name());
            unaryExpression.addError(exception);
            return new NoType();
        }
        else if(operator == UnaryOperator.minus) {
            if(operandType instanceof NoType)
                return new NoType();
            if(operandType instanceof IntType)
                return operandType;
            UnsupportedOperandType exception = new UnsupportedOperandType(unaryExpression.getLine(), operator.name());
            unaryExpression.addError(exception);
            return new NoType();
        }

        return new NoType();
    }

    @Override
    public Type visit(FunctionCall funcCall) {
        //Todo +
        this.seenNoneLvalue = true;
        Type instance_type = funcCall.getInstance().accept(this);
        boolean prevIsInFunctionCallStmt = this.isInFunctionCallStmt;
        this.setIsInFunctionCallStmt(false);
        ArrayList<Type> argsTypes = new ArrayList<>();
        for(Expression arg : funcCall.getArgs()) {
            argsTypes.add(arg.accept(this));
        }
        this.setIsInFunctionCallStmt(prevIsInFunctionCallStmt);
        if(!(instance_type instanceof FptrType) && !(instance_type instanceof NoType)) {
            CallOnNoneFptrType exception = new CallOnNoneFptrType(funcCall.getLine());
            funcCall.addError(exception);
            return new NoType();
        }
        else if(instance_type instanceof NoType) {
            return new NoType();
        }
        else {
            ArrayList<Type> actualArgsTypes = ((FptrType) instance_type).getArgsType();
            Type returnType = ((FptrType) instance_type).getReturnType();
            boolean hasError = false;
            if(!isInFunctionCallStmt && (returnType instanceof VoidType)) {
                CantUseValueOfVoidFunction exception = new CantUseValueOfVoidFunction(funcCall.getLine());
                funcCall.addError(exception);
                hasError = true;
            }
            if(this.isFirstSubTypeOfSecondMultiple(argsTypes, actualArgsTypes)) {
                if(hasError)
                    return new NoType();
                return returnType;
            }
            else {
                ArgsInFunctionCallNotMatchDefinition exception = new ArgsInFunctionCallNotMatchDefinition(funcCall.getLine());
                funcCall.addError(exception);
                return new NoType();
            }
        }
    }

    @Override
    public Type visit(Identifier identifier) {
        //Todo
        try {
            StructSymbolTableItem structSymbolTableItem = (StructSymbolTableItem) SymbolTable.root.getItem(StructSymbolTableItem.START_KEY + this.currentStruct.getStructName().getName());
            SymbolTable structSymbolTable = structSymbolTableItem.getStructSymbolTable();
            if (isInStruct) {
                FunctionSymbolTableItem functionSymbolTableItem = (FunctionSymbolTableItem) structSymbolTable.getItem(FunctionSymbolTableItem.START_KEY + this.currentSetGetVar.getVarName().getName());
                SymbolTable functionSymbolTable = functionSymbolTableItem.getFunctionSymbolTable();
                if (isInSetter) {
                    VariableSymbolTableItem variableSymbolTableItem = (VariableSymbolTableItem) functionSymbolTable.getItem(VariableSymbolTableItem.START_KEY + identifier.getName());
                    return variableSymbolTableItem.getType();
                }
                else {
                    VariableSymbolTableItem variableSymbolTableItem = (VariableSymbolTableItem) structSymbolTable.getItem(VariableSymbolTableItem.START_KEY + identifier.getName());
                    return variableSymbolTableItem.getType();
                }
            }
            else {
                FunctionSymbolTableItem functionSymbolTableItem = (FunctionSymbolTableItem) SymbolTable.root.getItem(FunctionSymbolTableItem.START_KEY + this.currentFunction.getFunctionName().getName());
                SymbolTable functionSymbolTable = functionSymbolTableItem.getFunctionSymbolTable();
//                VariableSymbolTableItem variableSymbolTableItem = (VariableSymbolTableItem) functionSymbolTable.getItem(VariableSymbolTableItem.START_KEY + identifier.getName());
//                return variableSymbolTableItem.getType();
                return new NoType();
            }

        } catch (ItemNotFoundException e) {
            VarNotDeclared exception = new VarNotDeclared(identifier.getLine(), identifier.getName());
            identifier.addError(exception);
            return new NoType();
        }
    }

    @Override
    public Type visit(ListAccessByIndex listAccessByIndex) {
        //Todo - seenNoneLvalue Ham Check Shavad /////

        Type instanceType = listAccessByIndex.getInstance().accept(this);
        boolean prevSeenNoneLvalue = this.seenNoneLvalue;
        Type indexType = listAccessByIndex.getIndex().accept(this);
        this.seenNoneLvalue = prevSeenNoneLvalue;

        boolean _hasError = false;

        if(!(instanceType instanceof NoType) && !(instanceType instanceof ListType)) {
            AccessByIndexOnNonList exception = new AccessByIndexOnNonList(listAccessByIndex.getLine());
            listAccessByIndex.addError(exception);
            _hasError = true;
        }

        if(!(indexType instanceof NoType) && !(indexType instanceof IntType)) {
            ListIndexNotInt exception = new ListIndexNotInt(listAccessByIndex.getLine());
            listAccessByIndex.addError(exception);
            _hasError = true;
        }
        if(_hasError) {
            return new NoType();
        }

        if(instanceType instanceof ListType) {
            return ((ListType) instanceType).getType();
        }
        return new NoType();
    }

    @Override
    public Type visit(StructAccess structAccess) {
        //Todo
        boolean prevSeenNoneLvalue = this.seenNoneLvalue;
        Type instanceType = structAccess.getInstance().accept(this);
        if(!(instanceType instanceof StructType) && !(instanceType instanceof NoType)) {
            AccessOnNonStruct exception = new AccessOnNonStruct(structAccess.getLine());
            structAccess.addError(exception);
            return new NoType();
        }


        //edame darad
        return null;
    }

    @Override
    public Type visit(ListSize listSize) {
        //Todo +
        this.seenNoneLvalue = true;
        Type sizeType = listSize.getArg().accept(this);
        if(!(sizeType instanceof NoType) && !(sizeType instanceof ListType)) {
            GetSizeOfNonList exception = new GetSizeOfNonList(listSize.getLine());
            listSize.addError(exception);
            return new NoType();
        }
        return new IntType();
    }

    @Override
    public Type visit(ListAppend listAppend) {
        //Todo +
        this.seenNoneLvalue = true;
        Type argType = listAppend.getListArg().accept(this);
        if(!(argType instanceof NoType) && !(argType instanceof ListType)) {
            AppendToNonList exception = new AppendToNonList(listAppend.getLine());
            listAppend.addError(exception);
            return new NoType();
        }

        Type elementType = listAppend.getElementArg().accept(this);
        if(!(argType instanceof NoType)) {
            ListType list_type = (ListType) argType;
            if(!isFirstSubTypeOfSecond(elementType, list_type.getType())) {
                NewElementTypeNotMatchListType exception = new NewElementTypeNotMatchListType(listAppend.getLine());
                listAppend.addError(exception);
                return new NoType();
            }
        }

        return new VoidType();
    }

    @Override
    public Type visit(ExprInPar exprInPar) {
        //Todo +
        this.seenNoneLvalue = true;
        if (exprInPar.getInputs().size() > 0)
            return exprInPar.getInputs().get(0).accept(this);
        return new NoType();
    }

    @Override
    public Type visit(IntValue intValue) {
        //Todo -
        this.seenNoneLvalue = true;
        return new IntType();
    }

    @Override
    public Type visit(BoolValue boolValue) {
        //Todo -
        this.seenNoneLvalue = true;
        return new BoolType();
    }
}
