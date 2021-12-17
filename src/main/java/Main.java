
import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;

public class Main {

    public static void main(String[] args) {
        Document document = new Document(PageSize.A4, 50, 50, 50, 50);
        try {
            PdfWriter.getInstance(document, new FileOutputStream("test.pdf"));
        } catch (Exception e) {
            System.out.println(e);
        }
        document.open();
        try {
            document.add(new Paragraph("Hello World!"));
        } catch (com.itextpdf.text.DocumentException e) {
            System.out.println(e);
        }
        document.close();
    }
}
