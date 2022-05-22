package lecturafichero;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.io.File;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;
import lecturafichero.Principal; 
class PrincipalTest {
     
    XWPFDocument documentoWord;
    File archivoWord = new File("C:\\Users\\ariel\\Desktop\\CARMEN\\QUINTO SEMESTRE\\capacitación\\plan de vida.docx");
    File archivoPDF = new File("C:\\Users\\ariel\\Desktop\\CARMEN\\QUINTO SEMESTRE\\capacitación\\Formato para un programa general.pdf");
 
    @Test
    void leerDocxTest() {
        documentoWord = Principal.leerDocx(archivoWord);
        assertNotNull(documentoWord);
    }
     
    @Test
    void convertirPDFTest() {
        leerDocxTest();
        boolean resultado = Principal.convertirPDF(archivoPDF, documentoWord);
        assertTrue(resultado);
    }
 
}