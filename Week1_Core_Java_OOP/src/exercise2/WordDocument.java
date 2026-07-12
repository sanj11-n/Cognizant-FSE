package exercise2;

public class WordDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening Word Document... loading text formatting.");
    }
}