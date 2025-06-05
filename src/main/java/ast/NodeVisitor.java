package ast;

public interface NodeVisitor<R> {

    R visitNode(Node node);

    R visitExpr(Expr expr);
    
    R visitStat(Stat stat);

    R visitDecl(Decl decl);

    R visitFile(File file);
    
    R visitClassDecl(ClassDecl classDecl);
    
    R visitMethodDecl(MethodDecl methodDecl);
    
    R visitParamDecl(ParamDecl paramDecl);
    
    R visitBlock(Block block);
    
    R visitExprStat(ExprStat exprStat);
    
    R visitCallExpr(CallExpr callExpr);
    
    R visitSelectorExpr(SelectorExpr selectorExpr);
    
    R visitArrayTypeExpr(ArrayTypeExpr arrayTypeExpr);
    
    R visitIdent(Ident ident);
    
    R visitLiteral(Literal literal);
    
    R visitTypeNode(TypeNode typeNode);
}