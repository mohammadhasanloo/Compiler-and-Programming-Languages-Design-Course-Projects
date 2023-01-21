grammar Cmm;

@header{
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
     import java.util.*;
 }

cmm returns[Program cmmProgram]:
    NEWLINE* p = program {$cmmProgram = $p.programRet;} NEWLINE* EOF;

program returns[Program programRet]:
    {$programRet = new Program();
     int line = 1;
     $programRet.setLine(line);}
    (s = structDeclaration {$programRet.addStruct($s.structDeclarationRet);})*
    (f = functionDeclaration {$programRet.addFunction($f.functionDeclarationRet);})*
    m = main {$programRet.setMain($m.mainRet);};

//todo // +
main returns[MainDeclaration mainRet]:
    { $mainRet = new MainDeclaration(); }
    MAIN LPAR RPAR bdy = body {$mainRet.setBody($bdy.bdyRet);
                               $mainRet.setLine($MAIN.getLine()); } ;


//todo // +
structDeclaration returns[StructDeclaration structDeclarationRet]:
    { $structDeclarationRet = new StructDeclaration(); }
    STRUCT id = identifier { $structDeclarationRet.setLine($STRUCT.getLine());
                             $structDeclarationRet.setStructName($id.idRet); }
    ((BEGIN strctbdy = structBody NEWLINE+ END { $structDeclarationRet.setBody($strctbdy.strctbdyRet);
                                                 $strctbdy.strctbdyRet.setLine($BEGIN.getLine());   } )
    | (NEWLINE+ stmtbdy = singleStatementStructBody SEMICOLON? { $structDeclarationRet.setBody($stmtbdy.sstmtstrctbdyRet); } )) NEWLINE+;

//todo // +
singleVarWithGetAndSet returns[SetGetVarDeclaration svargetsetRet]:
    { $svargetsetRet = new SetGetVarDeclaration(); }
    tp = type { $svargetsetRet.setVarType($tp.typeRet); }
    idtf = identifier { $svargetsetRet.setVarName($idtf.idRet);
                        $svargetsetRet.setLine($idtf.idRet.getLine()); }
    fncargdec = functionArgsDec { $svargetsetRet.setArgs($fncargdec.funcargsdecRet); }
    BEGIN NEWLINE+
    sbdy = setBody { $svargetsetRet.setSetterBody($sbdy.setbdyRet); }
    gbdy = getBody { $svargetsetRet.setGetterBody($gbdy.getbdyRet); }
    END;

//todo // +
singleStatementStructBody returns[Statement sstmtstrctbdyRet]:
      vrdcstmt = varDecStatement { $sstmtstrctbdyRet = $vrdcstmt.vardecstmtRet; }
    | svrwthGS = singleVarWithGetAndSet { $sstmtstrctbdyRet = $svrwthGS.svargetsetRet; } ;

//todo // +
structBody returns[BlockStmt strctbdyRet]:
    { $strctbdyRet = new BlockStmt(); }
    (NEWLINE+ (stmtsbdy1 = singleStatementStructBody  SEMICOLON
      { $strctbdyRet.addStatement($stmtsbdy1.sstmtstrctbdyRet); }  )*
    stmtsbdy2 = singleStatementStructBody { $strctbdyRet.addStatement($stmtsbdy2.sstmtstrctbdyRet); }
      SEMICOLON?)+ ;

//todo // +
getBody returns[Statement getbdyRet]:
    GET bdy = body { $getbdyRet = $bdy.bdyRet; } NEWLINE+;

//todo // +
setBody returns[Statement setbdyRet]:
    SET bdy = body { $setbdyRet = $bdy.bdyRet; } NEWLINE+;

//todo // +
functionDeclaration returns[FunctionDeclaration functionDeclarationRet]:
    { $functionDeclarationRet = new FunctionDeclaration(); }
    (t = type { $functionDeclarationRet.setReturnType($t.typeRet); }
    | VOID { $functionDeclarationRet.setReturnType(new VoidType()); } )
    id = identifier {   $functionDeclarationRet.setFunctionName($id.idRet);
                        $functionDeclarationRet.setLine($id.idRet.getLine()); }
    fargsdec = functionArgsDec { $functionDeclarationRet.setArgs($fargsdec.funcargsdecRet); }
    bdy = body { $functionDeclarationRet.setBody($bdy.bdyRet); }
    NEWLINE+;

//todo // +
functionArgsDec returns[ArrayList<VariableDeclaration> funcargsdecRet]:
    { $funcargsdecRet = new ArrayList<VariableDeclaration>(); }
    LPAR (tp1 = type idf1 = identifier
    { VariableDeclaration vardec1 = new VariableDeclaration($idf1.idRet, $tp1.typeRet);
      vardec1.setLine($idf1.idRet.getLine());
      $funcargsdecRet.add(vardec1); }
    (COMMA tp2 = type idf2 = identifier
     { VariableDeclaration vardec2 = new VariableDeclaration($idf2.idRet, $tp2.typeRet);
             vardec2.setLine($idf2.idRet.getLine());
             $funcargsdecRet.add(vardec2); } )* )? RPAR ;

//todo // +
functionArguments returns[ArrayList<Expression> funcArgs]:
    { $funcArgs = new ArrayList<Expression>(); }
    (exp1 = expression { $funcArgs.add($exp1.exprRet); }
    (COMMA exp2 = expression
    {   if ($exp2.text != null)
            $funcArgs.add($exp2.exprRet);
    } )*)?;

//todo // +
body returns [Statement bdyRet]:
     ( blckstmtm = blockStatement {$bdyRet = $blckstmtm.blckstmtRet; })
       | (NEWLINE+ sstmt = singleStatement { $bdyRet = $sstmt.snglstmtRet; } (SEMICOLON)?);

//todo // +
loopCondBody returns[Statement lpcndbdRet]:
     ( blckstmt = blockStatement { $lpcndbdRet = $blckstmt.blckstmtRet; }
       | (NEWLINE+ sstmt = singleStatement { $lpcndbdRet = $sstmt.snglstmtRet; } ));

//todo // +
blockStatement returns[BlockStmt blckstmtRet]:
    { $blckstmtRet = new BlockStmt(); }
    BEGIN { $blckstmtRet.setLine($BEGIN.getLine()); }
    (NEWLINE+ (sstmt1 = singleStatement SEMICOLON
    { $blckstmtRet.addStatement($sstmt1.snglstmtRet); } )*
    sstmt2 = singleStatement { $blckstmtRet.addStatement($sstmt2.snglstmtRet); }
     (SEMICOLON)?)+ NEWLINE+ END;

//todo // +
varDecStatement returns[VarDecStmt vardecstmtRet]:
    { $vardecstmtRet = new VarDecStmt(); }
    t = type id1 = identifier { VariableDeclaration vardec1 = new VariableDeclaration($id1.idRet, $t.typeRet);
                                vardec1.setLine($id1.idRet.getLine()); }
    (ASSIGN exp1 = orExpression { vardec1.setDefaultValue($exp1.orExprRet); } )?
                                { $vardecstmtRet.addVar(vardec1); }
    (COMMA id2 = identifier  { VariableDeclaration vardec2 = new VariableDeclaration($id2.idRet, $t.typeRet);
                               vardec2.setLine($id2.idRet.getLine()); }
    (ASSIGN exp2 = orExpression { vardec2.setDefaultValue($exp2.orExprRet); } )?
                                   { $vardecstmtRet.addVar(vardec2); }   )*
                                   { $vardecstmtRet.setLine($id1.idRet.getLine()); };

//todo // + ?
functionCallStmt returns[FunctionCallStmt funccallstmtRet] locals[Expression expr]:
     otexp = otherExpression { $expr = $otexp.otherExprRet; }
     ( (lpar1 = LPAR fargs1 = functionArguments RPAR
        { $expr = new FunctionCall($expr, $fargs1.funcArgs);
          $expr.setLine($lpar1.getLine()); } )
       | (DOT id1 = identifier { $expr = new StructAccess($expr, $id1.idRet);
                                 $expr.setLine($DOT.getLine()); } ))*
     (lpar2 = LPAR fargs2 = functionArguments RPAR)
     { FunctionCall fcall = new FunctionCall($expr, $fargs2.funcArgs);
       fcall.setLine($lpar2.getLine());
       $funccallstmtRet = new FunctionCallStmt(fcall);
       $funccallstmtRet.setLine(fcall.getLine()); };

//todo // +
returnStatement returns[ReturnStmt returnstmtRet]:
    RETURN {$returnstmtRet = new ReturnStmt(); } (exp = expression { $returnstmtRet.setReturnedExpr($exp.exprRet); } )?
    {$returnstmtRet.setLine($RETURN.getLine()); };

//todo // +
ifStatement returns [ConditionalStmt ifRet]:
    IF exp = expression { $ifRet = new ConditionalStmt($exp.exprRet);
                          $ifRet.setLine($IF.getLine()); }
    (lpcndbdy = loopCondBody { $ifRet.setThenBody($lpcndbdy.lpcndbdRet); }
    | bdy = body { $ifRet.setThenBody($bdy.bdyRet); }
      elsestmt = elseStatement { $ifRet.setElseBody($elsestmt.elsestmtRet); } );

//todo // +
elseStatement returns[Statement elsestmtRet]:
     NEWLINE* ELSE lpcndbdy = loopCondBody { $elsestmtRet = $lpcndbdy.lpcndbdRet; } ;

//todo // +
loopStatement returns[LoopStmt lpstmtRet]:
    wlstmt = whileLoopStatement { $lpstmtRet = $wlstmt.whllpstmtRet;
                                   }
    | dwlstmt = doWhileLoopStatement { $lpstmtRet = $dwlstmt.dowhllpstmtRet;
                                        } ;

//todo // +
whileLoopStatement returns[LoopStmt whllpstmtRet]:
    { $whllpstmtRet = new LoopStmt(); }
    WHILE exp = expression lpcbdy = loopCondBody
    { $whllpstmtRet.setCondition($exp.exprRet);
      $whllpstmtRet.setBody($lpcbdy.lpcndbdRet);
      $whllpstmtRet.setLine($WHILE.getLine());
      $whllpstmtRet.setIs_do_while(false); } ;

//todo // +
doWhileLoopStatement returns[LoopStmt dowhllpstmtRet]:
    { $dowhllpstmtRet = new LoopStmt(); }
    DO bdy = body NEWLINE* WHILE exp = expression
    { $dowhllpstmtRet.setCondition($exp.exprRet);
      $dowhllpstmtRet.setBody($bdy.bdyRet);
      $dowhllpstmtRet.setLine($DO.getLine());
      $dowhllpstmtRet.setIs_do_while(true); };

//todo // +
displayStatement returns [DisplayStmt displaystmtRet]:
    DISPLAY LPAR expr = expression
      { $displaystmtRet = new DisplayStmt($expr.exprRet);
        $displaystmtRet.setLine($DISPLAY.getLine()); } RPAR;


//todo // +
assignmentStatement returns [AssignmentStmt assignstmtRet]:
    orexp = orExpression ASSIGN exp = expression
    { $assignstmtRet = new AssignmentStmt($orexp.orExprRet, $exp.exprRet);
      $assignstmtRet.setLine($ASSIGN.getLine()); } ;

//todo // +
singleStatement returns [Statement snglstmtRet]:
      ifstmt = ifStatement { $snglstmtRet = $ifstmt.ifRet; }
    | dsplystmt = displayStatement { $snglstmtRet = $dsplystmt.displaystmtRet; }
    | fcstmt = functionCallStmt { $snglstmtRet = $fcstmt.funccallstmtRet; }
    | rtrnstmt = returnStatement { $snglstmtRet = $rtrnstmt.returnstmtRet; }
    | assgnstmt = assignmentStatement { $snglstmtRet = $assgnstmt.assignstmtRet; }
    | vardecstmt = varDecStatement { $snglstmtRet = $vardecstmt.vardecstmtRet; }
    | lpstmt = loopStatement { $snglstmtRet = $lpstmt.lpstmtRet; }
    | apnd = append { $snglstmtRet = new ListAppendStmt($apnd.appendRet);
                       $snglstmtRet.setLine($apnd.appendRet.getLine());     }
    | sz = size { $snglstmtRet = new ListSizeStmt($sz.sizeRet);
                   $snglstmtRet.setLine($sz.sizeRet.getLine());   } ;

//todo // +
expression returns[Expression exprRet]:
    oexpr = orExpression { $exprRet = $oexpr.orExprRet; }
    (ASSIGN expr = expression
    { $exprRet = new BinaryExpression($exprRet, $expr.exprRet, BinaryOperator.assign);
      $exprRet.setLine($ASSIGN.getLine());} )? ;


//todo // +
orExpression returns[Expression orExprRet]:
    aexpr1 = andExpression {$orExprRet = $aexpr1.andExprRet;}
         (OR aexpr2 = andExpression
         { $orExprRet = new BinaryExpression($orExprRet,$aexpr2.andExprRet,BinaryOperator.or);
              $orExprRet.setLine($OR.getLine()); } )*;

//todo // +
andExpression returns[Expression andExprRet]:
    eexpr1 = equalityExpression {$andExprRet = $eexpr1.equalExprRet;}
    (AND eexpr2 = equalityExpression
    { $andExprRet = new BinaryExpression($andExprRet, $eexpr2.equalExprRet, BinaryOperator.and);
      $andExprRet.setLine($AND.getLine()); } )*;

//todo // +
equalityExpression returns[Expression equalExprRet]:
    rel1 = relationalExpression {$equalExprRet = $rel1.relExprRet;}
    (EQUAL rel2 = relationalExpression
    { $equalExprRet = new BinaryExpression($equalExprRet, $rel2.relExprRet, BinaryOperator.eq);
      $equalExprRet.setLine($EQUAL.getLine()); } )*;

//todo // +
relationalExpression returns[Expression relExprRet]:
    add1 = additiveExpression { $relExprRet = $add1.addExprRet; }
    { BinaryOperator relop; int line; }
    ( (GREATER_THAN { relop = BinaryOperator.gt; line = $GREATER_THAN.getLine(); }
      | LESS_THAN { relop = BinaryOperator.lt; line = $LESS_THAN.getLine(); } )
      add2 = additiveExpression
      { $relExprRet = new BinaryExpression($relExprRet, $add2.addExprRet, relop);
        $relExprRet.setLine(line); } )*;

//todo // +
additiveExpression returns[Expression addExprRet]:
    mult1 = multiplicativeExpression { $addExprRet = $mult1.multExprRet; }
    { BinaryOperator addop; int line; }
    ( (PLUS { addop = BinaryOperator.add; line = $PLUS.getLine(); }
      | MINUS { addop = BinaryOperator.sub; line = $MINUS.getLine(); } )
      mult2 = multiplicativeExpression
      { $addExprRet = new BinaryExpression($addExprRet, $mult2.multExprRet, addop);
        $addExprRet.setLine(line); } )*;

//todo // +
multiplicativeExpression returns[Expression multExprRet]:
    pre1 = preUnaryExpression { $multExprRet = $pre1.puExpRet; }
    { BinaryOperator multop; int line; }
    ( (MULT { multop = BinaryOperator.mult; line = $MULT.getLine(); }
      | DIVIDE { multop = BinaryOperator.div; line = $DIVIDE.getLine(); } )
      pre2 = preUnaryExpression
      { $multExprRet = new BinaryExpression($multExprRet, $pre2.puExpRet, multop);
        $multExprRet.setLine(line); } )*;

//todo // +
preUnaryExpression returns [Expression puExpRet]:
    { UnaryOperator preop; int line; }
    ( ( NOT { preop = UnaryOperator.not; line = $NOT.getLine(); }
      | MINUS { preop = UnaryOperator.minus; line = $MINUS.getLine(); } )
      prun = preUnaryExpression
      { $puExpRet = new UnaryExpression($prun.puExpRet, preop);
        $puExpRet.setLine(line); } )
    | acs = accessExpression { $puExpRet = $acs.acsExpRet; } ;

//todo // +
accessExpression returns [Expression acsExpRet]:
    othexpr = otherExpression { $acsExpRet = $othexpr.otherExprRet; }
    ( (LPAR fargs = functionArguments RPAR
       { $acsExpRet = new FunctionCall($acsExpRet, $fargs.funcArgs);
         $acsExpRet.setLine($LPAR.getLine()); } )
       | (DOT id1 = identifier { $acsExpRet = new StructAccess($acsExpRet, $id1.idRet);
                                $acsExpRet.setLine($DOT.getLine()); } ))*
       ( (LBRACK expr = expression RBRACK
           { $acsExpRet = new ListAccessByIndex($acsExpRet, $expr.exprRet);
             $acsExpRet.setLine($LBRACK.getLine()); } )
            | (DOT id2 = identifier { $acsExpRet = new StructAccess($acsExpRet, $id2.idRet);
                                      $acsExpRet.setLine($DOT.getLine()); } ))*;

//todo // +
otherExpression returns [Expression otherExprRet]:
      val = value { $otherExprRet = $val.valRet; }
    | idtfr = identifier { $otherExprRet = $idtfr.idRet; }
    | LPAR (fargs = functionArguments) RPAR
      { $otherExprRet = new ExprInPar($fargs.funcArgs);
        $otherExprRet.setLine($LPAR.getLine()); }
    | sz = size { $otherExprRet = $sz.sizeRet; }
    | apnd = append { $otherExprRet = $apnd.appendRet; };

//todo // +
size returns [ListSize sizeRet]:
    SIZE LPAR expression {$sizeRet = new ListSize($expression.exprRet);
     $sizeRet.setLine($SIZE.getLine());} RPAR;

//todo // +
append returns [ListAppend appendRet]:
    APPEND LPAR (e1 = expression) COMMA (e2 = expression) RPAR
    { $appendRet = new ListAppend($e1.exprRet, $e2.exprRet);
      $appendRet.setLine($APPEND.getLine()); };

//todo // +
value returns [Value valRet]:
    boolValue {$valRet = $boolValue.boolRet;}
    | INT_VALUE {$valRet = new IntValue($INT_VALUE.int); $valRet.setLine($INT_VALUE.getLine()); };

//todo // +
boolValue returns [BoolValue boolRet]:
    (TRUE {$boolRet = new BoolValue(true); $boolRet.setLine($TRUE.getLine()); })
    | (FALSE {$boolRet = new BoolValue(false); $boolRet.setLine($FALSE.getLine()); });

//todo // +
identifier returns [Identifier idRet]:
    IDENTIFIER {$idRet = new Identifier($IDENTIFIER.getText()); $idRet.setLine($IDENTIFIER.getLine());};


//todo // +
type returns [Type typeRet]:
    (INT {$typeRet = new IntType();})
    | (BOOL {$typeRet = new BoolType();})
    | (LIST SHARP elemType = type {$typeRet = new ListType($elemType.typeRet);})
    | (STRUCT strctName = identifier {$typeRet = new StructType($strctName.idRet);})
    | (fptrType {$typeRet = $fptrType.fptrTypeRet;});

//todo // +
fptrType returns [FptrType fptrTypeRet]:
    FPTR {ArrayList<Type> arrTypes = new ArrayList<>();} LESS_THAN
    (VOID | (t1 = type {arrTypes.add($t1.typeRet);} (COMMA t2 = type {arrTypes.add($t2.typeRet);} )*))
    ARROW (returnType = type | isVoid = VOID) GREATER_THAN
    {
        if ($isVoid.text != null)
            $fptrTypeRet = new FptrType(arrTypes, new VoidType());
        else
            $fptrTypeRet = new FptrType(arrTypes, $returnType.typeRet);
    };


MAIN: 'main';
RETURN: 'return';
VOID: 'void';

SIZE: 'size';
DISPLAY: 'display';
APPEND: 'append';

IF: 'if';
ELSE: 'else';

PLUS: '+';
MINUS: '-';
MULT: '*';
DIVIDE: '/';


EQUAL: '==';
ARROW: '->';
GREATER_THAN: '>';
LESS_THAN: '<';


AND: '&';
OR: '|';
NOT: '~';

TRUE: 'true';
FALSE: 'false';

BEGIN: 'begin';
END: 'end';

INT: 'int';
BOOL: 'bool';
LIST: 'list';
STRUCT: 'struct';
FPTR: 'fptr';
GET: 'get';
SET: 'set';
WHILE: 'while';
DO: 'do';

ASSIGN: '=';
SHARP: '#';
LPAR: '(';
RPAR: ')';
LBRACK: '[';
RBRACK: ']';

COMMA: ',';
DOT: '.';
SEMICOLON: ';';
NEWLINE: '\n';

INT_VALUE: '0' | [1-9][0-9]*;
IDENTIFIER: [a-zA-Z_][A-Za-z0-9_]*;


COMMENT: ('/*' .*? '*/') -> skip;
WS: ([ \t\r]) -> skip;