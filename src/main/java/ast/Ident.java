package ast;

import lombok.AllArgsConstructor;
import lombok.Data;

// Indentfier

@Data
@AllArgsConstructor
public class Ident implements Expr {
    private String name;
    
}
