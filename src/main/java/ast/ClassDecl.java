package ast;

import java.util.List;
import java.util.function.Consumer;

import lombok.AllArgsConstructor;
import lombok.Data;
import sym.Clazz;

@Data
@AllArgsConstructor
public class ClassDecl extends DeclBase<Clazz> {
    private List<Modifier> mods;
    private String name;
    private List<Decl> members;

    @Override
    public <R> R accept(NodeVisitor<R> visitor) {
        return visitor.visitClassDecl(this);
    }

    @Override
    public void forEachChild(Consumer<? super Node> action) {
        members.forEach(action);
    }
}
