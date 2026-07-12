package exercise4;

public class Adapter implements LegacyTarget {
    private final Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void requestOldSystem() {
        adaptee.specificRequest();
    }
}