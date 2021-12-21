
import com.google.gson.Gson;
import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.pdf.draw.VerticalPositionMark;
//import com.itextpdf.pdfrender.RenderingProperties;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Main {

    private static Font headerFont = new Font(Font.FontFamily.TIMES_ROMAN, 26, Font.BOLD);
    private static Font informationFont = new Font(Font.FontFamily.TIMES_ROMAN, 20, Font.BOLD);
    private static Font routingFont = new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.BOLD);
    private static Font licenceFont = new Font(Font.FontFamily.TIMES_ROMAN,11, Font.NORMAL);
    private static Font shipToFont = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL);
    private static Font shipFromFont = new Font(Font.FontFamily.TIMES_ROMAN, 8, Font.NORMAL);

    enum LABEL_TYPE {
        DOMESTIC,
        INTERNATIONAL,
        COLLECT
    }

    private static String parseFile(String filename) throws FileNotFoundException {
        Scanner scanner = new Scanner( new File("shipment.json") );
        String result = scanner.useDelimiter("\\A").next();
        scanner.close();
        return result;
    }

    private static Label jsonToLabel(String filename) throws Exception {
        Gson g = new Gson();;
        Label label = g.fromJson(parseFile(filename), Label.class);
        label.setRoutingCode(label.generateRoutingCode());
        System.out.println(label.toString());
        return label;
    }

    private static Paragraph createParagraph(String text, Font font) {
        Paragraph paragraph = new Paragraph(text);
        paragraph.setFont(font);
        return paragraph;
    }

    private static Phrase createPhrase(String text, Font font) {
        Phrase phrase = new Phrase(text);
        phrase.setFont(font);
        return phrase;
    }

    private static PdfPTable createRow(Phrase phrase) {
        PdfPTable table = new PdfPTable(1);
        table.addCell(phrase);
        return table;
    }

    private static void createDomestic(Label label, Document document, PdfWriter pdfWriter,
                                       PdfContentByte pdfContentByte) throws Exception {
        //Initialize values
        Chunk chunk = new Chunk(new VerticalPositionMark());
        PdfPTable table = new PdfPTable(1);
        Phrase phrase = new Phrase();
        Paragraph paragraph = new Paragraph();
        //PdfPCell cellOne = new PdfPCell();
        //cellOne.setBorder(Rectangle.NO_BORDER);
        //table.addCell(cellOne);

        //Add from address
        phrase.setFont(shipFromFont);
        phrase.add(
                "FROM: "+
                        label.getFromAddress().getFirstName()+" "+
                        label.getFromAddress().getLastName()+", "+
                        label.getFromAddress().getZip()
        );

        //Add whitespace
        phrase.add(chunk);

        //Add meter number
        paragraph.setFont(licenceFont);
        paragraph.add("Meter: 34001");

        //Combine and add to pdf
        phrase.add(paragraph);
        table.addCell(phrase);
        document.add(table);

        //Reset
        table = new PdfPTable(1);
        phrase = new Phrase();
        paragraph = new Paragraph();

        //Add service centre name
        //TODO: currently hardcoded as data is not provided within the test json
        phrase.setFont(informationFont);
        phrase.add("06_PRST-G159");

        //Add whitespace
        phrase.add(chunk);

        //Add tour ID
        //TODO: currently hardcoded as data is not provided within the test json
        paragraph.setFont(informationFont);
        paragraph.add("36B (00)");

        //Combine and add to pdf
        phrase.add(paragraph);
        table.addCell(phrase);
        document.add(table);

        //Reset
        table = new PdfPTable(1);
        phrase = new Phrase();
        paragraph = new Paragraph();

        //Add barcode image
        //TODO: barcode now generated in label class, now need to display as image

        //Integrated systems will produce ‘Licence Plate’ and ‘Routing Code’ barcodes.
        //There are two barcode formats supported in the delivery network, Code128 and EAN128.
        // For bar-coded information defined under EAN-standards (such as the EAN SSCC),
        // the EAN 128-barcode symbology must be used.
        // Only EAN128 barcodes may contain the special character FNC1 as the first element of the barcode.
        // Code128 barcodes with special characters are not supported.
        //String licencePlate = "(J)JD00 022 340 0100 0001";
        //Section 6.2 showcases how to generate Routing code form the delivery postcode and service elements
        //String routingCode = "2LGBB11AA+01000024";
        Barcode128 barcode = new Barcode128();
        //EAN13 = 1, Code128 = 9
        barcode.setCodeType(Barcode128.CODE128);
        barcode.setCode(label.getRoutingCode());
        Image image = barcode.createImageWithBarcode(pdfContentByte, null, null);
        table.addCell(image);
        document.add(table);

        //Reset
        table = new PdfPTable(1);
        phrase = new Phrase();
        paragraph = new Paragraph();

        //Add consignee ref
        document.add(createRow(createPhrase("Consignee Ref: ", routingFont)));

        //Add consignor ref
        document.add(createRow(createPhrase("Consignor Ref: ", routingFont)));

        //Add carrier logo

        //Add label type

    }

    private static void createInternational(Label label, Document document) throws Exception {

    }

    private static void createCollect(Label label, Document document) throws Exception {

    }

    private static void createPDF(Label label, String outputFile, LABEL_TYPE labelType) throws Exception {
        Document document = new Document(PageSize.A4, 10, 10, 10, 10);
        PdfWriter pdfWriter= PdfWriter.getInstance(document, new FileOutputStream(outputFile));
        document.open();
        PdfContentByte pdfContentByte = pdfWriter.getDirectContent();
        switch (labelType) {
            case DOMESTIC -> createDomestic(label, document, pdfWriter, pdfContentByte);
            case INTERNATIONAL -> createInternational(label, document);
            case COLLECT -> createCollect(label, document);
            default -> throw new Exception("Invalid labelType @ createPDF");
        }
        document.close();
    }

    public static void createPNG(String outputFile) {
        //final RenderingProperties properties = new RenderingPro
    }

    public static void main(String[] args) {
        try {
            Label label = jsonToLabel("shipment.json");
            String fileName = label.getCustomerId();
            createPDF(label, fileName+".pdf", LABEL_TYPE.DOMESTIC);
            createPNG(fileName+".png");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
