package sym;

import java.util.ArrayList;
import java.util.List;

import org.jetbrains.annotations.Nullable;

public class Pkg implements Sym{
    private String name;
    private @Nullable Pkg parent;
    private final List<Pkg> pkgs = new ArrayList<>();
    private final List<Clazz> clazsses = new ArrayList<>();

    public Pkg(String name, @Nullable Pkg parent) {
        this.name = name;
        this.parent= parent;
        if ( parent != null ) {
            parent.pkgs.add(this);
        }
    }

    void addClazz(Clazz clazz) {
        clazsses.add(clazz);
    }

    @Override
    public String getName() {
        return name;        
    }

}
