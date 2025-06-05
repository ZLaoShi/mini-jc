package ast;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class File implements Node {
    private List<ClassDecl> classes;
}
