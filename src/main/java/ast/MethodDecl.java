package ast;

import java.util.List;
import java.util.function.Consumer;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MethodDecl implements Decl{
    private List<Modifier> mods;
    private TypeNode retType;
    private String name;
    private List<ParamDecl> params;
    private Block body;

    @Override
    public <R> R accept(NodeVisitor<R> visitor) {
        return visitor.visitMethodDecl(this);
    }

    @Override
    public void forEachChild(Consumer<? super Node> action) {
        action.accept(retType);
        params.forEach(action);
        action.accept(body);
    }
}
