package ast;

import java.util.function.Consumer;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExprStat implements Stat {
    private Expr expr;

    @Override
    public <R> R accept(NodeVisitor<R> visitor) {
        return visitor.visitExprStat(this);
    }

    @Override
    public void forEachChild(Consumer<? super Node> action) {
        action.accept(expr);
    }
}
