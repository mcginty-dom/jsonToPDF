
import com.google.gson.Gson;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
//import com.gson.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.util.Scanner;

public class Main {

    private static Font headerFont = new Font(Font.FontFamily.TIMES_ROMAN, 26, Font.BOLD);
    private static Font informationFont = new Font(Font.FontFamily.TIMES_ROMAN, 20, Font.BOLD);
    private static Font routingFont = new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.BOLD);
    private static Font licenceFont = new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.NORMAL);
    private static Font shipToFont = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL);
    private static Font shipFromFont = new Font(Font.FontFamily.TIMES_ROMAN, 8, Font.NORMAL);

    private static String parseFile(String filename) throws FileNotFoundException {
        Scanner scanner = new Scanner( new File("shipment.json") );
        String result = scanner.useDelimiter("\\A").next();
        scanner.close();
        return result;
    }

    private static Label convertJSON(String filename) {
        Gson g = new Gson();
        Label label = new Label();
        try {
            label = g.fromJson(parseFile(filename), Label.class);
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        System.out.println(label.toString());
        return label;
    }

    private static void createPDF(Label label, String outputFile) {
        Document document = new Document(PageSize.A4, 10, 10, 10, 10);
        try {
            PdfWriter.getInstance(document, new FileOutputStream(outputFile));
        } catch (Exception e) {
            System.out.println(e);
        }
        document.open();
        Paragraph paragraph = new Paragraph(new Paragraph(label.toString()));
        paragraph.setAlignment(Element.ALIGN_LEFT);
        try {
            document.add(paragraph);
        } catch (com.itextpdf.text.DocumentException e) {
            System.out.println(e);
        }
        document.close();
    }

    public static void main(String[] args) {
        Label label = convertJSON("shipment.json");
        createPDF(label,"test.pdf");
    }
}
