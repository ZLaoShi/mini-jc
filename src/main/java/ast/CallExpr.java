package ast;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

// Call expression

@Data
@AllArgsConstructor
public class CallExpr implements Expr{
    private Expr func;
    private List<Expr> args;
}
