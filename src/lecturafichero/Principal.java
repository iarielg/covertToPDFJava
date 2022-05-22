package lecturafichero;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.poi.xwpf.converter.core.XWPFConverterException;
import org.apache.poi.xwpf.converter.pdf.PdfConverter;
import org.apache.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

/*
 * @Author Jose Ariel Gonzalez De La Cruz
 * 
 * 
 * 
 */
 
public class Principal {
 
    public static void main(String[] args) {
 
        File archivoWord = new File("C:\\Users\\ariel\\Desktop\\CARMEN\\QUINTO SEMESTRE\\capacitación\\plan de vida.docx");
        File archivoPDF = new File("C:\\Users\\ariel\\Desktop\\CARMEN\\QUINTO SEMESTRE\\capacitación\\Formato para un programa general.pdf");
 

        XWPFDocument document = leerDocx(archivoWord);
 
        if (convertirPDF(archivoPDF, document)) {
            System.out.println("El fichero de Word se ha convertido a PDF con éxito.");
        } else {
            System.out.println("ERROR: El fichero de Word NO se ha convertido a PDF.");
        }
 
    }
 
    public static XWPFDocument leerDocx(File archivoWord) {
 
        XWPFDocument documentoWord = null;
 
        try {
            InputStream texto = new FileInputStream(archivoWord);
 
            documentoWord = new XWPFDocument(texto);
 
        } catch (IOException e) {
            System.out.println("Error leyendo el fichero de Word");
            e.printStackTrace();
        }
        return documentoWord;
 
    }
 
    public static boolean convertirPDF(File archivoPDF, XWPFDocument documentWord) {
 
        boolean exito;
 
        try {
            OutputStream out = new FileOutputStream(archivoPDF);
            PdfOptions options = PdfOptions.create();
            PdfConverter.getInstance().convert(documentWord, out, options);
            exito = true;
 
        } catch (XWPFConverterException e) {
            exito = false;
            System.out.println("Error en la conversión");
            e.printStackTrace();
        } catch (IOException e) {
            exito = false;
            System.out.println("Error creando el fichero PDF");
            e.printStackTrace();
        }
 
        return exito;
 
    }//main
 
}//class