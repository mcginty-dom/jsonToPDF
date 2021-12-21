
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
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    private static Font headerFont = new Font(Font.FontFamily.TIMES_ROMAN, 26, Font.BOLD);
    private static Font headerFontInverted = new Font(Font.FontFamily.TIMES_ROMAN, 26, Font.BOLD, BaseColor.WHITE);
    private static Font informationFont = new Font(Font.FontFamily.TIMES_ROMAN, 20, Font.BOLD);
    private static Font routingFont = new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.BOLD);
    private static Font routingFontInverted = new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.BOLD, BaseColor.WHITE);
    private static Font licenceFont = new Font(Font.FontFamily.TIMES_ROMAN,11, Font.NORMAL);
    private static Font shipToFont = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL);
    private static Font shipFromFont = new Font(Font.FontFamily.TIMES_ROMAN, 8, Font.NORMAL);

    enum LABEL_TYPE {
        DOMESTIC,
        INTERNATIONAL,
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

    private static String getLabelType(LABEL_TYPE labelType, boolean isAbbreviation) {
        if (isAbbreviation) {
            return labelType == LABEL_TYPE.DOMESTIC ? "DOM" : "INTL";
        } else {
            return labelType == LABEL_TYPE.DOMESTIC ? "DOMESTIC" : "INTERNATIONAL";
        }
    }

    private static void createDomestic(Label label, Document document, PdfWriter pdfWriter,
                                       PdfContentByte pdfContentByte) throws Exception {
        //Initialize values
        Chunk chunk = new Chunk(new VerticalPositionMark());
        PdfPTable table = new PdfPTable(1);
        Phrase phrase = new Phrase();
        Paragraph paragraph = new Paragraph();
        PdfPCell cell = new PdfPCell();

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
        phrase.add("36B (00)"+"\n");

        //Combine and add to pdf
        cell = new PdfPCell(phrase);
        cell.setBorderColorBottom(BaseColor.WHITE);
        cell.setBorderColorTop(BaseColor.WHITE);
        table.addCell(cell);
        document.add(table);

        table = new PdfPTable(1);
        cell = new PdfPCell(new Phrase(""));
        cell.setBorderColorBottom(BaseColor.WHITE);
        cell.setBorderColorTop(BaseColor.WHITE);
        table.addCell(cell);
        document.add(table);
        cell = new PdfPCell();

        //Reset
        table = new PdfPTable(1);
        phrase = new Phrase();
        paragraph = new Paragraph();

        //Add routing barcode

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
        barcode.setCodeType(Barcode128.CODE128);
        barcode.setCode(label.getRoutingCode());
        Image image = barcode.createImageWithBarcode(pdfContentByte, null, null);
        table.addCell(image);
        document.add(table);

        //Reset
        table = new PdfPTable(2);
        phrase = new Phrase();
        paragraph = new Paragraph();

        //Add consignee ref
        phrase.setFont(routingFont);
        phrase.add("Consignee Ref: ");
        if(label.getCustomerReference()!=null) {
            phrase.add(label.getCustomerReference());
        }

        document.add(createRow(phrase));

        //Reset
        table = new PdfPTable(1);
        phrase = new Phrase();
        paragraph = new Paragraph();

        //Add consignor ref
        phrase.setFont(routingFont);
        phrase.add("Consignor Ref: ");
        if(label.getShipperWarehouseCode()!=null) {
            phrase.add(label.getShipperWarehouseCode());
        }
        document.add(createRow(phrase));

        //Reset
        table = new PdfPTable(3);
        phrase = new Phrase();
        paragraph = new Paragraph();

        //Add carrier logo and label type
        phrase.setFont(headerFont);
        phrase.add(label.getSelectedCourier().toUpperCase());
        cell = new PdfPCell(phrase);
        cell.setBorder(Rectangle.LEFT);
        phrase = new Phrase();
        table.addCell(cell);

        cell = new PdfPCell(phrase);
        cell.setBorder(Rectangle.BOTTOM);
        table.addCell(cell);

        phrase.setFont(headerFontInverted);
        phrase.add(getLabelType(LABEL_TYPE.DOMESTIC,true));
        cell = new PdfPCell(phrase);
        phrase = new Phrase();
        cell.setBackgroundColor(BaseColor.BLACK);
        table.addCell(cell);
        cell.setBackgroundColor(BaseColor.WHITE);
        document.add(table);

        //Reset
        table = new PdfPTable(3);
        phrase = new Phrase();
        paragraph = new Paragraph();
        cell = new PdfPCell();

        //TODO: add shipment details section
        //Column
            //Row Depot: {DEPOT NAME}
            //Row {COMPANY NAME, ADDRESS LINE 1, ADDRESS LINE 2}
        phrase.setFont(shipToFont);
        phrase.add("Depot:"+"\n");
        phrase.setFont(routingFont);
        //TODO: currently hardcoded as not provided in json
        phrase.add("06_PRST-G159");
        cell = new PdfPCell(phrase);
        table.addCell(cell);

        phrase = new Phrase();
        phrase.setFont(shipToFont);
        phrase.add(
                "TO:\n"
                +label.getToAddress().getCompany()+"\n"
                +label.getToAddress().getStreetOne()+"\n"
                +label.getToAddress().getStreetTwo()
        );
        cell = new PdfPCell(phrase);
        cell.setBorder(Rectangle.NO_BORDER);
        table.addCell(cell);
        cell = new PdfPCell();
        cell.setBorder(Rectangle.RIGHT);
        table.addCell(cell);

        //Column
            //Row Date: {DATE}
            //Row {TOWN, COUNTY, ZIP, ISO}
        phrase = new Phrase();
        phrase.setFont(shipToFont);
        phrase.add("Date:"+"\n");
        phrase.setFont(routingFont);
        String date = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
        phrase.add(date);
        cell = new PdfPCell(phrase);
        table.addCell(cell);

        phrase = new Phrase();
        phrase.setFont(routingFont);
        phrase.add(
                label.getToAddress().getCity()+"\n"
                +label.getToAddress().getState()+"\n"
        );
        phrase.setFont(informationFont);
        phrase.add(label.getToAddress().getZip());
        cell = new PdfPCell(phrase);
        cell.setBorder(Rectangle.NO_BORDER);
        table.addCell(cell);

        phrase = new Phrase();
        phrase.setFont(informationFont);
        phrase.add("\nGB");
        cell = new PdfPCell(phrase);
        cell.setBorder(Rectangle.RIGHT);
        cell.setHorizontalAlignment(Rectangle.ALIGN_RIGHT);
        table.addCell(cell);

        //Column
            //Row Service: {SERVICE}
            //Row {labelType}
        phrase = new Phrase();
        phrase.setFont(shipToFont);
        phrase.add("Service:"+"\n");
        phrase.setFont(headerFont);
        phrase.add(label.getServiceCode());
        cell = new PdfPCell(phrase);
        table.addCell(cell);


        phrase = new Phrase();
        phrase.setFont(routingFontInverted);
        phrase.add("\n    "+getLabelType(LABEL_TYPE.DOMESTIC,false));
        cell = new PdfPCell(phrase);
        cell.setBackgroundColor(BaseColor.BLACK);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase(" "));
        cell.setBackgroundColor(BaseColor.BLACK);
        table.addCell(cell);
        cell.setBackgroundColor(BaseColor.WHITE);
        document.add(table);



        //Reset
        table = new PdfPTable(1);
        phrase = new Phrase();
        paragraph = new Paragraph();

        //Add customer name
        phrase.setFont(licenceFont);
        phrase.add("Customer Name: ");

        phrase.setFont(routingFont);
        phrase.add(label.getToAddress().getFirstName().toUpperCase()
                +" "
                +label.getToAddress().getLastName().toUpperCase()
        );

        document.add(createRow(phrase));

        //Reset
        table = new PdfPTable(1);
        phrase = new Phrase();
        paragraph = new Paragraph();

        //Add extra details
        phrase.setFont(routingFontInverted);
        phrase.add("    "+getLabelType(LABEL_TYPE.DOMESTIC, false));
        cell = new PdfPCell(phrase);
        cell.setBackgroundColor(BaseColor.BLACK);
        table.addCell(cell);
        cell.setBackgroundColor(BaseColor.WHITE);
        document.add(table);

        //Reset
        table = new PdfPTable(1);
        phrase = new Phrase();
        paragraph = new Paragraph();

        //Add license plate barcode
        //TODO: currently hardcoded as data is not provided within the test json
        barcode = new Barcode128();
        barcode.setCodeType(Barcode128.CODE128);
        barcode.setCode("(J)JD00 022 340 0100 0001");
        image = barcode.createImageWithBarcode(pdfContentByte, null, null);
        table.addCell(image);
        document.add(table);
    }

    private static void createInternational(Label label, Document document, PdfWriter pdfWriter,
                                            PdfContentByte pdfContentByte) throws Exception {
        //TODO
        createDomestic(label, document, pdfWriter, pdfContentByte);
    }

    private static void createCollect(Label label, Document document, PdfWriter pdfWriter,
                                      PdfContentByte pdfContentByte) throws Exception {
        //TODO
        createDomestic(label, document, pdfWriter, pdfContentByte);
    }

    private static void createPDF(Label label, String outputFile, LABEL_TYPE labelType) throws Exception {
        Document document = new Document(PageSize.A4, 10, 10, 10, 10);
        PdfWriter pdfWriter= PdfWriter.getInstance(document, new FileOutputStream(outputFile));
        document.open();
        PdfContentByte pdfContentByte = pdfWriter.getDirectContent();
        switch (labelType) {
            case DOMESTIC -> createDomestic(label, document, pdfWriter, pdfContentByte);
            case INTERNATIONAL -> createInternational(label, document, pdfWriter, pdfContentByte);
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
