// Generated from C:/Uni/Term7/PLC/Project/Phase2/Phase2/src/main/grammar\Cmm.g4 by ANTLR 4.9.2
package parsers;

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
 
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CmmParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		MAIN=1, RETURN=2, VOID=3, SIZE=4, DISPLAY=5, APPEND=6, IF=7, ELSE=8, PLUS=9, 
		MINUS=10, MULT=11, DIVIDE=12, EQUAL=13, ARROW=14, GREATER_THAN=15, LESS_THAN=16, 
		AND=17, OR=18, NOT=19, TRUE=20, FALSE=21, BEGIN=22, END=23, INT=24, BOOL=25, 
		LIST=26, STRUCT=27, FPTR=28, GET=29, SET=30, WHILE=31, DO=32, ASSIGN=33, 
		SHARP=34, LPAR=35, RPAR=36, LBRACK=37, RBRACK=38, COMMA=39, DOT=40, SEMICOLON=41, 
		NEWLINE=42, INT_VALUE=43, IDENTIFIER=44, COMMENT=45, WS=46;
	public static final int
		RULE_cmm = 0, RULE_program = 1, RULE_main = 2, RULE_structDeclaration = 3, 
		RULE_singleVarWithGetAndSet = 4, RULE_singleStatementStructBody = 5, RULE_structBody = 6, 
		RULE_getBody = 7, RULE_setBody = 8, RULE_functionDeclaration = 9, RULE_functionArgsDec = 10, 
		RULE_functionArguments = 11, RULE_body = 12, RULE_loopCondBody = 13, RULE_blockStatement = 14, 
		RULE_varDecStatement = 15, RULE_functionCallStmt = 16, RULE_returnStatement = 17, 
		RULE_ifStatement = 18, RULE_elseStatement = 19, RULE_loopStatement = 20, 
		RULE_whileLoopStatement = 21, RULE_doWhileLoopStatement = 22, RULE_displayStatement = 23, 
		RULE_assignmentStatement = 24, RULE_singleStatement = 25, RULE_expression = 26, 
		RULE_orExpression = 27, RULE_andExpression = 28, RULE_equalityExpression = 29, 
		RULE_relationalExpression = 30, RULE_additiveExpression = 31, RULE_multiplicativeExpression = 32, 
		RULE_preUnaryExpression = 33, RULE_accessExpression = 34, RULE_otherExpression = 35, 
		RULE_size = 36, RULE_append = 37, RULE_value = 38, RULE_boolValue = 39, 
		RULE_identifier = 40, RULE_type = 41, RULE_fptrType = 42;
	private static String[] makeRuleNames() {
		return new String[] {
			"cmm", "program", "main", "structDeclaration", "singleVarWithGetAndSet", 
			"singleStatementStructBody", "structBody", "getBody", "setBody", "functionDeclaration", 
			"functionArgsDec", "functionArguments", "body", "loopCondBody", "blockStatement", 
			"varDecStatement", "functionCallStmt", "returnStatement", "ifStatement", 
			"elseStatement", "loopStatement", "whileLoopStatement", "doWhileLoopStatement", 
			"displayStatement", "assignmentStatement", "singleStatement", "expression", 
			"orExpression", "andExpression", "equalityExpression", "relationalExpression", 
			"additiveExpression", "multiplicativeExpression", "preUnaryExpression", 
			"accessExpression", "otherExpression", "size", "append", "value", "boolValue", 
			"identifier", "type", "fptrType"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'main'", "'return'", "'void'", "'size'", "'display'", "'append'", 
			"'if'", "'else'", "'+'", "'-'", "'*'", "'/'", "'=='", "'->'", "'>'", 
			"'<'", "'&'", "'|'", "'~'", "'true'", "'false'", "'begin'", "'end'", 
			"'int'", "'bool'", "'list'", "'struct'", "'fptr'", "'get'", "'set'", 
			"'while'", "'do'", "'='", "'#'", "'('", "')'", "'['", "']'", "','", "'.'", 
			"';'", "'\n'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "MAIN", "RETURN", "VOID", "SIZE", "DISPLAY", "APPEND", "IF", "ELSE", 
			"PLUS", "MINUS", "MULT", "DIVIDE", "EQUAL", "ARROW", "GREATER_THAN", 
			"LESS_THAN", "AND", "OR", "NOT", "TRUE", "FALSE", "BEGIN", "END", "INT", 
			"BOOL", "LIST", "STRUCT", "FPTR", "GET", "SET", "WHILE", "DO", "ASSIGN", 
			"SHARP", "LPAR", "RPAR", "LBRACK", "RBRACK", "COMMA", "DOT", "SEMICOLON", 
			"NEWLINE", "INT_VALUE", "IDENTIFIER", "COMMENT", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Cmm.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CmmParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class CmmContext extends ParserRuleContext {
		public Program cmmProgram;
		public ProgramContext p;
		public TerminalNode EOF() { return getToken(CmmParser.EOF, 0); }
		public ProgramContext program() {
			return getRuleContext(ProgramContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(CmmParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(CmmParser.NEWLINE, i);
		}
		public CmmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterCmm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitCmm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitCmm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmmContext cmm() throws RecognitionException {
		CmmContext _localctx = new CmmContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_cmm);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(86);
				match(NEWLINE);
				}
				}
				setState(91);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(92);
			((CmmContext)_localctx).p = program();
			((CmmContext)_localctx).cmmProgram =  ((CmmContext)_localctx).p.programRet;
			setState(97);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(94);
				match(NEWLINE);
				}
				}
				setState(99);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(100);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProgramContext extends ParserRuleContext {
		public Program programRet;
		public StructDeclarationContext s;
		public FunctionDeclarationContext f;
		public MainContext m;
		public MainContext main() {
			return getRuleContext(MainContext.class,0);
		}
		public List<StructDeclarationContext> structDeclaration() {
			return getRuleContexts(StructDeclarationContext.class);
		}
		public StructDeclarationContext structDeclaration(int i) {
			return getRuleContext(StructDeclarationContext.class,i);
		}
		public List<FunctionDeclarationContext> functionDeclaration() {
			return getRuleContexts(FunctionDeclarationContext.class);
		}
		public FunctionDeclarationContext functionDeclaration(int i) {
			return getRuleContext(FunctionDeclarationContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_program);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			((ProgramContext)_localctx).programRet =  new Program();
			     int line = 1;
			     _localctx.programRet.setLine(line);
			setState(108);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(103);
					((ProgramContext)_localctx).s = structDeclaration();
					_localctx.programRet.addStruct(((ProgramContext)_localctx).s.structDeclarationRet);
					}
					} 
				}
				setState(110);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			setState(116);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << VOID) | (1L << INT) | (1L << BOOL) | (1L << LIST) | (1L << STRUCT) | (1L << FPTR))) != 0)) {
				{
				{
				setState(111);
				((ProgramContext)_localctx).f = functionDeclaration();
				_localctx.programRet.addFunction(((ProgramContext)_localctx).f.functionDeclarationRet);
				}
				}
				setState(118);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(119);
			((ProgramContext)_localctx).m = main();
			_localctx.programRet.setMain(((ProgramContext)_localctx).m.mainRet);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MainContext extends ParserRuleContext {
		public MainDeclaration mainRet;
		public Token MAIN;
		public BodyContext bdy;
		public TerminalNode MAIN() { return getToken(CmmParser.MAIN, 0); }
		public TerminalNode LPAR() { return getToken(CmmParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(CmmParser.RPAR, 0); }
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public MainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterMain(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitMain(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitMain(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MainContext main() throws RecognitionException {
		MainContext _localctx = new MainContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_main);
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((MainContext)_localctx).mainRet =  new MainDeclaration(); 
			setState(123);
			((MainContext)_localctx).MAIN = match(MAIN);
			setState(124);
			match(LPAR);
			setState(125);
			match(RPAR);
			setState(126);
			((MainContext)_localctx).bdy = body();
			_localctx.mainRet.setBody(((MainContext)_localctx).bdy.bdyRet);
			                               _localctx.mainRet.setLine(((MainContext)_localctx).MAIN.getLine()); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StructDeclarationContext extends ParserRuleContext {
		public StructDeclaration structDeclarationRet;
		public Token STRUCT;
		public IdentifierContext id;
		public Token BEGIN;
		public StructBodyContext strctbdy;
		public SingleStatementStructBodyContext stmtbdy;
		public TerminalNode STRUCT() { return getToken(CmmParser.STRUCT, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(CmmParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(CmmParser.NEWLINE, i);
		}
		public TerminalNode BEGIN() { return getToken(CmmParser.BEGIN, 0); }
		public TerminalNode END() { return getToken(CmmParser.END, 0); }
		public StructBodyContext structBody() {
			return getRuleContext(StructBodyContext.class,0);
		}
		public SingleStatementStructBodyContext singleStatementStructBody() {
			return getRuleContext(SingleStatementStructBodyContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(CmmParser.SEMICOLON, 0); }
		public StructDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterStructDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitStructDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitStructDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructDeclarationContext structDeclaration() throws RecognitionException {
		StructDeclarationContext _localctx = new StructDeclarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_structDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((StructDeclarationContext)_localctx).structDeclarationRet =  new StructDeclaration(); 
			setState(130);
			((StructDeclarationContext)_localctx).STRUCT = match(STRUCT);
			setState(131);
			((StructDeclarationContext)_localctx).id = identifier();
			 _localctx.structDeclarationRet.setLine(((StructDeclarationContext)_localctx).STRUCT.getLine());
			                             _localctx.structDeclarationRet.setStructName(((StructDeclarationContext)_localctx).id.idRet); 
			setState(154);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BEGIN:
				{
				{
				setState(133);
				((StructDeclarationContext)_localctx).BEGIN = match(BEGIN);
				setState(134);
				((StructDeclarationContext)_localctx).strctbdy = structBody();
				setState(136); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(135);
					match(NEWLINE);
					}
					}
					setState(138); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				setState(140);
				match(END);
				 _localctx.structDeclarationRet.setBody(((StructDeclarationContext)_localctx).strctbdy.strctbdyRet);
				                                                 ((StructDeclarationContext)_localctx).strctbdy.strctbdyRet.setLine(((StructDeclarationContext)_localctx).BEGIN.getLine());   
				}
				}
				break;
			case NEWLINE:
				{
				{
				setState(144); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(143);
					match(NEWLINE);
					}
					}
					setState(146); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				setState(148);
				((StructDeclarationContext)_localctx).stmtbdy = singleStatementStructBody();
				setState(150);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(149);
					match(SEMICOLON);
					}
				}

				 _localctx.structDeclarationRet.setBody(((StructDeclarationContext)_localctx).stmtbdy.sstmtstrctbdyRet); 
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(157); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(156);
				match(NEWLINE);
				}
				}
				setState(159); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SingleVarWithGetAndSetContext extends ParserRuleContext {
		public SetGetVarDeclaration svargetsetRet;
		public TypeContext tp;
		public IdentifierContext idtf;
		public FunctionArgsDecContext fncargdec;
		public SetBodyContext sbdy;
		public GetBodyContext gbdy;
		public TerminalNode BEGIN() { return getToken(CmmParser.BEGIN, 0); }
		public TerminalNode END() { return getToken(CmmParser.END, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public FunctionArgsDecContext functionArgsDec() {
			return getRuleContext(FunctionArgsDecContext.class,0);
		}
		public SetBodyContext setBody() {
			return getRuleContext(SetBodyContext.class,0);
		}
		public GetBodyContext getBody() {
			return getRuleContext(GetBodyContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(CmmParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(CmmParser.NEWLINE, i);
		}
		public SingleVarWithGetAndSetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleVarWithGetAndSet; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterSingleVarWithGetAndSet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitSingleVarWithGetAndSet(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitSingleVarWithGetAndSet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SingleVarWithGetAndSetContext singleVarWithGetAndSet() throws RecognitionException {
		SingleVarWithGetAndSetContext _localctx = new SingleVarWithGetAndSetContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_singleVarWithGetAndSet);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((SingleVarWithGetAndSetContext)_localctx).svargetsetRet =  new SetGetVarDeclaration(); 
			setState(162);
			((SingleVarWithGetAndSetContext)_localctx).tp = type();
			 _localctx.svargetsetRet.setVarType(((SingleVarWithGetAndSetContext)_localctx).tp.typeRet); 
			setState(164);
			((SingleVarWithGetAndSetContext)_localctx).idtf = identifier();
			 _localctx.svargetsetRet.setVarName(((SingleVarWithGetAndSetContext)_localctx).idtf.idRet);
			                        _localctx.svargetsetRet.setLine(((SingleVarWithGetAndSetContext)_localctx).idtf.idRet.getLine()); 
			setState(166);
			((SingleVarWithGetAndSetContext)_localctx).fncargdec = functionArgsDec();
			 _localctx.svargetsetRet.setArgs(((SingleVarWithGetAndSetContext)_localctx).fncargdec.funcargsdecRet); 
			setState(168);
			match(BEGIN);
			setState(170); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(169);
				match(NEWLINE);
				}
				}
				setState(172); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(174);
			((SingleVarWithGetAndSetContext)_localctx).sbdy = setBody();
			 _localctx.svargetsetRet.setSetterBody(((SingleVarWithGetAndSetContext)_localctx).sbdy.setbdyRet); 
			setState(176);
			((SingleVarWithGetAndSetContext)_localctx).gbdy = getBody();
			 _localctx.svargetsetRet.setGetterBody(((SingleVarWithGetAndSetContext)_localctx).gbdy.getbdyRet); 
			setState(178);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SingleStatementStructBodyContext extends ParserRuleContext {
		public Statement sstmtstrctbdyRet;
		public VarDecStatementContext vrdcstmt;
		public SingleVarWithGetAndSetContext svrwthGS;
		public VarDecStatementContext varDecStatement() {
			return getRuleContext(VarDecStatementContext.class,0);
		}
		public SingleVarWithGetAndSetContext singleVarWithGetAndSet() {
			return getRuleContext(SingleVarWithGetAndSetContext.class,0);
		}
		public SingleStatementStructBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleStatementStructBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterSingleStatementStructBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitSingleStatementStructBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitSingleStatementStructBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SingleStatementStructBodyContext singleStatementStructBody() throws RecognitionException {
		SingleStatementStructBodyContext _localctx = new SingleStatementStructBodyContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_singleStatementStructBody);
		try {
			setState(186);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(180);
				((SingleStatementStructBodyContext)_localctx).vrdcstmt = varDecStatement();
				 ((SingleStatementStructBodyContext)_localctx).sstmtstrctbdyRet =  ((SingleStatementStructBodyContext)_localctx).vrdcstmt.vardecstmtRet; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(183);
				((SingleStatementStructBodyContext)_localctx).svrwthGS = singleVarWithGetAndSet();
				 ((SingleStatementStructBodyContext)_localctx).sstmtstrctbdyRet =  ((SingleStatementStructBodyContext)_localctx).svrwthGS.svargetsetRet; 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StructBodyContext extends ParserRuleContext {
		public BlockStmt strctbdyRet;
		public SingleStatementStructBodyContext stmtsbdy1;
		public SingleStatementStructBodyContext stmtsbdy2;
		public List<SingleStatementStructBodyContext> singleStatementStructBody() {
			return getRuleContexts(SingleStatementStructBodyContext.class);
		}
		public SingleStatementStructBodyContext singleStatementStructBody(int i) {
			return getRuleContext(SingleStatementStructBodyContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(CmmParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(CmmParser.NEWLINE, i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(CmmParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(CmmParser.SEMICOLON, i);
		}
		public StructBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterStructBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitStructBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitStructBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructBodyContext structBody() throws RecognitionException {
		StructBodyContext _localctx = new StructBodyContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_structBody);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			 ((StructBodyContext)_localctx).strctbdyRet =  new BlockStmt(); 
			setState(208); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(190); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(189);
						match(NEWLINE);
						}
						}
						setState(192); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==NEWLINE );
					setState(200);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(194);
							((StructBodyContext)_localctx).stmtsbdy1 = singleStatementStructBody();
							setState(195);
							match(SEMICOLON);
							 _localctx.strctbdyRet.addStatement(((StructBodyContext)_localctx).stmtsbdy1.sstmtstrctbdyRet); 
							}
							} 
						}
						setState(202);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
					}
					setState(203);
					((StructBodyContext)_localctx).stmtsbdy2 = singleStatementStructBody();
					 _localctx.strctbdyRet.addStatement(((StructBodyContext)_localctx).stmtsbdy2.sstmtstrctbdyRet); 
					setState(206);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SEMICOLON) {
						{
						setState(205);
						match(SEMICOLON);
						}
					}

					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(210); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GetBodyContext extends ParserRuleContext {
		public Statement getbdyRet;
		public BodyContext bdy;
		public TerminalNode GET() { return getToken(CmmParser.GET, 0); }
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(CmmParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(CmmParser.NEWLINE, i);
		}
		public GetBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_getBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterGetBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitGetBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitGetBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GetBodyContext getBody() throws RecognitionException {
		GetBodyContext _localctx = new GetBodyContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_getBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			match(GET);
			setState(213);
			((GetBodyContext)_localctx).bdy = body();
			 ((GetBodyContext)_localctx).getbdyRet =  ((GetBodyContext)_localctx).bdy.bdyRet; 
			setState(216); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(215);
				match(NEWLINE);
				}
				}
				setState(218); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SetBodyContext extends ParserRuleContext {
		public Statement setbdyRet;
		public BodyContext bdy;
		public TerminalNode SET() { return getToken(CmmParser.SET, 0); }
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(CmmParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(CmmParser.NEWLINE, i);
		}
		public SetBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterSetBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitSetBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitSetBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SetBodyContext setBody() throws RecognitionException {
		SetBodyContext _localctx = new SetBodyContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_setBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220);
			match(SET);
			setState(221);
			((SetBodyContext)_localctx).bdy = body();
			 ((SetBodyContext)_localctx).setbdyRet =  ((SetBodyContext)_localctx).bdy.bdyRet; 
			setState(224); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(223);
				match(NEWLINE);
				}
				}
				setState(226); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionDeclarationContext extends ParserRuleContext {
		public FunctionDeclaration functionDeclarationRet;
		public TypeContext t;
		public IdentifierContext id;
		public FunctionArgsDecContext fargsdec;
		public BodyContext bdy;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public FunctionArgsDecContext functionArgsDec() {
			return getRuleContext(FunctionArgsDecContext.class,0);
		}
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public TerminalNode VOID() { return getToken(CmmParser.VOID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(CmmParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(CmmParser.NEWLINE, i);
		}
		public FunctionDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterFunctionDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitFunctionDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitFunctionDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDeclarationContext functionDeclaration() throws RecognitionException {
		FunctionDeclarationContext _localctx = new FunctionDeclarationContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_functionDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((FunctionDeclarationContext)_localctx).functionDeclarationRet =  new FunctionDeclaration(); 
			setState(234);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case BOOL:
			case LIST:
			case STRUCT:
			case FPTR:
				{
				setState(229);
				((FunctionDeclarationContext)_localctx).t = type();
				 _localctx.functionDeclarationRet.setReturnType(((FunctionDeclarationContext)_localctx).t.typeRet); 
				}
				break;
			case VOID:
				{
				setState(232);
				match(VOID);
				 _localctx.functionDeclarationRet.setReturnType(new VoidType()); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(236);
			((FunctionDeclarationContext)_localctx).id = identifier();
			   _localctx.functionDeclarationRet.setFunctionName(((FunctionDeclarationContext)_localctx).id.idRet);
			                        _localctx.functionDeclarationRet.setLine(((FunctionDeclarationContext)_localctx).id.idRet.getLine()); 
			setState(238);
			((FunctionDeclarationContext)_localctx).fargsdec = functionArgsDec();
			 _localctx.functionDeclarationRet.setArgs(((FunctionDeclarationContext)_localctx).fargsdec.funcargsdecRet); 
			setState(240);
			((FunctionDeclarationContext)_localctx).bdy = body();
			 _localctx.functionDeclarationRet.setBody(((FunctionDeclarationContext)_localctx).bdy.bdyRet); 
			setState(243); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(242);
				match(NEWLINE);
				}
				}
				setState(245); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionArgsDecContext extends ParserRuleContext {
		public ArrayList<VariableDeclaration> funcargsdecRet;
		public TypeContext tp1;
		public IdentifierContext idf1;
		public TypeContext tp2;
		public IdentifierContext idf2;
		public TerminalNode LPAR() { return getToken(CmmParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(CmmParser.RPAR, 0); }
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(CmmParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CmmParser.COMMA, i);
		}
		public FunctionArgsDecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionArgsDec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterFunctionArgsDec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitFunctionArgsDec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitFunctionArgsDec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionArgsDecContext functionArgsDec() throws RecognitionException {
		FunctionArgsDecContext _localctx = new FunctionArgsDecContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_functionArgsDec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((FunctionArgsDecContext)_localctx).funcargsdecRet =  new ArrayList<VariableDeclaration>(); 
			setState(248);
			match(LPAR);
			setState(262);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << LIST) | (1L << STRUCT) | (1L << FPTR))) != 0)) {
				{
				setState(249);
				((FunctionArgsDecContext)_localctx).tp1 = type();
				setState(250);
				((FunctionArgsDecContext)_localctx).idf1 = identifier();
				 VariableDeclaration vardec1 = new VariableDeclaration(((FunctionArgsDecContext)_localctx).idf1.idRet, ((FunctionArgsDecContext)_localctx).tp1.typeRet);
				      vardec1.setLine(((FunctionArgsDecContext)_localctx).idf1.idRet.getLine());
				      _localctx.funcargsdecRet.add(vardec1); 
				setState(259);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(252);
					match(COMMA);
					setState(253);
					((FunctionArgsDecContext)_localctx).tp2 = type();
					setState(254);
					((FunctionArgsDecContext)_localctx).idf2 = identifier();
					 VariableDeclaration vardec2 = new VariableDeclaration(((FunctionArgsDecContext)_localctx).idf2.idRet, ((FunctionArgsDecContext)_localctx).tp2.typeRet);
					             vardec2.setLine(((FunctionArgsDecContext)_localctx).idf2.idRet.getLine());
					             _localctx.funcargsdecRet.add(vardec2); 
					}
					}
					setState(261);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(264);
			match(RPAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionArgumentsContext extends ParserRuleContext {
		public ArrayList<Expression> funcArgs;
		public ExpressionContext exp1;
		public ExpressionContext exp2;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(CmmParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CmmParser.COMMA, i);
		}
		public FunctionArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionArguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterFunctionArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitFunctionArguments(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitFunctionArguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionArgumentsContext functionArguments() throws RecognitionException {
		FunctionArgumentsContext _localctx = new FunctionArgumentsContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_functionArguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((FunctionArgumentsContext)_localctx).funcArgs =  new ArrayList<Expression>(); 
			setState(278);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SIZE) | (1L << APPEND) | (1L << MINUS) | (1L << NOT) | (1L << TRUE) | (1L << FALSE) | (1L << LPAR) | (1L << INT_VALUE) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(267);
				((FunctionArgumentsContext)_localctx).exp1 = expression();
				 _localctx.funcArgs.add(((FunctionArgumentsContext)_localctx).exp1.exprRet); 
				setState(275);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(269);
					match(COMMA);
					setState(270);
					((FunctionArgumentsContext)_localctx).exp2 = expression();
					   if ((((FunctionArgumentsContext)_localctx).exp2!=null?_input.getText(((FunctionArgumentsContext)_localctx).exp2.start,((FunctionArgumentsContext)_localctx).exp2.stop):null) != null)
					            _localctx.funcArgs.add(((FunctionArgumentsContext)_localctx).exp2.exprRet);
					    
					}
					}
					setState(277);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BodyContext extends ParserRuleContext {
		public Statement bdyRet;
		public BlockStatementContext blckstmtm;
		public SingleStatementContext sstmt;
		public BlockStatementContext blockStatement() {
			return getRuleContext(BlockStatementContext.class,0);
		}
		public SingleStatementContext singleStatement() {
			return getRuleContext(SingleStatementContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(CmmParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(CmmParser.NEWLINE, i);
		}
		public TerminalNode SEMICOLON() { return getToken(CmmParser.SEMICOLON, 0); }
		public BodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_body);
		int _la;
		try {
			setState(293);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BEGIN:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(280);
				((BodyContext)_localctx).blckstmtm = blockStatement();
				((BodyContext)_localctx).bdyRet =  ((BodyContext)_localctx).blckstmtm.blckstmtRet; 
				}
				}
				break;
			case NEWLINE:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(284); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(283);
					match(NEWLINE);
					}
					}
					setState(286); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				setState(288);
				((BodyContext)_localctx).sstmt = singleStatement();
				 ((BodyContext)_localctx).bdyRet =  ((BodyContext)_localctx).sstmt.snglstmtRet; 
				setState(291);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(290);
					match(SEMICOLON);
					}
				}

				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LoopCondBodyContext extends ParserRuleContext {
		public Statement lpcndbdRet;
		public BlockStatementContext blckstmt;
		public SingleStatementContext sstmt;
		public BlockStatementContext blockStatement() {
			return getRuleContext(BlockStatementContext.class,0);
		}
		public SingleStatementContext singleStatement() {
			return getRuleContext(SingleStatementContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(CmmParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(CmmParser.NEWLINE, i);
		}
		public LoopCondBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loopCondBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterLoopCondBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitLoopCondBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitLoopCondBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LoopCondBodyContext loopCondBody() throws RecognitionException {
		LoopCondBodyContext _localctx = new LoopCondBodyContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_loopCondBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(306);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BEGIN:
				{
				setState(295);
				((LoopCondBodyContext)_localctx).blckstmt = blockStatement();
				 ((LoopCondBodyContext)_localctx).lpcndbdRet =  ((LoopCondBodyContext)_localctx).blckstmt.blckstmtRet; 
				}
				break;
			case NEWLINE:
				{
				{
				setState(299); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(298);
					match(NEWLINE);
					}
					}
					setState(301); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				setState(303);
				((LoopCondBodyContext)_localctx).sstmt = singleStatement();
				 ((LoopCondBodyContext)_localctx).lpcndbdRet =  ((LoopCondBodyContext)_localctx).sstmt.snglstmtRet; 
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockStatementContext extends ParserRuleContext {
		public BlockStmt blckstmtRet;
		public Token BEGIN;
		public SingleStatementContext sstmt1;
		public SingleStatementContext sstmt2;
		public TerminalNode BEGIN() { return getToken(CmmParser.BEGIN, 0); }
		public TerminalNode END() { return getToken(CmmParser.END, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(CmmParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(CmmParser.NEWLINE, i);
		}
		public List<SingleStatementContext> singleStatement() {
			return getRuleContexts(SingleStatementContext.class);
		}
		public SingleStatementContext singleStatement(int i) {
			return getRuleContext(SingleStatementContext.class,i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(CmmParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(CmmParser.SEMICOLON, i);
		}
		public BlockStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterBlockStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitBlockStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitBlockStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockStatementContext blockStatement() throws RecognitionException {
		BlockStatementContext _localctx = new BlockStatementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_blockStatement);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			 ((BlockStatementContext)_localctx).blckstmtRet =  new BlockStmt(); 
			setState(309);
			((BlockStatementContext)_localctx).BEGIN = match(BEGIN);
			 _localctx.blckstmtRet.setLine(((BlockStatementContext)_localctx).BEGIN.getLine()); 
			setState(330); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(312); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(311);
						match(NEWLINE);
						}
						}
						setState(314); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==NEWLINE );
					setState(322);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(316);
							((BlockStatementContext)_localctx).sstmt1 = singleStatement();
							setState(317);
							match(SEMICOLON);
							 _localctx.blckstmtRet.addStatement(((BlockStatementContext)_localctx).sstmt1.snglstmtRet); 
							}
							} 
						}
						setState(324);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
					}
					setState(325);
					((BlockStatementContext)_localctx).sstmt2 = singleStatement();
					 _localctx.blckstmtRet.addStatement(((BlockStatementContext)_localctx).sstmt2.snglstmtRet); 
					setState(328);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SEMICOLON) {
						{
						setState(327);
						match(SEMICOLON);
						}
					}

					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(332); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(335); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(334);
				match(NEWLINE);
				}
				}
				setState(337); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(339);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarDecStatementContext extends ParserRuleContext {
		public VarDecStmt vardecstmtRet;
		public TypeContext t;
		public IdentifierContext id1;
		public OrExpressionContext exp1;
		public IdentifierContext id2;
		public OrExpressionContext exp2;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<TerminalNode> ASSIGN() { return getTokens(CmmParser.ASSIGN); }
		public TerminalNode ASSIGN(int i) {
			return getToken(CmmParser.ASSIGN, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(CmmParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CmmParser.COMMA, i);
		}
		public List<OrExpressionContext> orExpression() {
			return getRuleContexts(OrExpressionContext.class);
		}
		public OrExpressionContext orExpression(int i) {
			return getRuleContext(OrExpressionContext.class,i);
		}
		public VarDecStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDecStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterVarDecStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitVarDecStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitVarDecStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDecStatementContext varDecStatement() throws RecognitionException {
		VarDecStatementContext _localctx = new VarDecStatementContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_varDecStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((VarDecStatementContext)_localctx).vardecstmtRet =  new VarDecStmt(); 
			setState(342);
			((VarDecStatementContext)_localctx).t = type();
			setState(343);
			((VarDecStatementContext)_localctx).id1 = identifier();
			 VariableDeclaration vardec1 = new VariableDeclaration(((VarDecStatementContext)_localctx).id1.idRet, ((VarDecStatementContext)_localctx).t.typeRet);
			                                vardec1.setLine(((VarDecStatementContext)_localctx).id1.idRet.getLine()); 
			setState(349);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(345);
				match(ASSIGN);
				setState(346);
				((VarDecStatementContext)_localctx).exp1 = orExpression();
				 vardec1.setDefaultValue(((VarDecStatementContext)_localctx).exp1.orExprRet); 
				}
			}

			 _localctx.vardecstmtRet.addVar(vardec1); 
			setState(365);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(352);
				match(COMMA);
				setState(353);
				((VarDecStatementContext)_localctx).id2 = identifier();
				 VariableDeclaration vardec2 = new VariableDeclaration(((VarDecStatementContext)_localctx).id2.idRet, ((VarDecStatementContext)_localctx).t.typeRet);
				                               vardec2.setLine(((VarDecStatementContext)_localctx).id2.idRet.getLine()); 
				setState(359);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ASSIGN) {
					{
					setState(355);
					match(ASSIGN);
					setState(356);
					((VarDecStatementContext)_localctx).exp2 = orExpression();
					 vardec2.setDefaultValue(((VarDecStatementContext)_localctx).exp2.orExprRet); 
					}
				}

				 _localctx.vardecstmtRet.addVar(vardec2); 
				}
				}
				setState(367);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			 _localctx.vardecstmtRet.setLine(((VarDecStatementContext)_localctx).id1.idRet.getLine()); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionCallStmtContext extends ParserRuleContext {
		public FunctionCallStmt funccallstmtRet;
		public Expression expr;
		public OtherExpressionContext otexp;
		public Token lpar1;
		public FunctionArgumentsContext fargs1;
		public Token DOT;
		public IdentifierContext id1;
		public Token lpar2;
		public FunctionArgumentsContext fargs2;
		public OtherExpressionContext otherExpression() {
			return getRuleContext(OtherExpressionContext.class,0);
		}
		public List<TerminalNode> RPAR() { return getTokens(CmmParser.RPAR); }
		public TerminalNode RPAR(int i) {
			return getToken(CmmParser.RPAR, i);
		}
		public List<TerminalNode> LPAR() { return getTokens(CmmParser.LPAR); }
		public TerminalNode LPAR(int i) {
			return getToken(CmmParser.LPAR, i);
		}
		public List<FunctionArgumentsContext> functionArguments() {
			return getRuleContexts(FunctionArgumentsContext.class);
		}
		public FunctionArgumentsContext functionArguments(int i) {
			return getRuleContext(FunctionArgumentsContext.class,i);
		}
		public List<TerminalNode> DOT() { return getTokens(CmmParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(CmmParser.DOT, i);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public FunctionCallStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCallStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterFunctionCallStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitFunctionCallStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitFunctionCallStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionCallStmtContext functionCallStmt() throws RecognitionException {
		FunctionCallStmtContext _localctx = new FunctionCallStmtContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_functionCallStmt);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(370);
			((FunctionCallStmtContext)_localctx).otexp = otherExpression();
			 ((FunctionCallStmtContext)_localctx).expr =  ((FunctionCallStmtContext)_localctx).otexp.otherExprRet; 
			setState(383);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(381);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case LPAR:
						{
						{
						setState(372);
						((FunctionCallStmtContext)_localctx).lpar1 = match(LPAR);
						setState(373);
						((FunctionCallStmtContext)_localctx).fargs1 = functionArguments();
						setState(374);
						match(RPAR);
						 ((FunctionCallStmtContext)_localctx).expr =  new FunctionCall(_localctx.expr, ((FunctionCallStmtContext)_localctx).fargs1.funcArgs);
						          _localctx.expr.setLine(((FunctionCallStmtContext)_localctx).lpar1.getLine()); 
						}
						}
						break;
					case DOT:
						{
						{
						setState(377);
						((FunctionCallStmtContext)_localctx).DOT = match(DOT);
						setState(378);
						((FunctionCallStmtContext)_localctx).id1 = identifier();
						 ((FunctionCallStmtContext)_localctx).expr =  new StructAccess(_localctx.expr, ((FunctionCallStmtContext)_localctx).id1.idRet);
						                                 _localctx.expr.setLine(((FunctionCallStmtContext)_localctx).DOT.getLine()); 
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(385);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
			}
			{
			setState(386);
			((FunctionCallStmtContext)_localctx).lpar2 = match(LPAR);
			setState(387);
			((FunctionCallStmtContext)_localctx).fargs2 = functionArguments();
			setState(388);
			match(RPAR);
			}
			 FunctionCall fcall = new FunctionCall(_localctx.expr, ((FunctionCallStmtContext)_localctx).fargs2.funcArgs);
			       fcall.setLine(((FunctionCallStmtContext)_localctx).lpar2.getLine());
			       ((FunctionCallStmtContext)_localctx).funccallstmtRet =  new FunctionCallStmt(fcall);
			       _localctx.funccallstmtRet.setLine(fcall.getLine()); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReturnStatementContext extends ParserRuleContext {
		public ReturnStmt returnstmtRet;
		public Token RETURN;
		public ExpressionContext exp;
		public TerminalNode RETURN() { return getToken(CmmParser.RETURN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterReturnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitReturnStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitReturnStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_returnStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(392);
			((ReturnStatementContext)_localctx).RETURN = match(RETURN);
			((ReturnStatementContext)_localctx).returnstmtRet =  new ReturnStmt(); 
			setState(397);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SIZE) | (1L << APPEND) | (1L << MINUS) | (1L << NOT) | (1L << TRUE) | (1L << FALSE) | (1L << LPAR) | (1L << INT_VALUE) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(394);
				((ReturnStatementContext)_localctx).exp = expression();
				 _localctx.returnstmtRet.setReturnedExpr(((ReturnStatementContext)_localctx).exp.exprRet); 
				}
			}

			_localctx.returnstmtRet.setLine(((ReturnStatementContext)_localctx).RETURN.getLine()); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfStatementContext extends ParserRuleContext {
		public ConditionalStmt ifRet;
		public Token IF;
		public ExpressionContext exp;
		public LoopCondBodyContext lpcndbdy;
		public BodyContext bdy;
		public ElseStatementContext elsestmt;
		public TerminalNode IF() { return getToken(CmmParser.IF, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public LoopCondBodyContext loopCondBody() {
			return getRuleContext(LoopCondBodyContext.class,0);
		}
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public ElseStatementContext elseStatement() {
			return getRuleContext(ElseStatementContext.class,0);
		}
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitIfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_ifStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(401);
			((IfStatementContext)_localctx).IF = match(IF);
			setState(402);
			((IfStatementContext)_localctx).exp = expression();
			 ((IfStatementContext)_localctx).ifRet =  new ConditionalStmt(((IfStatementContext)_localctx).exp.exprRet);
			                          _localctx.ifRet.setLine(((IfStatementContext)_localctx).IF.getLine()); 
			setState(412);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				{
				setState(404);
				((IfStatementContext)_localctx).lpcndbdy = loopCondBody();
				 _localctx.ifRet.setThenBody(((IfStatementContext)_localctx).lpcndbdy.lpcndbdRet); 
				}
				break;
			case 2:
				{
				setState(407);
				((IfStatementContext)_localctx).bdy = body();
				 _localctx.ifRet.setThenBody(((IfStatementContext)_localctx).bdy.bdyRet); 
				setState(409);
				((IfStatementContext)_localctx).elsestmt = elseStatement();
				 _localctx.ifRet.setElseBody(((IfStatementContext)_localctx).elsestmt.elsestmtRet); 
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElseStatementContext extends ParserRuleContext {
		public Statement elsestmtRet;
		public LoopCondBodyContext lpcndbdy;
		public TerminalNode ELSE() { return getToken(CmmParser.ELSE, 0); }
		public LoopCondBodyContext loopCondBody() {
			return getRuleContext(LoopCondBodyContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(CmmParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(CmmParser.NEWLINE, i);
		}
		public ElseStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterElseStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitElseStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitElseStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseStatementContext elseStatement() throws RecognitionException {
		ElseStatementContext _localctx = new ElseStatementContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_elseStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(417);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(414);
				match(NEWLINE);
				}
				}
				setState(419);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(420);
			match(ELSE);
			setState(421);
			((ElseStatementContext)_localctx).lpcndbdy = loopCondBody();
			 ((ElseStatementContext)_localctx).elsestmtRet =  ((ElseStatementContext)_localctx).lpcndbdy.lpcndbdRet; 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LoopStatementContext extends ParserRuleContext {
		public LoopStmt lpstmtRet;
		public WhileLoopStatementContext wlstmt;
		public DoWhileLoopStatementContext dwlstmt;
		public WhileLoopStatementContext whileLoopStatement() {
			return getRuleContext(WhileLoopStatementContext.class,0);
		}
		public DoWhileLoopStatementContext doWhileLoopStatement() {
			return getRuleContext(DoWhileLoopStatementContext.class,0);
		}
		public LoopStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loopStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterLoopStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitLoopStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitLoopStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LoopStatementContext loopStatement() throws RecognitionException {
		LoopStatementContext _localctx = new LoopStatementContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_loopStatement);
		try {
			setState(430);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case WHILE:
				enterOuterAlt(_localctx, 1);
				{
				setState(424);
				((LoopStatementContext)_localctx).wlstmt = whileLoopStatement();
				 ((LoopStatementContext)_localctx).lpstmtRet =  ((LoopStatementContext)_localctx).wlstmt.whllpstmtRet;
				                                   
				}
				break;
			case DO:
				enterOuterAlt(_localctx, 2);
				{
				setState(427);
				((LoopStatementContext)_localctx).dwlstmt = doWhileLoopStatement();
				 ((LoopStatementContext)_localctx).lpstmtRet =  ((LoopStatementContext)_localctx).dwlstmt.dowhllpstmtRet;
				                                        
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhileLoopStatementContext extends ParserRuleContext {
		public LoopStmt whllpstmtRet;
		public Token WHILE;
		public ExpressionContext exp;
		public LoopCondBodyContext lpcbdy;
		public TerminalNode WHILE() { return getToken(CmmParser.WHILE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public LoopCondBodyContext loopCondBody() {
			return getRuleContext(LoopCondBodyContext.class,0);
		}
		public WhileLoopStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileLoopStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterWhileLoopStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitWhileLoopStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitWhileLoopStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileLoopStatementContext whileLoopStatement() throws RecognitionException {
		WhileLoopStatementContext _localctx = new WhileLoopStatementContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_whileLoopStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((WhileLoopStatementContext)_localctx).whllpstmtRet =  new LoopStmt(); 
			setState(433);
			((WhileLoopStatementContext)_localctx).WHILE = match(WHILE);
			setState(434);
			((WhileLoopStatementContext)_localctx).exp = expression();
			setState(435);
			((WhileLoopStatementContext)_localctx).lpcbdy = loopCondBody();
			 _localctx.whllpstmtRet.setCondition(((WhileLoopStatementContext)_localctx).exp.exprRet);
			      _localctx.whllpstmtRet.setBody(((WhileLoopStatementContext)_localctx).lpcbdy.lpcndbdRet);
			      _localctx.whllpstmtRet.setLine(((WhileLoopStatementContext)_localctx).WHILE.getLine());
			      _localctx.whllpstmtRet.setIs_do_while(false); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DoWhileLoopStatementContext extends ParserRuleContext {
		public LoopStmt dowhllpstmtRet;
		public Token DO;
		public BodyContext bdy;
		public ExpressionContext exp;
		public TerminalNode DO() { return getToken(CmmParser.DO, 0); }
		public TerminalNode WHILE() { return getToken(CmmParser.WHILE, 0); }
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(CmmParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(CmmParser.NEWLINE, i);
		}
		public DoWhileLoopStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doWhileLoopStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterDoWhileLoopStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitDoWhileLoopStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitDoWhileLoopStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DoWhileLoopStatementContext doWhileLoopStatement() throws RecognitionException {
		DoWhileLoopStatementContext _localctx = new DoWhileLoopStatementContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_doWhileLoopStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((DoWhileLoopStatementContext)_localctx).dowhllpstmtRet =  new LoopStmt(); 
			setState(439);
			((DoWhileLoopStatementContext)_localctx).DO = match(DO);
			setState(440);
			((DoWhileLoopStatementContext)_localctx).bdy = body();
			setState(444);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(441);
				match(NEWLINE);
				}
				}
				setState(446);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(447);
			match(WHILE);
			setState(448);
			((DoWhileLoopStatementContext)_localctx).exp = expression();
			 _localctx.dowhllpstmtRet.setCondition(((DoWhileLoopStatementContext)_localctx).exp.exprRet);
			      _localctx.dowhllpstmtRet.setBody(((DoWhileLoopStatementContext)_localctx).bdy.bdyRet);
			      _localctx.dowhllpstmtRet.setLine(((DoWhileLoopStatementContext)_localctx).DO.getLine());
			      _localctx.dowhllpstmtRet.setIs_do_while(true); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DisplayStatementContext extends ParserRuleContext {
		public DisplayStmt displaystmtRet;
		public Token DISPLAY;
		public ExpressionContext expr;
		public TerminalNode DISPLAY() { return getToken(CmmParser.DISPLAY, 0); }
		public TerminalNode LPAR() { return getToken(CmmParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(CmmParser.RPAR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public DisplayStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_displayStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterDisplayStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitDisplayStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitDisplayStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DisplayStatementContext displayStatement() throws RecognitionException {
		DisplayStatementContext _localctx = new DisplayStatementContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_displayStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(451);
			((DisplayStatementContext)_localctx).DISPLAY = match(DISPLAY);
			setState(452);
			match(LPAR);
			setState(453);
			((DisplayStatementContext)_localctx).expr = expression();
			 ((DisplayStatementContext)_localctx).displaystmtRet =  new DisplayStmt(((DisplayStatementContext)_localctx).expr.exprRet);
			        _localctx.displaystmtRet.setLine(((DisplayStatementContext)_localctx).DISPLAY.getLine()); 
			setState(455);
			match(RPAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignmentStatementContext extends ParserRuleContext {
		public AssignmentStmt assignstmtRet;
		public OrExpressionContext orexp;
		public Token ASSIGN;
		public ExpressionContext exp;
		public TerminalNode ASSIGN() { return getToken(CmmParser.ASSIGN, 0); }
		public OrExpressionContext orExpression() {
			return getRuleContext(OrExpressionContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignmentStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterAssignmentStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitAssignmentStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitAssignmentStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentStatementContext assignmentStatement() throws RecognitionException {
		AssignmentStatementContext _localctx = new AssignmentStatementContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_assignmentStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(457);
			((AssignmentStatementContext)_localctx).orexp = orExpression();
			setState(458);
			((AssignmentStatementContext)_localctx).ASSIGN = match(ASSIGN);
			setState(459);
			((AssignmentStatementContext)_localctx).exp = expression();
			 ((AssignmentStatementContext)_localctx).assignstmtRet =  new AssignmentStmt(((AssignmentStatementContext)_localctx).orexp.orExprRet, ((AssignmentStatementContext)_localctx).exp.exprRet);
			      _localctx.assignstmtRet.setLine(((AssignmentStatementContext)_localctx).ASSIGN.getLine()); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SingleStatementContext extends ParserRuleContext {
		public Statement snglstmtRet;
		public IfStatementContext ifstmt;
		public DisplayStatementContext dsplystmt;
		public FunctionCallStmtContext fcstmt;
		public ReturnStatementContext rtrnstmt;
		public AssignmentStatementContext assgnstmt;
		public VarDecStatementContext vardecstmt;
		public LoopStatementContext lpstmt;
		public AppendContext apnd;
		public SizeContext sz;
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public DisplayStatementContext displayStatement() {
			return getRuleContext(DisplayStatementContext.class,0);
		}
		public FunctionCallStmtContext functionCallStmt() {
			return getRuleContext(FunctionCallStmtContext.class,0);
		}
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public AssignmentStatementContext assignmentStatement() {
			return getRuleContext(AssignmentStatementContext.class,0);
		}
		public VarDecStatementContext varDecStatement() {
			return getRuleContext(VarDecStatementContext.class,0);
		}
		public LoopStatementContext loopStatement() {
			return getRuleContext(LoopStatementContext.class,0);
		}
		public AppendContext append() {
			return getRuleContext(AppendContext.class,0);
		}
		public SizeContext size() {
			return getRuleContext(SizeContext.class,0);
		}
		public SingleStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterSingleStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitSingleStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitSingleStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SingleStatementContext singleStatement() throws RecognitionException {
		SingleStatementContext _localctx = new SingleStatementContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_singleStatement);
		try {
			setState(489);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(462);
				((SingleStatementContext)_localctx).ifstmt = ifStatement();
				 ((SingleStatementContext)_localctx).snglstmtRet =  ((SingleStatementContext)_localctx).ifstmt.ifRet; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(465);
				((SingleStatementContext)_localctx).dsplystmt = displayStatement();
				 ((SingleStatementContext)_localctx).snglstmtRet =  ((SingleStatementContext)_localctx).dsplystmt.displaystmtRet; 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(468);
				((SingleStatementContext)_localctx).fcstmt = functionCallStmt();
				 ((SingleStatementContext)_localctx).snglstmtRet =  ((SingleStatementContext)_localctx).fcstmt.funccallstmtRet; 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(471);
				((SingleStatementContext)_localctx).rtrnstmt = returnStatement();
				 ((SingleStatementContext)_localctx).snglstmtRet =  ((SingleStatementContext)_localctx).rtrnstmt.returnstmtRet; 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(474);
				((SingleStatementContext)_localctx).assgnstmt = assignmentStatement();
				 ((SingleStatementContext)_localctx).snglstmtRet =  ((SingleStatementContext)_localctx).assgnstmt.assignstmtRet; 
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(477);
				((SingleStatementContext)_localctx).vardecstmt = varDecStatement();
				 ((SingleStatementContext)_localctx).snglstmtRet =  ((SingleStatementContext)_localctx).vardecstmt.vardecstmtRet; 
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(480);
				((SingleStatementContext)_localctx).lpstmt = loopStatement();
				 ((SingleStatementContext)_localctx).snglstmtRet =  ((SingleStatementContext)_localctx).lpstmt.lpstmtRet; 
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(483);
				((SingleStatementContext)_localctx).apnd = append();
				 ((SingleStatementContext)_localctx).snglstmtRet =  new ListAppendStmt(((SingleStatementContext)_localctx).apnd.appendRet);
				                       _localctx.snglstmtRet.setLine(((SingleStatementContext)_localctx).apnd.appendRet.getLine());     
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(486);
				((SingleStatementContext)_localctx).sz = size();
				 ((SingleStatementContext)_localctx).snglstmtRet =  new ListSizeStmt(((SingleStatementContext)_localctx).sz.sizeRet);
				                   _localctx.snglstmtRet.setLine(((SingleStatementContext)_localctx).sz.sizeRet.getLine());   
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public Expression exprRet;
		public OrExpressionContext oexpr;
		public Token ASSIGN;
		public ExpressionContext expr;
		public OrExpressionContext orExpression() {
			return getRuleContext(OrExpressionContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(CmmParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(491);
			((ExpressionContext)_localctx).oexpr = orExpression();
			 ((ExpressionContext)_localctx).exprRet =  ((ExpressionContext)_localctx).oexpr.orExprRet; 
			setState(497);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(493);
				((ExpressionContext)_localctx).ASSIGN = match(ASSIGN);
				setState(494);
				((ExpressionContext)_localctx).expr = expression();
				 ((ExpressionContext)_localctx).exprRet =  new BinaryExpression(_localctx.exprRet, ((ExpressionContext)_localctx).expr.exprRet, BinaryOperator.assign);
				      _localctx.exprRet.setLine(((ExpressionContext)_localctx).ASSIGN.getLine());
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OrExpressionContext extends ParserRuleContext {
		public Expression orExprRet;
		public AndExpressionContext aexpr1;
		public Token OR;
		public AndExpressionContext aexpr2;
		public List<AndExpressionContext> andExpression() {
			return getRuleContexts(AndExpressionContext.class);
		}
		public AndExpressionContext andExpression(int i) {
			return getRuleContext(AndExpressionContext.class,i);
		}
		public List<TerminalNode> OR() { return getTokens(CmmParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(CmmParser.OR, i);
		}
		public OrExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterOrExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitOrExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitOrExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrExpressionContext orExpression() throws RecognitionException {
		OrExpressionContext _localctx = new OrExpressionContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_orExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(499);
			((OrExpressionContext)_localctx).aexpr1 = andExpression();
			((OrExpressionContext)_localctx).orExprRet =  ((OrExpressionContext)_localctx).aexpr1.andExprRet;
			setState(507);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR) {
				{
				{
				setState(501);
				((OrExpressionContext)_localctx).OR = match(OR);
				setState(502);
				((OrExpressionContext)_localctx).aexpr2 = andExpression();
				 ((OrExpressionContext)_localctx).orExprRet =  new BinaryExpression(_localctx.orExprRet,((OrExpressionContext)_localctx).aexpr2.andExprRet,BinaryOperator.or);
				              _localctx.orExprRet.setLine(((OrExpressionContext)_localctx).OR.getLine()); 
				}
				}
				setState(509);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AndExpressionContext extends ParserRuleContext {
		public Expression andExprRet;
		public EqualityExpressionContext eexpr1;
		public Token AND;
		public EqualityExpressionContext eexpr2;
		public List<EqualityExpressionContext> equalityExpression() {
			return getRuleContexts(EqualityExpressionContext.class);
		}
		public EqualityExpressionContext equalityExpression(int i) {
			return getRuleContext(EqualityExpressionContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(CmmParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(CmmParser.AND, i);
		}
		public AndExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_andExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterAndExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitAndExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitAndExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AndExpressionContext andExpression() throws RecognitionException {
		AndExpressionContext _localctx = new AndExpressionContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_andExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(510);
			((AndExpressionContext)_localctx).eexpr1 = equalityExpression();
			((AndExpressionContext)_localctx).andExprRet =  ((AndExpressionContext)_localctx).eexpr1.equalExprRet;
			setState(518);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(512);
				((AndExpressionContext)_localctx).AND = match(AND);
				setState(513);
				((AndExpressionContext)_localctx).eexpr2 = equalityExpression();
				 ((AndExpressionContext)_localctx).andExprRet =  new BinaryExpression(_localctx.andExprRet, ((AndExpressionContext)_localctx).eexpr2.equalExprRet, BinaryOperator.and);
				      _localctx.andExprRet.setLine(((AndExpressionContext)_localctx).AND.getLine()); 
				}
				}
				setState(520);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EqualityExpressionContext extends ParserRuleContext {
		public Expression equalExprRet;
		public RelationalExpressionContext rel1;
		public Token EQUAL;
		public RelationalExpressionContext rel2;
		public List<RelationalExpressionContext> relationalExpression() {
			return getRuleContexts(RelationalExpressionContext.class);
		}
		public RelationalExpressionContext relationalExpression(int i) {
			return getRuleContext(RelationalExpressionContext.class,i);
		}
		public List<TerminalNode> EQUAL() { return getTokens(CmmParser.EQUAL); }
		public TerminalNode EQUAL(int i) {
			return getToken(CmmParser.EQUAL, i);
		}
		public EqualityExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equalityExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterEqualityExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitEqualityExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitEqualityExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EqualityExpressionContext equalityExpression() throws RecognitionException {
		EqualityExpressionContext _localctx = new EqualityExpressionContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_equalityExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(521);
			((EqualityExpressionContext)_localctx).rel1 = relationalExpression();
			((EqualityExpressionContext)_localctx).equalExprRet =  ((EqualityExpressionContext)_localctx).rel1.relExprRet;
			setState(529);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==EQUAL) {
				{
				{
				setState(523);
				((EqualityExpressionContext)_localctx).EQUAL = match(EQUAL);
				setState(524);
				((EqualityExpressionContext)_localctx).rel2 = relationalExpression();
				 ((EqualityExpressionContext)_localctx).equalExprRet =  new BinaryExpression(_localctx.equalExprRet, ((EqualityExpressionContext)_localctx).rel2.relExprRet, BinaryOperator.eq);
				      _localctx.equalExprRet.setLine(((EqualityExpressionContext)_localctx).EQUAL.getLine()); 
				}
				}
				setState(531);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RelationalExpressionContext extends ParserRuleContext {
		public Expression relExprRet;
		public AdditiveExpressionContext add1;
		public Token GREATER_THAN;
		public Token LESS_THAN;
		public AdditiveExpressionContext add2;
		public List<AdditiveExpressionContext> additiveExpression() {
			return getRuleContexts(AdditiveExpressionContext.class);
		}
		public AdditiveExpressionContext additiveExpression(int i) {
			return getRuleContext(AdditiveExpressionContext.class,i);
		}
		public List<TerminalNode> GREATER_THAN() { return getTokens(CmmParser.GREATER_THAN); }
		public TerminalNode GREATER_THAN(int i) {
			return getToken(CmmParser.GREATER_THAN, i);
		}
		public List<TerminalNode> LESS_THAN() { return getTokens(CmmParser.LESS_THAN); }
		public TerminalNode LESS_THAN(int i) {
			return getToken(CmmParser.LESS_THAN, i);
		}
		public RelationalExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationalExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterRelationalExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitRelationalExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitRelationalExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelationalExpressionContext relationalExpression() throws RecognitionException {
		RelationalExpressionContext _localctx = new RelationalExpressionContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_relationalExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(532);
			((RelationalExpressionContext)_localctx).add1 = additiveExpression();
			 ((RelationalExpressionContext)_localctx).relExprRet =  ((RelationalExpressionContext)_localctx).add1.addExprRet; 
			 BinaryOperator relop; int line; 
			setState(546);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==GREATER_THAN || _la==LESS_THAN) {
				{
				{
				setState(539);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case GREATER_THAN:
					{
					setState(535);
					((RelationalExpressionContext)_localctx).GREATER_THAN = match(GREATER_THAN);
					 relop = BinaryOperator.gt; line = ((RelationalExpressionContext)_localctx).GREATER_THAN.getLine(); 
					}
					break;
				case LESS_THAN:
					{
					setState(537);
					((RelationalExpressionContext)_localctx).LESS_THAN = match(LESS_THAN);
					 relop = BinaryOperator.lt; line = ((RelationalExpressionContext)_localctx).LESS_THAN.getLine(); 
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(541);
				((RelationalExpressionContext)_localctx).add2 = additiveExpression();
				 ((RelationalExpressionContext)_localctx).relExprRet =  new BinaryExpression(_localctx.relExprRet, ((RelationalExpressionContext)_localctx).add2.addExprRet, relop);
				        _localctx.relExprRet.setLine(line); 
				}
				}
				setState(548);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AdditiveExpressionContext extends ParserRuleContext {
		public Expression addExprRet;
		public MultiplicativeExpressionContext mult1;
		public Token PLUS;
		public Token MINUS;
		public MultiplicativeExpressionContext mult2;
		public List<MultiplicativeExpressionContext> multiplicativeExpression() {
			return getRuleContexts(MultiplicativeExpressionContext.class);
		}
		public MultiplicativeExpressionContext multiplicativeExpression(int i) {
			return getRuleContext(MultiplicativeExpressionContext.class,i);
		}
		public List<TerminalNode> PLUS() { return getTokens(CmmParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(CmmParser.PLUS, i);
		}
		public List<TerminalNode> MINUS() { return getTokens(CmmParser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(CmmParser.MINUS, i);
		}
		public AdditiveExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additiveExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterAdditiveExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitAdditiveExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitAdditiveExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AdditiveExpressionContext additiveExpression() throws RecognitionException {
		AdditiveExpressionContext _localctx = new AdditiveExpressionContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_additiveExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(549);
			((AdditiveExpressionContext)_localctx).mult1 = multiplicativeExpression();
			 ((AdditiveExpressionContext)_localctx).addExprRet =  ((AdditiveExpressionContext)_localctx).mult1.multExprRet; 
			 BinaryOperator addop; int line; 
			setState(563);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS || _la==MINUS) {
				{
				{
				setState(556);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case PLUS:
					{
					setState(552);
					((AdditiveExpressionContext)_localctx).PLUS = match(PLUS);
					 addop = BinaryOperator.add; line = ((AdditiveExpressionContext)_localctx).PLUS.getLine(); 
					}
					break;
				case MINUS:
					{
					setState(554);
					((AdditiveExpressionContext)_localctx).MINUS = match(MINUS);
					 addop = BinaryOperator.sub; line = ((AdditiveExpressionContext)_localctx).MINUS.getLine(); 
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(558);
				((AdditiveExpressionContext)_localctx).mult2 = multiplicativeExpression();
				 ((AdditiveExpressionContext)_localctx).addExprRet =  new BinaryExpression(_localctx.addExprRet, ((AdditiveExpressionContext)_localctx).mult2.multExprRet, addop);
				        _localctx.addExprRet.setLine(line); 
				}
				}
				setState(565);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MultiplicativeExpressionContext extends ParserRuleContext {
		public Expression multExprRet;
		public PreUnaryExpressionContext pre1;
		public Token MULT;
		public Token DIVIDE;
		public PreUnaryExpressionContext pre2;
		public List<PreUnaryExpressionContext> preUnaryExpression() {
			return getRuleContexts(PreUnaryExpressionContext.class);
		}
		public PreUnaryExpressionContext preUnaryExpression(int i) {
			return getRuleContext(PreUnaryExpressionContext.class,i);
		}
		public List<TerminalNode> MULT() { return getTokens(CmmParser.MULT); }
		public TerminalNode MULT(int i) {
			return getToken(CmmParser.MULT, i);
		}
		public List<TerminalNode> DIVIDE() { return getTokens(CmmParser.DIVIDE); }
		public TerminalNode DIVIDE(int i) {
			return getToken(CmmParser.DIVIDE, i);
		}
		public MultiplicativeExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicativeExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterMultiplicativeExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitMultiplicativeExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitMultiplicativeExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultiplicativeExpressionContext multiplicativeExpression() throws RecognitionException {
		MultiplicativeExpressionContext _localctx = new MultiplicativeExpressionContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_multiplicativeExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(566);
			((MultiplicativeExpressionContext)_localctx).pre1 = preUnaryExpression();
			 ((MultiplicativeExpressionContext)_localctx).multExprRet =  ((MultiplicativeExpressionContext)_localctx).pre1.puExpRet; 
			 BinaryOperator multop; int line; 
			setState(580);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MULT || _la==DIVIDE) {
				{
				{
				setState(573);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case MULT:
					{
					setState(569);
					((MultiplicativeExpressionContext)_localctx).MULT = match(MULT);
					 multop = BinaryOperator.mult; line = ((MultiplicativeExpressionContext)_localctx).MULT.getLine(); 
					}
					break;
				case DIVIDE:
					{
					setState(571);
					((MultiplicativeExpressionContext)_localctx).DIVIDE = match(DIVIDE);
					 multop = BinaryOperator.div; line = ((MultiplicativeExpressionContext)_localctx).DIVIDE.getLine(); 
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(575);
				((MultiplicativeExpressionContext)_localctx).pre2 = preUnaryExpression();
				 ((MultiplicativeExpressionContext)_localctx).multExprRet =  new BinaryExpression(_localctx.multExprRet, ((MultiplicativeExpressionContext)_localctx).pre2.puExpRet, multop);
				        _localctx.multExprRet.setLine(line); 
				}
				}
				setState(582);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PreUnaryExpressionContext extends ParserRuleContext {
		public Expression puExpRet;
		public Token NOT;
		public Token MINUS;
		public PreUnaryExpressionContext prun;
		public AccessExpressionContext acs;
		public PreUnaryExpressionContext preUnaryExpression() {
			return getRuleContext(PreUnaryExpressionContext.class,0);
		}
		public TerminalNode NOT() { return getToken(CmmParser.NOT, 0); }
		public TerminalNode MINUS() { return getToken(CmmParser.MINUS, 0); }
		public AccessExpressionContext accessExpression() {
			return getRuleContext(AccessExpressionContext.class,0);
		}
		public PreUnaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_preUnaryExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterPreUnaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitPreUnaryExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitPreUnaryExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PreUnaryExpressionContext preUnaryExpression() throws RecognitionException {
		PreUnaryExpressionContext _localctx = new PreUnaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_preUnaryExpression);
		try {
			setState(596);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MINUS:
			case NOT:
				enterOuterAlt(_localctx, 1);
				{
				 UnaryOperator preop; int line; 
				{
				setState(588);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case NOT:
					{
					setState(584);
					((PreUnaryExpressionContext)_localctx).NOT = match(NOT);
					 preop = UnaryOperator.not; line = ((PreUnaryExpressionContext)_localctx).NOT.getLine(); 
					}
					break;
				case MINUS:
					{
					setState(586);
					((PreUnaryExpressionContext)_localctx).MINUS = match(MINUS);
					 preop = UnaryOperator.minus; line = ((PreUnaryExpressionContext)_localctx).MINUS.getLine(); 
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(590);
				((PreUnaryExpressionContext)_localctx).prun = preUnaryExpression();
				 ((PreUnaryExpressionContext)_localctx).puExpRet =  new UnaryExpression(((PreUnaryExpressionContext)_localctx).prun.puExpRet, preop);
				        _localctx.puExpRet.setLine(line); 
				}
				}
				break;
			case SIZE:
			case APPEND:
			case TRUE:
			case FALSE:
			case LPAR:
			case INT_VALUE:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(593);
				((PreUnaryExpressionContext)_localctx).acs = accessExpression();
				 ((PreUnaryExpressionContext)_localctx).puExpRet =  ((PreUnaryExpressionContext)_localctx).acs.acsExpRet; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AccessExpressionContext extends ParserRuleContext {
		public Expression acsExpRet;
		public OtherExpressionContext othexpr;
		public Token LPAR;
		public FunctionArgumentsContext fargs;
		public Token DOT;
		public IdentifierContext id1;
		public Token LBRACK;
		public ExpressionContext expr;
		public IdentifierContext id2;
		public OtherExpressionContext otherExpression() {
			return getRuleContext(OtherExpressionContext.class,0);
		}
		public List<TerminalNode> LPAR() { return getTokens(CmmParser.LPAR); }
		public TerminalNode LPAR(int i) {
			return getToken(CmmParser.LPAR, i);
		}
		public List<TerminalNode> RPAR() { return getTokens(CmmParser.RPAR); }
		public TerminalNode RPAR(int i) {
			return getToken(CmmParser.RPAR, i);
		}
		public List<TerminalNode> DOT() { return getTokens(CmmParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(CmmParser.DOT, i);
		}
		public List<TerminalNode> LBRACK() { return getTokens(CmmParser.LBRACK); }
		public TerminalNode LBRACK(int i) {
			return getToken(CmmParser.LBRACK, i);
		}
		public List<TerminalNode> RBRACK() { return getTokens(CmmParser.RBRACK); }
		public TerminalNode RBRACK(int i) {
			return getToken(CmmParser.RBRACK, i);
		}
		public List<FunctionArgumentsContext> functionArguments() {
			return getRuleContexts(FunctionArgumentsContext.class);
		}
		public FunctionArgumentsContext functionArguments(int i) {
			return getRuleContext(FunctionArgumentsContext.class,i);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public AccessExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_accessExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterAccessExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitAccessExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitAccessExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AccessExpressionContext accessExpression() throws RecognitionException {
		AccessExpressionContext _localctx = new AccessExpressionContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_accessExpression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(598);
			((AccessExpressionContext)_localctx).othexpr = otherExpression();
			 ((AccessExpressionContext)_localctx).acsExpRet =  ((AccessExpressionContext)_localctx).othexpr.otherExprRet; 
			setState(611);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,57,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(609);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case LPAR:
						{
						{
						setState(600);
						((AccessExpressionContext)_localctx).LPAR = match(LPAR);
						setState(601);
						((AccessExpressionContext)_localctx).fargs = functionArguments();
						setState(602);
						match(RPAR);
						 ((AccessExpressionContext)_localctx).acsExpRet =  new FunctionCall(_localctx.acsExpRet, ((AccessExpressionContext)_localctx).fargs.funcArgs);
						         _localctx.acsExpRet.setLine(((AccessExpressionContext)_localctx).LPAR.getLine()); 
						}
						}
						break;
					case DOT:
						{
						{
						setState(605);
						((AccessExpressionContext)_localctx).DOT = match(DOT);
						setState(606);
						((AccessExpressionContext)_localctx).id1 = identifier();
						 ((AccessExpressionContext)_localctx).acsExpRet =  new StructAccess(_localctx.acsExpRet, ((AccessExpressionContext)_localctx).id1.idRet);
						                                _localctx.acsExpRet.setLine(((AccessExpressionContext)_localctx).DOT.getLine()); 
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(613);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,57,_ctx);
			}
			setState(625);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBRACK || _la==DOT) {
				{
				setState(623);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LBRACK:
					{
					{
					setState(614);
					((AccessExpressionContext)_localctx).LBRACK = match(LBRACK);
					setState(615);
					((AccessExpressionContext)_localctx).expr = expression();
					setState(616);
					match(RBRACK);
					 ((AccessExpressionContext)_localctx).acsExpRet =  new ListAccessByIndex(_localctx.acsExpRet, ((AccessExpressionContext)_localctx).expr.exprRet);
					             _localctx.acsExpRet.setLine(((AccessExpressionContext)_localctx).LBRACK.getLine()); 
					}
					}
					break;
				case DOT:
					{
					{
					setState(619);
					((AccessExpressionContext)_localctx).DOT = match(DOT);
					setState(620);
					((AccessExpressionContext)_localctx).id2 = identifier();
					 ((AccessExpressionContext)_localctx).acsExpRet =  new StructAccess(_localctx.acsExpRet, ((AccessExpressionContext)_localctx).id2.idRet);
					                                      _localctx.acsExpRet.setLine(((AccessExpressionContext)_localctx).DOT.getLine()); 
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(627);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OtherExpressionContext extends ParserRuleContext {
		public Expression otherExprRet;
		public ValueContext val;
		public IdentifierContext idtfr;
		public Token LPAR;
		public FunctionArgumentsContext fargs;
		public SizeContext sz;
		public AppendContext apnd;
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode LPAR() { return getToken(CmmParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(CmmParser.RPAR, 0); }
		public FunctionArgumentsContext functionArguments() {
			return getRuleContext(FunctionArgumentsContext.class,0);
		}
		public SizeContext size() {
			return getRuleContext(SizeContext.class,0);
		}
		public AppendContext append() {
			return getRuleContext(AppendContext.class,0);
		}
		public OtherExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_otherExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterOtherExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitOtherExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitOtherExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OtherExpressionContext otherExpression() throws RecognitionException {
		OtherExpressionContext _localctx = new OtherExpressionContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_otherExpression);
		try {
			setState(645);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TRUE:
			case FALSE:
			case INT_VALUE:
				enterOuterAlt(_localctx, 1);
				{
				setState(628);
				((OtherExpressionContext)_localctx).val = value();
				 ((OtherExpressionContext)_localctx).otherExprRet =  ((OtherExpressionContext)_localctx).val.valRet; 
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(631);
				((OtherExpressionContext)_localctx).idtfr = identifier();
				 ((OtherExpressionContext)_localctx).otherExprRet =  ((OtherExpressionContext)_localctx).idtfr.idRet; 
				}
				break;
			case LPAR:
				enterOuterAlt(_localctx, 3);
				{
				setState(634);
				((OtherExpressionContext)_localctx).LPAR = match(LPAR);
				{
				setState(635);
				((OtherExpressionContext)_localctx).fargs = functionArguments();
				}
				setState(636);
				match(RPAR);
				 ((OtherExpressionContext)_localctx).otherExprRet =  new ExprInPar(((OtherExpressionContext)_localctx).fargs.funcArgs);
				        _localctx.otherExprRet.setLine(((OtherExpressionContext)_localctx).LPAR.getLine()); 
				}
				break;
			case SIZE:
				enterOuterAlt(_localctx, 4);
				{
				setState(639);
				((OtherExpressionContext)_localctx).sz = size();
				 ((OtherExpressionContext)_localctx).otherExprRet =  ((OtherExpressionContext)_localctx).sz.sizeRet; 
				}
				break;
			case APPEND:
				enterOuterAlt(_localctx, 5);
				{
				setState(642);
				((OtherExpressionContext)_localctx).apnd = append();
				 ((OtherExpressionContext)_localctx).otherExprRet =  ((OtherExpressionContext)_localctx).apnd.appendRet; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SizeContext extends ParserRuleContext {
		public ListSize sizeRet;
		public Token SIZE;
		public ExpressionContext expression;
		public TerminalNode SIZE() { return getToken(CmmParser.SIZE, 0); }
		public TerminalNode LPAR() { return getToken(CmmParser.LPAR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(CmmParser.RPAR, 0); }
		public SizeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_size; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterSize(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitSize(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitSize(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SizeContext size() throws RecognitionException {
		SizeContext _localctx = new SizeContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_size);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(647);
			((SizeContext)_localctx).SIZE = match(SIZE);
			setState(648);
			match(LPAR);
			setState(649);
			((SizeContext)_localctx).expression = expression();
			((SizeContext)_localctx).sizeRet =  new ListSize(((SizeContext)_localctx).expression.exprRet);
			     _localctx.sizeRet.setLine(((SizeContext)_localctx).SIZE.getLine());
			setState(651);
			match(RPAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AppendContext extends ParserRuleContext {
		public ListAppend appendRet;
		public Token APPEND;
		public ExpressionContext e1;
		public ExpressionContext e2;
		public TerminalNode APPEND() { return getToken(CmmParser.APPEND, 0); }
		public TerminalNode LPAR() { return getToken(CmmParser.LPAR, 0); }
		public TerminalNode COMMA() { return getToken(CmmParser.COMMA, 0); }
		public TerminalNode RPAR() { return getToken(CmmParser.RPAR, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public AppendContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_append; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterAppend(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitAppend(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitAppend(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AppendContext append() throws RecognitionException {
		AppendContext _localctx = new AppendContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_append);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(653);
			((AppendContext)_localctx).APPEND = match(APPEND);
			setState(654);
			match(LPAR);
			{
			setState(655);
			((AppendContext)_localctx).e1 = expression();
			}
			setState(656);
			match(COMMA);
			{
			setState(657);
			((AppendContext)_localctx).e2 = expression();
			}
			setState(658);
			match(RPAR);
			 ((AppendContext)_localctx).appendRet =  new ListAppend(((AppendContext)_localctx).e1.exprRet, ((AppendContext)_localctx).e2.exprRet);
			      _localctx.appendRet.setLine(((AppendContext)_localctx).APPEND.getLine()); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValueContext extends ParserRuleContext {
		public Value valRet;
		public BoolValueContext boolValue;
		public Token INT_VALUE;
		public BoolValueContext boolValue() {
			return getRuleContext(BoolValueContext.class,0);
		}
		public TerminalNode INT_VALUE() { return getToken(CmmParser.INT_VALUE, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_value);
		try {
			setState(666);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TRUE:
			case FALSE:
				enterOuterAlt(_localctx, 1);
				{
				setState(661);
				((ValueContext)_localctx).boolValue = boolValue();
				((ValueContext)_localctx).valRet =  ((ValueContext)_localctx).boolValue.boolRet;
				}
				break;
			case INT_VALUE:
				enterOuterAlt(_localctx, 2);
				{
				setState(664);
				((ValueContext)_localctx).INT_VALUE = match(INT_VALUE);
				((ValueContext)_localctx).valRet =  new IntValue((((ValueContext)_localctx).INT_VALUE!=null?Integer.valueOf(((ValueContext)_localctx).INT_VALUE.getText()):0)); _localctx.valRet.setLine(((ValueContext)_localctx).INT_VALUE.getLine()); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BoolValueContext extends ParserRuleContext {
		public BoolValue boolRet;
		public Token TRUE;
		public Token FALSE;
		public TerminalNode TRUE() { return getToken(CmmParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(CmmParser.FALSE, 0); }
		public BoolValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterBoolValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitBoolValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitBoolValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolValueContext boolValue() throws RecognitionException {
		BoolValueContext _localctx = new BoolValueContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_boolValue);
		try {
			setState(672);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TRUE:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(668);
				((BoolValueContext)_localctx).TRUE = match(TRUE);
				((BoolValueContext)_localctx).boolRet =  new BoolValue(true); _localctx.boolRet.setLine(((BoolValueContext)_localctx).TRUE.getLine()); 
				}
				}
				break;
			case FALSE:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(670);
				((BoolValueContext)_localctx).FALSE = match(FALSE);
				((BoolValueContext)_localctx).boolRet =  new BoolValue(false); _localctx.boolRet.setLine(((BoolValueContext)_localctx).FALSE.getLine()); 
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentifierContext extends ParserRuleContext {
		public Identifier idRet;
		public Token IDENTIFIER;
		public TerminalNode IDENTIFIER() { return getToken(CmmParser.IDENTIFIER, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(674);
			((IdentifierContext)_localctx).IDENTIFIER = match(IDENTIFIER);
			((IdentifierContext)_localctx).idRet =  new Identifier(((IdentifierContext)_localctx).IDENTIFIER.getText()); _localctx.idRet.setLine(((IdentifierContext)_localctx).IDENTIFIER.getLine());
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public Type typeRet;
		public TypeContext elemType;
		public IdentifierContext strctName;
		public FptrTypeContext fptrType;
		public TerminalNode INT() { return getToken(CmmParser.INT, 0); }
		public TerminalNode BOOL() { return getToken(CmmParser.BOOL, 0); }
		public TerminalNode LIST() { return getToken(CmmParser.LIST, 0); }
		public TerminalNode SHARP() { return getToken(CmmParser.SHARP, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode STRUCT() { return getToken(CmmParser.STRUCT, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public FptrTypeContext fptrType() {
			return getRuleContext(FptrTypeContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_type);
		try {
			setState(693);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(677);
				match(INT);
				((TypeContext)_localctx).typeRet =  new IntType();
				}
				}
				break;
			case BOOL:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(679);
				match(BOOL);
				((TypeContext)_localctx).typeRet =  new BoolType();
				}
				}
				break;
			case LIST:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(681);
				match(LIST);
				setState(682);
				match(SHARP);
				setState(683);
				((TypeContext)_localctx).elemType = type();
				((TypeContext)_localctx).typeRet =  new ListType(((TypeContext)_localctx).elemType.typeRet);
				}
				}
				break;
			case STRUCT:
				enterOuterAlt(_localctx, 4);
				{
				{
				setState(686);
				match(STRUCT);
				setState(687);
				((TypeContext)_localctx).strctName = identifier();
				((TypeContext)_localctx).typeRet =  new StructType(((TypeContext)_localctx).strctName.idRet);
				}
				}
				break;
			case FPTR:
				enterOuterAlt(_localctx, 5);
				{
				{
				setState(690);
				((TypeContext)_localctx).fptrType = fptrType();
				((TypeContext)_localctx).typeRet =  ((TypeContext)_localctx).fptrType.fptrTypeRet;
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FptrTypeContext extends ParserRuleContext {
		public FptrType fptrTypeRet;
		public TypeContext t1;
		public TypeContext t2;
		public TypeContext returnType;
		public Token isVoid;
		public TerminalNode FPTR() { return getToken(CmmParser.FPTR, 0); }
		public TerminalNode LESS_THAN() { return getToken(CmmParser.LESS_THAN, 0); }
		public TerminalNode ARROW() { return getToken(CmmParser.ARROW, 0); }
		public TerminalNode GREATER_THAN() { return getToken(CmmParser.GREATER_THAN, 0); }
		public List<TerminalNode> VOID() { return getTokens(CmmParser.VOID); }
		public TerminalNode VOID(int i) {
			return getToken(CmmParser.VOID, i);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(CmmParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CmmParser.COMMA, i);
		}
		public FptrTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fptrType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterFptrType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitFptrType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitFptrType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FptrTypeContext fptrType() throws RecognitionException {
		FptrTypeContext _localctx = new FptrTypeContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_fptrType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(695);
			match(FPTR);
			ArrayList<Type> arrTypes = new ArrayList<>();
			setState(697);
			match(LESS_THAN);
			setState(710);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VOID:
				{
				setState(698);
				match(VOID);
				}
				break;
			case INT:
			case BOOL:
			case LIST:
			case STRUCT:
			case FPTR:
				{
				{
				setState(699);
				((FptrTypeContext)_localctx).t1 = type();
				arrTypes.add(((FptrTypeContext)_localctx).t1.typeRet);
				setState(707);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(701);
					match(COMMA);
					setState(702);
					((FptrTypeContext)_localctx).t2 = type();
					arrTypes.add(((FptrTypeContext)_localctx).t2.typeRet);
					}
					}
					setState(709);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(712);
			match(ARROW);
			setState(715);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case BOOL:
			case LIST:
			case STRUCT:
			case FPTR:
				{
				setState(713);
				((FptrTypeContext)_localctx).returnType = type();
				}
				break;
			case VOID:
				{
				setState(714);
				((FptrTypeContext)_localctx).isVoid = match(VOID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(717);
			match(GREATER_THAN);

			        if ((((FptrTypeContext)_localctx).isVoid!=null?((FptrTypeContext)_localctx).isVoid.getText():null) != null)
			            ((FptrTypeContext)_localctx).fptrTypeRet =  new FptrType(arrTypes, new VoidType());
			        else
			            ((FptrTypeContext)_localctx).fptrTypeRet =  new FptrType(arrTypes, ((FptrTypeContext)_localctx).returnType.typeRet);
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\60\u02d3\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\3\2\7\2Z\n\2\f\2\16\2]\13\2\3\2\3\2\3\2\7\2b\n\2\f\2\16\2e\13\2\3"+
		"\2\3\2\3\3\3\3\3\3\3\3\7\3m\n\3\f\3\16\3p\13\3\3\3\3\3\3\3\7\3u\n\3\f"+
		"\3\16\3x\13\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\6\5\u008b\n\5\r\5\16\5\u008c\3\5\3\5\3\5\3\5\6\5\u0093\n"+
		"\5\r\5\16\5\u0094\3\5\3\5\5\5\u0099\n\5\3\5\3\5\5\5\u009d\n\5\3\5\6\5"+
		"\u00a0\n\5\r\5\16\5\u00a1\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\6\6\u00ad"+
		"\n\6\r\6\16\6\u00ae\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\5"+
		"\7\u00bd\n\7\3\b\3\b\6\b\u00c1\n\b\r\b\16\b\u00c2\3\b\3\b\3\b\3\b\7\b"+
		"\u00c9\n\b\f\b\16\b\u00cc\13\b\3\b\3\b\3\b\5\b\u00d1\n\b\6\b\u00d3\n\b"+
		"\r\b\16\b\u00d4\3\t\3\t\3\t\3\t\6\t\u00db\n\t\r\t\16\t\u00dc\3\n\3\n\3"+
		"\n\3\n\6\n\u00e3\n\n\r\n\16\n\u00e4\3\13\3\13\3\13\3\13\3\13\3\13\5\13"+
		"\u00ed\n\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\6\13\u00f6\n\13\r\13\16"+
		"\13\u00f7\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u0104\n\f\f\f\16"+
		"\f\u0107\13\f\5\f\u0109\n\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u0114"+
		"\n\r\f\r\16\r\u0117\13\r\5\r\u0119\n\r\3\16\3\16\3\16\3\16\6\16\u011f"+
		"\n\16\r\16\16\16\u0120\3\16\3\16\3\16\5\16\u0126\n\16\5\16\u0128\n\16"+
		"\3\17\3\17\3\17\3\17\6\17\u012e\n\17\r\17\16\17\u012f\3\17\3\17\3\17\5"+
		"\17\u0135\n\17\3\20\3\20\3\20\3\20\6\20\u013b\n\20\r\20\16\20\u013c\3"+
		"\20\3\20\3\20\3\20\7\20\u0143\n\20\f\20\16\20\u0146\13\20\3\20\3\20\3"+
		"\20\5\20\u014b\n\20\6\20\u014d\n\20\r\20\16\20\u014e\3\20\6\20\u0152\n"+
		"\20\r\20\16\20\u0153\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\5\21\u0160\n\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u016a\n"+
		"\21\3\21\3\21\7\21\u016e\n\21\f\21\16\21\u0171\13\21\3\21\3\21\3\22\3"+
		"\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\7\22\u0180\n\22\f\22"+
		"\16\22\u0183\13\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3"+
		"\23\5\23\u0190\n\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\5\24\u019f\n\24\3\25\7\25\u01a2\n\25\f\25\16\25\u01a5"+
		"\13\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u01b1\n"+
		"\26\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\7\30\u01bd\n\30"+
		"\f\30\16\30\u01c0\13\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3"+
		"\31\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3"+
		"\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3"+
		"\33\3\33\3\33\3\33\3\33\5\33\u01ec\n\33\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\5\34\u01f4\n\34\3\35\3\35\3\35\3\35\3\35\3\35\7\35\u01fc\n\35\f\35\16"+
		"\35\u01ff\13\35\3\36\3\36\3\36\3\36\3\36\3\36\7\36\u0207\n\36\f\36\16"+
		"\36\u020a\13\36\3\37\3\37\3\37\3\37\3\37\3\37\7\37\u0212\n\37\f\37\16"+
		"\37\u0215\13\37\3 \3 \3 \3 \3 \3 \3 \5 \u021e\n \3 \3 \3 \7 \u0223\n "+
		"\f \16 \u0226\13 \3!\3!\3!\3!\3!\3!\3!\5!\u022f\n!\3!\3!\3!\7!\u0234\n"+
		"!\f!\16!\u0237\13!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u0240\n\"\3\"\3\"\3"+
		"\"\7\"\u0245\n\"\f\"\16\"\u0248\13\"\3#\3#\3#\3#\3#\5#\u024f\n#\3#\3#"+
		"\3#\3#\3#\3#\5#\u0257\n#\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\7$\u0264\n$"+
		"\f$\16$\u0267\13$\3$\3$\3$\3$\3$\3$\3$\3$\3$\7$\u0272\n$\f$\16$\u0275"+
		"\13$\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\5%\u0288\n%\3"+
		"&\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\5(\u029d"+
		"\n(\3)\3)\3)\3)\5)\u02a3\n)\3*\3*\3*\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+"+
		"\3+\3+\3+\3+\3+\5+\u02b8\n+\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\7,\u02c4\n,"+
		"\f,\16,\u02c7\13,\5,\u02c9\n,\3,\3,\3,\5,\u02ce\n,\3,\3,\3,\3,\2\2-\2"+
		"\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJL"+
		"NPRTV\2\2\2\u02f7\2[\3\2\2\2\4h\3\2\2\2\6|\3\2\2\2\b\u0083\3\2\2\2\n\u00a3"+
		"\3\2\2\2\f\u00bc\3\2\2\2\16\u00be\3\2\2\2\20\u00d6\3\2\2\2\22\u00de\3"+
		"\2\2\2\24\u00e6\3\2\2\2\26\u00f9\3\2\2\2\30\u010c\3\2\2\2\32\u0127\3\2"+
		"\2\2\34\u0134\3\2\2\2\36\u0136\3\2\2\2 \u0157\3\2\2\2\"\u0174\3\2\2\2"+
		"$\u018a\3\2\2\2&\u0193\3\2\2\2(\u01a3\3\2\2\2*\u01b0\3\2\2\2,\u01b2\3"+
		"\2\2\2.\u01b8\3\2\2\2\60\u01c5\3\2\2\2\62\u01cb\3\2\2\2\64\u01eb\3\2\2"+
		"\2\66\u01ed\3\2\2\28\u01f5\3\2\2\2:\u0200\3\2\2\2<\u020b\3\2\2\2>\u0216"+
		"\3\2\2\2@\u0227\3\2\2\2B\u0238\3\2\2\2D\u0256\3\2\2\2F\u0258\3\2\2\2H"+
		"\u0287\3\2\2\2J\u0289\3\2\2\2L\u028f\3\2\2\2N\u029c\3\2\2\2P\u02a2\3\2"+
		"\2\2R\u02a4\3\2\2\2T\u02b7\3\2\2\2V\u02b9\3\2\2\2XZ\7,\2\2YX\3\2\2\2Z"+
		"]\3\2\2\2[Y\3\2\2\2[\\\3\2\2\2\\^\3\2\2\2][\3\2\2\2^_\5\4\3\2_c\b\2\1"+
		"\2`b\7,\2\2a`\3\2\2\2be\3\2\2\2ca\3\2\2\2cd\3\2\2\2df\3\2\2\2ec\3\2\2"+
		"\2fg\7\2\2\3g\3\3\2\2\2hn\b\3\1\2ij\5\b\5\2jk\b\3\1\2km\3\2\2\2li\3\2"+
		"\2\2mp\3\2\2\2nl\3\2\2\2no\3\2\2\2ov\3\2\2\2pn\3\2\2\2qr\5\24\13\2rs\b"+
		"\3\1\2su\3\2\2\2tq\3\2\2\2ux\3\2\2\2vt\3\2\2\2vw\3\2\2\2wy\3\2\2\2xv\3"+
		"\2\2\2yz\5\6\4\2z{\b\3\1\2{\5\3\2\2\2|}\b\4\1\2}~\7\3\2\2~\177\7%\2\2"+
		"\177\u0080\7&\2\2\u0080\u0081\5\32\16\2\u0081\u0082\b\4\1\2\u0082\7\3"+
		"\2\2\2\u0083\u0084\b\5\1\2\u0084\u0085\7\35\2\2\u0085\u0086\5R*\2\u0086"+
		"\u009c\b\5\1\2\u0087\u0088\7\30\2\2\u0088\u008a\5\16\b\2\u0089\u008b\7"+
		",\2\2\u008a\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008a\3\2\2\2\u008c"+
		"\u008d\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u008f\7\31\2\2\u008f\u0090\b"+
		"\5\1\2\u0090\u009d\3\2\2\2\u0091\u0093\7,\2\2\u0092\u0091\3\2\2\2\u0093"+
		"\u0094\3\2\2\2\u0094\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0096\3\2"+
		"\2\2\u0096\u0098\5\f\7\2\u0097\u0099\7+\2\2\u0098\u0097\3\2\2\2\u0098"+
		"\u0099\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u009b\b\5\1\2\u009b\u009d\3\2"+
		"\2\2\u009c\u0087\3\2\2\2\u009c\u0092\3\2\2\2\u009d\u009f\3\2\2\2\u009e"+
		"\u00a0\7,\2\2\u009f\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u009f\3\2"+
		"\2\2\u00a1\u00a2\3\2\2\2\u00a2\t\3\2\2\2\u00a3\u00a4\b\6\1\2\u00a4\u00a5"+
		"\5T+\2\u00a5\u00a6\b\6\1\2\u00a6\u00a7\5R*\2\u00a7\u00a8\b\6\1\2\u00a8"+
		"\u00a9\5\26\f\2\u00a9\u00aa\b\6\1\2\u00aa\u00ac\7\30\2\2\u00ab\u00ad\7"+
		",\2\2\u00ac\u00ab\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00ac\3\2\2\2\u00ae"+
		"\u00af\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b1\5\22\n\2\u00b1\u00b2\b"+
		"\6\1\2\u00b2\u00b3\5\20\t\2\u00b3\u00b4\b\6\1\2\u00b4\u00b5\7\31\2\2\u00b5"+
		"\13\3\2\2\2\u00b6\u00b7\5 \21\2\u00b7\u00b8\b\7\1\2\u00b8\u00bd\3\2\2"+
		"\2\u00b9\u00ba\5\n\6\2\u00ba\u00bb\b\7\1\2\u00bb\u00bd\3\2\2\2\u00bc\u00b6"+
		"\3\2\2\2\u00bc\u00b9\3\2\2\2\u00bd\r\3\2\2\2\u00be\u00d2\b\b\1\2\u00bf"+
		"\u00c1\7,\2\2\u00c0\u00bf\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c0\3\2"+
		"\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00ca\3\2\2\2\u00c4\u00c5\5\f\7\2\u00c5"+
		"\u00c6\7+\2\2\u00c6\u00c7\b\b\1\2\u00c7\u00c9\3\2\2\2\u00c8\u00c4\3\2"+
		"\2\2\u00c9\u00cc\3\2\2\2\u00ca\u00c8\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb"+
		"\u00cd\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cd\u00ce\5\f\7\2\u00ce\u00d0\b\b"+
		"\1\2\u00cf\u00d1\7+\2\2\u00d0\u00cf\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1"+
		"\u00d3\3\2\2\2\u00d2\u00c0\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00d2\3\2"+
		"\2\2\u00d4\u00d5\3\2\2\2\u00d5\17\3\2\2\2\u00d6\u00d7\7\37\2\2\u00d7\u00d8"+
		"\5\32\16\2\u00d8\u00da\b\t\1\2\u00d9\u00db\7,\2\2\u00da\u00d9\3\2\2\2"+
		"\u00db\u00dc\3\2\2\2\u00dc\u00da\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd\21"+
		"\3\2\2\2\u00de\u00df\7 \2\2\u00df\u00e0\5\32\16\2\u00e0\u00e2\b\n\1\2"+
		"\u00e1\u00e3\7,\2\2\u00e2\u00e1\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e2"+
		"\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\23\3\2\2\2\u00e6\u00ec\b\13\1\2\u00e7"+
		"\u00e8\5T+\2\u00e8\u00e9\b\13\1\2\u00e9\u00ed\3\2\2\2\u00ea\u00eb\7\5"+
		"\2\2\u00eb\u00ed\b\13\1\2\u00ec\u00e7\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ed"+
		"\u00ee\3\2\2\2\u00ee\u00ef\5R*\2\u00ef\u00f0\b\13\1\2\u00f0\u00f1\5\26"+
		"\f\2\u00f1\u00f2\b\13\1\2\u00f2\u00f3\5\32\16\2\u00f3\u00f5\b\13\1\2\u00f4"+
		"\u00f6\7,\2\2\u00f5\u00f4\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7\u00f5\3\2"+
		"\2\2\u00f7\u00f8\3\2\2\2\u00f8\25\3\2\2\2\u00f9\u00fa\b\f\1\2\u00fa\u0108"+
		"\7%\2\2\u00fb\u00fc\5T+\2\u00fc\u00fd\5R*\2\u00fd\u0105\b\f\1\2\u00fe"+
		"\u00ff\7)\2\2\u00ff\u0100\5T+\2\u0100\u0101\5R*\2\u0101\u0102\b\f\1\2"+
		"\u0102\u0104\3\2\2\2\u0103\u00fe\3\2\2\2\u0104\u0107\3\2\2\2\u0105\u0103"+
		"\3\2\2\2\u0105\u0106\3\2\2\2\u0106\u0109\3\2\2\2\u0107\u0105\3\2\2\2\u0108"+
		"\u00fb\3\2\2\2\u0108\u0109\3\2\2\2\u0109\u010a\3\2\2\2\u010a\u010b\7&"+
		"\2\2\u010b\27\3\2\2\2\u010c\u0118\b\r\1\2\u010d\u010e\5\66\34\2\u010e"+
		"\u0115\b\r\1\2\u010f\u0110\7)\2\2\u0110\u0111\5\66\34\2\u0111\u0112\b"+
		"\r\1\2\u0112\u0114\3\2\2\2\u0113\u010f\3\2\2\2\u0114\u0117\3\2\2\2\u0115"+
		"\u0113\3\2\2\2\u0115\u0116\3\2\2\2\u0116\u0119\3\2\2\2\u0117\u0115\3\2"+
		"\2\2\u0118\u010d\3\2\2\2\u0118\u0119\3\2\2\2\u0119\31\3\2\2\2\u011a\u011b"+
		"\5\36\20\2\u011b\u011c\b\16\1\2\u011c\u0128\3\2\2\2\u011d\u011f\7,\2\2"+
		"\u011e\u011d\3\2\2\2\u011f\u0120\3\2\2\2\u0120\u011e\3\2\2\2\u0120\u0121"+
		"\3\2\2\2\u0121\u0122\3\2\2\2\u0122\u0123\5\64\33\2\u0123\u0125\b\16\1"+
		"\2\u0124\u0126\7+\2\2\u0125\u0124\3\2\2\2\u0125\u0126\3\2\2\2\u0126\u0128"+
		"\3\2\2\2\u0127\u011a\3\2\2\2\u0127\u011e\3\2\2\2\u0128\33\3\2\2\2\u0129"+
		"\u012a\5\36\20\2\u012a\u012b\b\17\1\2\u012b\u0135\3\2\2\2\u012c\u012e"+
		"\7,\2\2\u012d\u012c\3\2\2\2\u012e\u012f\3\2\2\2\u012f\u012d\3\2\2\2\u012f"+
		"\u0130\3\2\2\2\u0130\u0131\3\2\2\2\u0131\u0132\5\64\33\2\u0132\u0133\b"+
		"\17\1\2\u0133\u0135\3\2\2\2\u0134\u0129\3\2\2\2\u0134\u012d\3\2\2\2\u0135"+
		"\35\3\2\2\2\u0136\u0137\b\20\1\2\u0137\u0138\7\30\2\2\u0138\u014c\b\20"+
		"\1\2\u0139\u013b\7,\2\2\u013a\u0139\3\2\2\2\u013b\u013c\3\2\2\2\u013c"+
		"\u013a\3\2\2\2\u013c\u013d\3\2\2\2\u013d\u0144\3\2\2\2\u013e\u013f\5\64"+
		"\33\2\u013f\u0140\7+\2\2\u0140\u0141\b\20\1\2\u0141\u0143\3\2\2\2\u0142"+
		"\u013e\3\2\2\2\u0143\u0146\3\2\2\2\u0144\u0142\3\2\2\2\u0144\u0145\3\2"+
		"\2\2\u0145\u0147\3\2\2\2\u0146\u0144\3\2\2\2\u0147\u0148\5\64\33\2\u0148"+
		"\u014a\b\20\1\2\u0149\u014b\7+\2\2\u014a\u0149\3\2\2\2\u014a\u014b\3\2"+
		"\2\2\u014b\u014d\3\2\2\2\u014c\u013a\3\2\2\2\u014d\u014e\3\2\2\2\u014e"+
		"\u014c\3\2\2\2\u014e\u014f\3\2\2\2\u014f\u0151\3\2\2\2\u0150\u0152\7,"+
		"\2\2\u0151\u0150\3\2\2\2\u0152\u0153\3\2\2\2\u0153\u0151\3\2\2\2\u0153"+
		"\u0154\3\2\2\2\u0154\u0155\3\2\2\2\u0155\u0156\7\31\2\2\u0156\37\3\2\2"+
		"\2\u0157\u0158\b\21\1\2\u0158\u0159\5T+\2\u0159\u015a\5R*\2\u015a\u015f"+
		"\b\21\1\2\u015b\u015c\7#\2\2\u015c\u015d\58\35\2\u015d\u015e\b\21\1\2"+
		"\u015e\u0160\3\2\2\2\u015f\u015b\3\2\2\2\u015f\u0160\3\2\2\2\u0160\u0161"+
		"\3\2\2\2\u0161\u016f\b\21\1\2\u0162\u0163\7)\2\2\u0163\u0164\5R*\2\u0164"+
		"\u0169\b\21\1\2\u0165\u0166\7#\2\2\u0166\u0167\58\35\2\u0167\u0168\b\21"+
		"\1\2\u0168\u016a\3\2\2\2\u0169\u0165\3\2\2\2\u0169\u016a\3\2\2\2\u016a"+
		"\u016b\3\2\2\2\u016b\u016c\b\21\1\2\u016c\u016e\3\2\2\2\u016d\u0162\3"+
		"\2\2\2\u016e\u0171\3\2\2\2\u016f\u016d\3\2\2\2\u016f\u0170\3\2\2\2\u0170"+
		"\u0172\3\2\2\2\u0171\u016f\3\2\2\2\u0172\u0173\b\21\1\2\u0173!\3\2\2\2"+
		"\u0174\u0175\5H%\2\u0175\u0181\b\22\1\2\u0176\u0177\7%\2\2\u0177\u0178"+
		"\5\30\r\2\u0178\u0179\7&\2\2\u0179\u017a\b\22\1\2\u017a\u0180\3\2\2\2"+
		"\u017b\u017c\7*\2\2\u017c\u017d\5R*\2\u017d\u017e\b\22\1\2\u017e\u0180"+
		"\3\2\2\2\u017f\u0176\3\2\2\2\u017f\u017b\3\2\2\2\u0180\u0183\3\2\2\2\u0181"+
		"\u017f\3\2\2\2\u0181\u0182\3\2\2\2\u0182\u0184\3\2\2\2\u0183\u0181\3\2"+
		"\2\2\u0184\u0185\7%\2\2\u0185\u0186\5\30\r\2\u0186\u0187\7&\2\2\u0187"+
		"\u0188\3\2\2\2\u0188\u0189\b\22\1\2\u0189#\3\2\2\2\u018a\u018b\7\4\2\2"+
		"\u018b\u018f\b\23\1\2\u018c\u018d\5\66\34\2\u018d\u018e\b\23\1\2\u018e"+
		"\u0190\3\2\2\2\u018f\u018c\3\2\2\2\u018f\u0190\3\2\2\2\u0190\u0191\3\2"+
		"\2\2\u0191\u0192\b\23\1\2\u0192%\3\2\2\2\u0193\u0194\7\t\2\2\u0194\u0195"+
		"\5\66\34\2\u0195\u019e\b\24\1\2\u0196\u0197\5\34\17\2\u0197\u0198\b\24"+
		"\1\2\u0198\u019f\3\2\2\2\u0199\u019a\5\32\16\2\u019a\u019b\b\24\1\2\u019b"+
		"\u019c\5(\25\2\u019c\u019d\b\24\1\2\u019d\u019f\3\2\2\2\u019e\u0196\3"+
		"\2\2\2\u019e\u0199\3\2\2\2\u019f\'\3\2\2\2\u01a0\u01a2\7,\2\2\u01a1\u01a0"+
		"\3\2\2\2\u01a2\u01a5\3\2\2\2\u01a3\u01a1\3\2\2\2\u01a3\u01a4\3\2\2\2\u01a4"+
		"\u01a6\3\2\2\2\u01a5\u01a3\3\2\2\2\u01a6\u01a7\7\n\2\2\u01a7\u01a8\5\34"+
		"\17\2\u01a8\u01a9\b\25\1\2\u01a9)\3\2\2\2\u01aa\u01ab\5,\27\2\u01ab\u01ac"+
		"\b\26\1\2\u01ac\u01b1\3\2\2\2\u01ad\u01ae\5.\30\2\u01ae\u01af\b\26\1\2"+
		"\u01af\u01b1\3\2\2\2\u01b0\u01aa\3\2\2\2\u01b0\u01ad\3\2\2\2\u01b1+\3"+
		"\2\2\2\u01b2\u01b3\b\27\1\2\u01b3\u01b4\7!\2\2\u01b4\u01b5\5\66\34\2\u01b5"+
		"\u01b6\5\34\17\2\u01b6\u01b7\b\27\1\2\u01b7-\3\2\2\2\u01b8\u01b9\b\30"+
		"\1\2\u01b9\u01ba\7\"\2\2\u01ba\u01be\5\32\16\2\u01bb\u01bd\7,\2\2\u01bc"+
		"\u01bb\3\2\2\2\u01bd\u01c0\3\2\2\2\u01be\u01bc\3\2\2\2\u01be\u01bf\3\2"+
		"\2\2\u01bf\u01c1\3\2\2\2\u01c0\u01be\3\2\2\2\u01c1\u01c2\7!\2\2\u01c2"+
		"\u01c3\5\66\34\2\u01c3\u01c4\b\30\1\2\u01c4/\3\2\2\2\u01c5\u01c6\7\7\2"+
		"\2\u01c6\u01c7\7%\2\2\u01c7\u01c8\5\66\34\2\u01c8\u01c9\b\31\1\2\u01c9"+
		"\u01ca\7&\2\2\u01ca\61\3\2\2\2\u01cb\u01cc\58\35\2\u01cc\u01cd\7#\2\2"+
		"\u01cd\u01ce\5\66\34\2\u01ce\u01cf\b\32\1\2\u01cf\63\3\2\2\2\u01d0\u01d1"+
		"\5&\24\2\u01d1\u01d2\b\33\1\2\u01d2\u01ec\3\2\2\2\u01d3\u01d4\5\60\31"+
		"\2\u01d4\u01d5\b\33\1\2\u01d5\u01ec\3\2\2\2\u01d6\u01d7\5\"\22\2\u01d7"+
		"\u01d8\b\33\1\2\u01d8\u01ec\3\2\2\2\u01d9\u01da\5$\23\2\u01da\u01db\b"+
		"\33\1\2\u01db\u01ec\3\2\2\2\u01dc\u01dd\5\62\32\2\u01dd\u01de\b\33\1\2"+
		"\u01de\u01ec\3\2\2\2\u01df\u01e0\5 \21\2\u01e0\u01e1\b\33\1\2\u01e1\u01ec"+
		"\3\2\2\2\u01e2\u01e3\5*\26\2\u01e3\u01e4\b\33\1\2\u01e4\u01ec\3\2\2\2"+
		"\u01e5\u01e6\5L\'\2\u01e6\u01e7\b\33\1\2\u01e7\u01ec\3\2\2\2\u01e8\u01e9"+
		"\5J&\2\u01e9\u01ea\b\33\1\2\u01ea\u01ec\3\2\2\2\u01eb\u01d0\3\2\2\2\u01eb"+
		"\u01d3\3\2\2\2\u01eb\u01d6\3\2\2\2\u01eb\u01d9\3\2\2\2\u01eb\u01dc\3\2"+
		"\2\2\u01eb\u01df\3\2\2\2\u01eb\u01e2\3\2\2\2\u01eb\u01e5\3\2\2\2\u01eb"+
		"\u01e8\3\2\2\2\u01ec\65\3\2\2\2\u01ed\u01ee\58\35\2\u01ee\u01f3\b\34\1"+
		"\2\u01ef\u01f0\7#\2\2\u01f0\u01f1\5\66\34\2\u01f1\u01f2\b\34\1\2\u01f2"+
		"\u01f4\3\2\2\2\u01f3\u01ef\3\2\2\2\u01f3\u01f4\3\2\2\2\u01f4\67\3\2\2"+
		"\2\u01f5\u01f6\5:\36\2\u01f6\u01fd\b\35\1\2\u01f7\u01f8\7\24\2\2\u01f8"+
		"\u01f9\5:\36\2\u01f9\u01fa\b\35\1\2\u01fa\u01fc\3\2\2\2\u01fb\u01f7\3"+
		"\2\2\2\u01fc\u01ff\3\2\2\2\u01fd\u01fb\3\2\2\2\u01fd\u01fe\3\2\2\2\u01fe"+
		"9\3\2\2\2\u01ff\u01fd\3\2\2\2\u0200\u0201\5<\37\2\u0201\u0208\b\36\1\2"+
		"\u0202\u0203\7\23\2\2\u0203\u0204\5<\37\2\u0204\u0205\b\36\1\2\u0205\u0207"+
		"\3\2\2\2\u0206\u0202\3\2\2\2\u0207\u020a\3\2\2\2\u0208\u0206\3\2\2\2\u0208"+
		"\u0209\3\2\2\2\u0209;\3\2\2\2\u020a\u0208\3\2\2\2\u020b\u020c\5> \2\u020c"+
		"\u0213\b\37\1\2\u020d\u020e\7\17\2\2\u020e\u020f\5> \2\u020f\u0210\b\37"+
		"\1\2\u0210\u0212\3\2\2\2\u0211\u020d\3\2\2\2\u0212\u0215\3\2\2\2\u0213"+
		"\u0211\3\2\2\2\u0213\u0214\3\2\2\2\u0214=\3\2\2\2\u0215\u0213\3\2\2\2"+
		"\u0216\u0217\5@!\2\u0217\u0218\b \1\2\u0218\u0224\b \1\2\u0219\u021a\7"+
		"\21\2\2\u021a\u021e\b \1\2\u021b\u021c\7\22\2\2\u021c\u021e\b \1\2\u021d"+
		"\u0219\3\2\2\2\u021d\u021b\3\2\2\2\u021e\u021f\3\2\2\2\u021f\u0220\5@"+
		"!\2\u0220\u0221\b \1\2\u0221\u0223\3\2\2\2\u0222\u021d\3\2\2\2\u0223\u0226"+
		"\3\2\2\2\u0224\u0222\3\2\2\2\u0224\u0225\3\2\2\2\u0225?\3\2\2\2\u0226"+
		"\u0224\3\2\2\2\u0227\u0228\5B\"\2\u0228\u0229\b!\1\2\u0229\u0235\b!\1"+
		"\2\u022a\u022b\7\13\2\2\u022b\u022f\b!\1\2\u022c\u022d\7\f\2\2\u022d\u022f"+
		"\b!\1\2\u022e\u022a\3\2\2\2\u022e\u022c\3\2\2\2\u022f\u0230\3\2\2\2\u0230"+
		"\u0231\5B\"\2\u0231\u0232\b!\1\2\u0232\u0234\3\2\2\2\u0233\u022e\3\2\2"+
		"\2\u0234\u0237\3\2\2\2\u0235\u0233\3\2\2\2\u0235\u0236\3\2\2\2\u0236A"+
		"\3\2\2\2\u0237\u0235\3\2\2\2\u0238\u0239\5D#\2\u0239\u023a\b\"\1\2\u023a"+
		"\u0246\b\"\1\2\u023b\u023c\7\r\2\2\u023c\u0240\b\"\1\2\u023d\u023e\7\16"+
		"\2\2\u023e\u0240\b\"\1\2\u023f\u023b\3\2\2\2\u023f\u023d\3\2\2\2\u0240"+
		"\u0241\3\2\2\2\u0241\u0242\5D#\2\u0242\u0243\b\"\1\2\u0243\u0245\3\2\2"+
		"\2\u0244\u023f\3\2\2\2\u0245\u0248\3\2\2\2\u0246\u0244\3\2\2\2\u0246\u0247"+
		"\3\2\2\2\u0247C\3\2\2\2\u0248\u0246\3\2\2\2\u0249\u024e\b#\1\2\u024a\u024b"+
		"\7\25\2\2\u024b\u024f\b#\1\2\u024c\u024d\7\f\2\2\u024d\u024f\b#\1\2\u024e"+
		"\u024a\3\2\2\2\u024e\u024c\3\2\2\2\u024f\u0250\3\2\2\2\u0250\u0251\5D"+
		"#\2\u0251\u0252\b#\1\2\u0252\u0257\3\2\2\2\u0253\u0254\5F$\2\u0254\u0255"+
		"\b#\1\2\u0255\u0257\3\2\2\2\u0256\u0249\3\2\2\2\u0256\u0253\3\2\2\2\u0257"+
		"E\3\2\2\2\u0258\u0259\5H%\2\u0259\u0265\b$\1\2\u025a\u025b\7%\2\2\u025b"+
		"\u025c\5\30\r\2\u025c\u025d\7&\2\2\u025d\u025e\b$\1\2\u025e\u0264\3\2"+
		"\2\2\u025f\u0260\7*\2\2\u0260\u0261\5R*\2\u0261\u0262\b$\1\2\u0262\u0264"+
		"\3\2\2\2\u0263\u025a\3\2\2\2\u0263\u025f\3\2\2\2\u0264\u0267\3\2\2\2\u0265"+
		"\u0263\3\2\2\2\u0265\u0266\3\2\2\2\u0266\u0273\3\2\2\2\u0267\u0265\3\2"+
		"\2\2\u0268\u0269\7\'\2\2\u0269\u026a\5\66\34\2\u026a\u026b\7(\2\2\u026b"+
		"\u026c\b$\1\2\u026c\u0272\3\2\2\2\u026d\u026e\7*\2\2\u026e\u026f\5R*\2"+
		"\u026f\u0270\b$\1\2\u0270\u0272\3\2\2\2\u0271\u0268\3\2\2\2\u0271\u026d"+
		"\3\2\2\2\u0272\u0275\3\2\2\2\u0273\u0271\3\2\2\2\u0273\u0274\3\2\2\2\u0274"+
		"G\3\2\2\2\u0275\u0273\3\2\2\2\u0276\u0277\5N(\2\u0277\u0278\b%\1\2\u0278"+
		"\u0288\3\2\2\2\u0279\u027a\5R*\2\u027a\u027b\b%\1\2\u027b\u0288\3\2\2"+
		"\2\u027c\u027d\7%\2\2\u027d\u027e\5\30\r\2\u027e\u027f\7&\2\2\u027f\u0280"+
		"\b%\1\2\u0280\u0288\3\2\2\2\u0281\u0282\5J&\2\u0282\u0283\b%\1\2\u0283"+
		"\u0288\3\2\2\2\u0284\u0285\5L\'\2\u0285\u0286\b%\1\2\u0286\u0288\3\2\2"+
		"\2\u0287\u0276\3\2\2\2\u0287\u0279\3\2\2\2\u0287\u027c\3\2\2\2\u0287\u0281"+
		"\3\2\2\2\u0287\u0284\3\2\2\2\u0288I\3\2\2\2\u0289\u028a\7\6\2\2\u028a"+
		"\u028b\7%\2\2\u028b\u028c\5\66\34\2\u028c\u028d\b&\1\2\u028d\u028e\7&"+
		"\2\2\u028eK\3\2\2\2\u028f\u0290\7\b\2\2\u0290\u0291\7%\2\2\u0291\u0292"+
		"\5\66\34\2\u0292\u0293\7)\2\2\u0293\u0294\5\66\34\2\u0294\u0295\7&\2\2"+
		"\u0295\u0296\b\'\1\2\u0296M\3\2\2\2\u0297\u0298\5P)\2\u0298\u0299\b(\1"+
		"\2\u0299\u029d\3\2\2\2\u029a\u029b\7-\2\2\u029b\u029d\b(\1\2\u029c\u0297"+
		"\3\2\2\2\u029c\u029a\3\2\2\2\u029dO\3\2\2\2\u029e\u029f\7\26\2\2\u029f"+
		"\u02a3\b)\1\2\u02a0\u02a1\7\27\2\2\u02a1\u02a3\b)\1\2\u02a2\u029e\3\2"+
		"\2\2\u02a2\u02a0\3\2\2\2\u02a3Q\3\2\2\2\u02a4\u02a5\7.\2\2\u02a5\u02a6"+
		"\b*\1\2\u02a6S\3\2\2\2\u02a7\u02a8\7\32\2\2\u02a8\u02b8\b+\1\2\u02a9\u02aa"+
		"\7\33\2\2\u02aa\u02b8\b+\1\2\u02ab\u02ac\7\34\2\2\u02ac\u02ad\7$\2\2\u02ad"+
		"\u02ae\5T+\2\u02ae\u02af\b+\1\2\u02af\u02b8\3\2\2\2\u02b0\u02b1\7\35\2"+
		"\2\u02b1\u02b2\5R*\2\u02b2\u02b3\b+\1\2\u02b3\u02b8\3\2\2\2\u02b4\u02b5"+
		"\5V,\2\u02b5\u02b6\b+\1\2\u02b6\u02b8\3\2\2\2\u02b7\u02a7\3\2\2\2\u02b7"+
		"\u02a9\3\2\2\2\u02b7\u02ab\3\2\2\2\u02b7\u02b0\3\2\2\2\u02b7\u02b4\3\2"+
		"\2\2\u02b8U\3\2\2\2\u02b9\u02ba\7\36\2\2\u02ba\u02bb\b,\1\2\u02bb\u02c8"+
		"\7\22\2\2\u02bc\u02c9\7\5\2\2\u02bd\u02be\5T+\2\u02be\u02c5\b,\1\2\u02bf"+
		"\u02c0\7)\2\2\u02c0\u02c1\5T+\2\u02c1\u02c2\b,\1\2\u02c2\u02c4\3\2\2\2"+
		"\u02c3\u02bf\3\2\2\2\u02c4\u02c7\3\2\2\2\u02c5\u02c3\3\2\2\2\u02c5\u02c6"+
		"\3\2\2\2\u02c6\u02c9\3\2\2\2\u02c7\u02c5\3\2\2\2\u02c8\u02bc\3\2\2\2\u02c8"+
		"\u02bd\3\2\2\2\u02c9\u02ca\3\2\2\2\u02ca\u02cd\7\20\2\2\u02cb\u02ce\5"+
		"T+\2\u02cc\u02ce\7\5\2\2\u02cd\u02cb\3\2\2\2\u02cd\u02cc\3\2\2\2\u02ce"+
		"\u02cf\3\2\2\2\u02cf\u02d0\7\21\2\2\u02d0\u02d1\b,\1\2\u02d1W\3\2\2\2"+
		"E[cnv\u008c\u0094\u0098\u009c\u00a1\u00ae\u00bc\u00c2\u00ca\u00d0\u00d4"+
		"\u00dc\u00e4\u00ec\u00f7\u0105\u0108\u0115\u0118\u0120\u0125\u0127\u012f"+
		"\u0134\u013c\u0144\u014a\u014e\u0153\u015f\u0169\u016f\u017f\u0181\u018f"+
		"\u019e\u01a3\u01b0\u01be\u01eb\u01f3\u01fd\u0208\u0213\u021d\u0224\u022e"+
		"\u0235\u023f\u0246\u024e\u0256\u0263\u0265\u0271\u0273\u0287\u029c\u02a2"+
		"\u02b7\u02c5\u02c8\u02cd";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}