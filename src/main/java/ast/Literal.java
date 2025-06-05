package ast;

import java.util.function.Consumer;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Literal implements Expr {
    private Object value;

    @Override
    public <R> R accept(NodeVisitor<R> visitor) {
        return visitor.visitLiteral(this);
    }

    @Override
    public void forEachChild(Consumer<? super Node> action) {
    }  
}
