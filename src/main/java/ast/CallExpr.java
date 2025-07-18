package ast;

import java.util.List;
import java.util.function.Consumer;

import lombok.AllArgsConstructor;
import lombok.Data;

// Call expression

@Data
@AllArgsConstructor
public class CallExpr implements Expr{
    private Expr func;
    private List<Expr> args;

    @Override
    public <R> R accept(NodeVisitor<R> visitor) {
        return visitor.visitCallExpr(this);
    }

    @Override
    public void forEachChild(Consumer<? super Node> action) {
        action.accept(func);
        args.forEach(action);
    }
}
