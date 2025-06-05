package ast;

import java.util.function.Consumer;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor 
public class TypeNode implements Node {
    private Expr expr;

    @Override
    public <R> R accept(NodeVisitor<R> visitor) {
        return visitor.visitTypeNode(this);
    }

    @Override
    public void forEachChild(Consumer<? super Node> action) {
        action.accept(expr);
    }
}
