package behavioural.visitor;

public class ConcreteVisitor implements Visitor {

    @Override
    public void visit(ModelAcceptor modelAcceptor) {
        System.out.printf("Visiting %s class with values %s",modelAcceptor.getClass().getName(), modelAcceptor);
    }
}
