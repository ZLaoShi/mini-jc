package ast;

import java.util.function.Consumer;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ArrayTypeExpr implements Expr{
    private Expr elemType;

    @Override
    public <R> R accept(NodeVisitor<R> visitor) {
       return visitor.visitArrayTypeExpr(this); 
    }

    @Override
    public void forEachChild(Consumer<? super Node> action) {
        action.accept(elemType);
    }
}
