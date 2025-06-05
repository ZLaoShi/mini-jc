package ast;

import java.util.List;
import java.util.function.Consumer;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Block implements Node {
    private List<Stat> stats;

    @Override
    public <R> R accept(NodeVisitor<R> visitor) {
        return visitor.visitBlock(this);
    }

    @Override
    public void forEachChild(Consumer<? super Node> action) {
        stats.forEach(action);
    }
}
