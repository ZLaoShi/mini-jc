package ast;

import java.util.function.Consumer;

import lombok.AllArgsConstructor;
import lombok.Data;

// Selector expression

@Data
@AllArgsConstructor
public class SelectorExpr implements Expr {
    private Expr selected;
    private String name;

    @Override
    public <R> R accept(NodeVisitor<R> visitor) {
        return visitor.visitSelectorExpr(this);
    }

    @Override
    public void forEachChild(Consumer<? super Node> action) {
        action.accept(selected);
    }
}
