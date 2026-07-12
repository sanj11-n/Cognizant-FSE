package exercise2;

public class DocumentFactory {
    public static Document createDocument(String type) {
        if (type == null) {
            return null;
        }
        if (type.equalsIgnoreCase("PDF")) {
            return new PdfDocument();
        } else if (type.equalsIgnoreCase("WORD")) {
            return new WordDocument();
        }
        return null;
    }
}