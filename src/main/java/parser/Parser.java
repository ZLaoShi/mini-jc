package parser;

import java.util.ArrayList;
import java.util.List;

import ast.ArrayTypeExpr;
import ast.Block;
import ast.CallExpr;
import ast.ClassDecl;
import ast.Decl;
import ast.Expr;
import ast.ExprStat;
import ast.File;
import ast.Ident;
import ast.Literal;
import ast.MethodDecl;
import ast.Modifier;
import ast.ParamDecl;
import ast.SelectorExpr;
import ast.Stat;
import ast.TypeNode;
import lexer.Lexer;
import lexer.Token;
import lexer.TokenKind;

public class Parser {
    private final Lexer lexer;

    private Token token;

    public Parser(Lexer lexer) {
        this.lexer = lexer;
        token = lexer.nextToken();
    }

    public File parse() {
        var classes = new ArrayList<ClassDecl>();
        while (!test(TokenKind.EOF)) {
            classes.add(classDecl());
        }
        return new File(classes);
    }
    
    private ClassDecl classDecl() {
        var mods = modifiers();
        accept(TokenKind.CLASS);
        var name = name();
        var members = new ArrayList<Decl>();
        accept(TokenKind.LBRACE);
        while (!test(TokenKind.RBRACE)) {
            members.add(classMember());
        }
        accept(TokenKind.RBRACE);
        return new ClassDecl(mods, name, members);
    }

    private Decl classMember() {
        return mothodDecl();
    }

    private List<Modifier> modifiers() {
        var mods = new ArrayList<Modifier>();
        for (;;next()) {
            switch (token.kind()) {
                case PUBLIC -> mods.add(Modifier.PUBLIC);
                case STATIC -> mods.add(Modifier.STATIC);
                default -> { return mods; }
            }
        }
    }

    private MethodDecl mothodDecl() {
        var mods = modifiers();
        var retType = type();
        var name = name();
        var params = new ArrayList<ParamDecl>();
        accept(TokenKind.LPAREN);
        if (!test(TokenKind.RPAREN)) {
            params.add(ParamDecl());
            while (test(TokenKind.COMMA)) {
                next();
                params.add(ParamDecl());
            }
        }
        accept(TokenKind.RPAREN);
        var body = block();
        return new MethodDecl(mods, retType, name, params, body);
    }

    private Block block() {
        accept(TokenKind.LBRACE);
        var stats = new ArrayList<Stat>();
        while (!test(TokenKind.RBRACE)) {
            stats.add(stat());
        }
        accept(TokenKind.RBRACE);
        return new Block(stats);
    }

    private Stat stat() {
        return exprStat();
    }

    private ExprStat exprStat() {
        var expr = expr();
        accept(TokenKind.SEMICOLON);
        return new ExprStat(expr);
        
    }

    private ParamDecl ParamDecl() {
       return new ParamDecl(type(), name());
    }

    private Expr expr() {
        return postfixExpr();        
    }

    private Expr atomExpr() {
        var text = token.text();
        switch (token.kind()) {
            case VOID -> {
                next();
                return new Ident("void");
            }
            case IDENTIFIER -> {
                next();
                return new Ident(text);
            }
            case STRING_LITERAL -> {
                next();
                return new Literal(text);
            }
            default -> throw new RuntimeException("Unexpected token " + text);
        }
    }

    private Expr postfixExpr() {
        var expr = atomExpr();
        for (;;) {
            switch (token.kind()) {
                case DOT -> {
                    next();
                    expr = new SelectorExpr(expr, name());
                }
                case LPAREN -> {
                    next();
                    var args = new ArrayList<Expr>();
                    if (!test(TokenKind.RPAREN)) {
                        args.add(expr());
                        while (test(TokenKind.COMMA)) {
                            next();
                            args.add(expr());
                        }
                    }
                    accept(TokenKind.RPAREN);
                    expr = new CallExpr(expr, args);
                }
                case LBRACKET -> {
                    next();
                    accept(TokenKind.RBRACKET);
                    expr = new ArrayTypeExpr(expr);
                }

                default -> { return expr; }

            }
        }
    }

    private TypeNode type() {
        // TODO check expression
        return new TypeNode(expr());     
    }

    private String name() {
        return accept(TokenKind.IDENTIFIER).text();
    }

    private boolean test(TokenKind tk) { 
        return token.kind() == tk;
    }

    private void next() {
        token = lexer.nextToken();
    }

    private Token accept(TokenKind tk) {
        if (test(tk)) {
            var t = token;
            next();
            return t;
        } else {
            throw new RuntimeException("Expected " + tk + " but found " + token.kind());
        }
    }
}
