grammar Cmm;

// Syntax Analysis part

// start rule
cmm : ((NEWLINE)* struct (NEWLINE)*)* ((NEWLINE)* function (NEWLINE)*)* main (NEWLINE)* | EOF ;

// all of our types
type : primitiveTypes | structType | listType | fptr ;

primitiveTypes :INT | BOOL ;

structType : STRUCT ID ;

listType : LIST HASHSIGN type ;

fptr : FPTR LE ((type COMMA)* type | VOID) ARROW functionReturnType RE ;

functionReturnType : type | VOID ;

// assignment part
assignment
    :leftSideAssignment ASSIGNMENT_OP rightSideAssignment ;

leftSideAssignment
    : expr | variableDeclaration ;

rightSideAssignment
    : expr ;

variableDeclaration
    :type ID {System.out.println("VarDec : "+$ID.getText());} (ASSIGNMENT_OP expr)?
     (COMMA (ID {System.out.println("VarDec : "+$ID.getText());} | assignmentVariable))* ;

assignmentVariable:
    ID {System.out.println("VarDec : "+$ID.getText());} ASSIGNMENT_OP expr ;

// statement part
multiStatement
    : (NEWLINE)* oneStatement multiStatement | ;

oneStatement
    : (variableDeclaration | loop | IF conditionExpr | functionCall | assignment | returnRule | size | display | append )
     (SEMICOLON oneStatement)* SEMICOLON? (NEWLINE)* ;

returnRule :RETURN {System.out.println("Return");} (size | expr | append | ) ;

display : DISPLAY {System.out.println("Built-in : display");} LP expr RP ;

// condition (if , else) part
conditionExpr
    : {System.out.println("Conditional : if");} (LP expr RP | expr)
     ( (BEGIN NEWLINE multiStatement (NEWLINE)* END (NEWLINE)*) | (NEWLINE)* oneStatement ) (elseConditionExpr)? ;

elseConditionExpr
    : ELSE {System.out.println("Conditional : else");} ( (BEGIN NEWLINE multiStatement (NEWLINE)* END) | (NEWLINE)* oneStatement ) ;

// loop part
loop : whileLoop | doWhileLoop ;

whileLoop
    :WHILE {System.out.println("Loop : while");} (LP expr RP | expr) (BEGIN NEWLINE multiStatement (NEWLINE)*  END  | (NEWLINE)+ oneStatement ) ;

doWhileLoop
    :DO {System.out.println("Loop : do...while");} (BEGIN NEWLINE multiStatement (NEWLINE)* END (NEWLINE)* | (NEWLINE)+ oneStatement (NEWLINE)* )
    WHILE (LP expr RP | expr) ;

// expression part
expr
    :exprFunctionCall
    |append
    |list
    |size
    |ID
    |NUMBER
    |BOOLVALUES
    |TILDA_OP expr  {System.out.println("Operator : "+$TILDA_OP.getText());}
    |MINUS_OP expr  {System.out.println("Operator : "+$MINUS_OP.getText());}
    |expr MULT_OP expr {System.out.println("Operator : "+$MULT_OP.getText());}
    |expr DIV_OP expr {System.out.println("Operator : "+$DIV_OP.getText());}
    |expr PLUS_OP expr {System.out.println("Operator : "+$PLUS_OP.getText());}
    |expr MINUS_OP expr {System.out.println("Operator : "+$MINUS_OP.getText());}
    |expr LE expr {System.out.println("Operator : "+$LE.getText());}
    |expr RE expr {System.out.println("Operator : "+$RE.getText());}
    |expr IS_EQUAL expr {System.out.println("Operator : "+$IS_EQUAL.getText());}
    |expr AND_OP expr {System.out.println("Operator : "+$AND_OP.getText());}
    |expr OR_OP expr {System.out.println("Operator : "+$OR_OP.getText());}
    |expr ASSIGNMENT_OP expr {System.out.println("Operator:"+$ASSIGNMENT_OP.getText());}
    |LP expr RP ;

exprFunctionCall : ID (accessToList)? (DOT ID (accessToList)? inputArguments?)* inputArguments? ;

size : SIZE {System.out.println("Size");} LP (ID | list | append | exprFunctionCall | NUMBER) RP ;

list : LB (expr? (COMMA expr)* ) RB ;

append : APPEND {System.out.println("Append");} LP expr (accessToList)? COMMA expr RP (accessToList)? ;

// struct part
struct
  : STRUCT ID {System.out.println("StructDec : "+$ID.getText());}
  (BEGIN NEWLINE structVariableDeclarations (NEWLINE)* END (NEWLINE)*| (NEWLINE)+ structVariableDeclaration) NEWLINE ;

structVariableDeclarations
    : (NEWLINE)* structVariableDeclaration  structVariableDeclarations | ;

structVariableDeclaration
    : variableDeclaration (SEMICOLON)? | assignment (SEMICOLON)? | declareWithSetterGetter (SEMICOLON (structVariableDeclaration)? | (NEWLINE)+) ;

declareWithSetterGetter
    : type ID {System.out.println("VarDec : "+$ID.getText());} LP arguments RP BEGIN (NEWLINE)+ setter (NEWLINE)* getter (NEWLINE)* END ;

setter
    : (SET {System.out.println("Setter");} BEGIN NEWLINE multiStatement (NEWLINE)* END NEWLINE | SET {System.out.println("Setter");} (NEWLINE)+ oneStatement) ;

getter
    : (GET {System.out.println("Getter");} BEGIN NEWLINE multiStatement (NEWLINE)* END NEWLINE | GET {System.out.println("Getter");} (NEWLINE)+ oneStatement) ;

// function part

function : functionReturnType ID {System.out.println("FunctionDec : "+$ID.getText());} LP arguments? RP
     (BEGIN (NEWLINE)+ multiStatement (NEWLINE)* END NEWLINE| (NEWLINE)+ oneStatement) ;

arguments
    : type ID {System.out.println("ArgumentDec : "+$ID.getText());} COMMA arguments
    | type ID {System.out.println("ArgumentDec : "+$ID.getText());} | ;

functionCall : ID {System.out.println("FunctionCall");} (accessToList)? (DOT ID (accessToList)? inputArguments?)* inputArguments?;

accessToList : (LB expr RB)+ ;

inputArguments : (LP listOfArguments? RP)* ;

listOfArguments : expr COMMA listOfArguments | expr ;

// main part
main : MAIN {System.out.println("Main");} LP RP BEGIN (NEWLINE)+ multiStatement (NEWLINE)* END ;

//Lexical Analysis part (Tokens)
STRUCT : 'struct';
BEGIN : 'begin';
END : 'end';
NEWLINE : '\n' ;
MAIN : 'main';
INT : 'int';
LIST : 'list';
VOID : 'void';
BOOL : 'bool';
FPTR : 'fptr';
IF : 'if';
ELSE : 'else';
WHILE : 'while';
DO : 'do';
SET : 'set';
GET : 'get';
DISPLAY : 'display';
RETURN : 'return';
SIZE : 'size';
APPEND : 'append';
BOOLVALUES : 'true' | 'false';
MINUS_OP : '-';
ID : [_A-Za-z][_A-Za-z0-9]*;
NUMBER :'0'|[1-9][0-9]*;
MULT_OP : '*';
DIV_OP : '/';
PLUS_OP : '+';
TILDA_OP : '~';
AND_OP :'&';
OR_OP :'|';
ASSIGNMENT_OP : '=';
SEMICOLON : ';';
DOT : '.';
HASHSIGN : '#';
COMMA : ',';
ARROW :'->';
LP : '(';
RP : ')';
LB :'[';
RB :']';
LE :'<';
RE :'>';
IS_EQUAL :'==';
QUESTIONMARK: '?';
COMMENT : '/*' .*? '*/' -> skip;
WS : [ \r\t]+ -> skip;