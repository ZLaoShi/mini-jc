package ast;

import java.util.function.Consumer;

import lombok.AllArgsConstructor;
import lombok.Data;
import sym.Param;

@Data
@AllArgsConstructor
public class ParamDecl extends DeclBase<Param>{
    private TypeNode type;
    private String name;

    @Override
    public <R> R accept(NodeVisitor<R> visitor) {
        return visitor.visitParamDecl(this);
    }

    @Override
    public void forEachChild(Consumer<? super Node> action) {
        action.accept(type);
    }
}
