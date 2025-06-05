package ast;

import java.util.List;
import java.util.function.Consumer;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class File implements Node {
    private List<ClassDecl> classes;

    @Override
    public <R> R accept(NodeVisitor<R> visitor) {
        return visitor.visitFile(this);
    }

    @Override
    public void forEachChild(Consumer<? super Node> action) {
        classes.forEach(action);
    }
}
