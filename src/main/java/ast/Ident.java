package ast;

import java.util.function.Consumer;

import lombok.AllArgsConstructor;
import lombok.Data;

// Indentfier

@Data
@AllArgsConstructor
public class Ident implements Expr {
    private String name;

    @Override
    public <R> R accept(NodeVisitor<R> visitor) {
        return visitor.visitIdent(this);
    }

    @Override
    public void forEachChild(Consumer<? super Node> action) {
    }
    
}
