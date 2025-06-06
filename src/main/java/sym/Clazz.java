package sym;

import java.util.List;

import type.ClassType;

public class Clazz implements Sym, ClassType {
    private Access access;
    private String name;
    private List<ClassType> superTypes;
    private final List<Field> fields;
    private final List<Method> methods;
    private final Pkg pkg;

    public Clazz(Access access, String name, List<ClassType> superTypes, List<Field> fields, List<Method> methods, Pkg pkg) {
        this.access = access;
        this.name = name;
        this.superTypes = superTypes;
        this.fields = fields;
        this.methods = methods;
        this.pkg = pkg;
        pkg.addClazz(this);
    }

    void addField(Field field) {
        fields.add(field);
    }

    void addMethod(Method method) {
        methods.add(method);
    }

    public Access getAccess() {
        return access;
    }

    public void setAccess(Access access) {
        this.access = access;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ClassType> getSuperTypes() {
        return superTypes;
    }

    public void setSuperTypes(List<ClassType> superTypes) {
        this.superTypes = superTypes;
    }

    public List<Field> getFields() {
        return fields;
    }

    public List<Method> getMethods() {
        return methods;
    }

    public Pkg getPkg() {
        return pkg;
    }
}

