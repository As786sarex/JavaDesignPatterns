package behavioural.visitor;

public class ModelAcceptor implements Acceptor{

    private String name;
    private String description;
    private String type;

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return "ModelAcceptor{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
