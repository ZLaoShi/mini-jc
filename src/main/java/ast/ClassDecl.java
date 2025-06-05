package ast;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClassDecl implements Decl {
    private List<Modifier> mods;
    private String name;
    private List<Decl> members;
}
