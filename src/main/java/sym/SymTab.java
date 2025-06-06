package sym;

public class SymTab {
    private final Pkg rooPkg = new Pkg("", null);
    private final Pkg javaPkg = new Pkg("java", null);
    private final Pkg lanPkg = new Pkg("lang", javaPkg);

}
