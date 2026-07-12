package exercise2;

public class PdfDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening PDF Document... display clean layouts.");
    }
}