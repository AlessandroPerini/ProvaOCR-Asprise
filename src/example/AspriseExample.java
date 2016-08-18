package provaocr.example;

import com.asprise.ocr.Ocr;
import java.io.File;
import utils.Supporto;
/**
 *
 * @author aless
 */
public class AspriseExample {
    
    public static void main(String[] args) {
        
        Supporto prova = new Supporto("Prova");
        prova.timerStart();
        int i;
        String estensione[] = {"","png","jpg","tif","tif","tif","tif","png",
                                  "jpg","jpg","png","jpg","jpg","jpg","tif",
                                  "tif","png","gif","gif","png","png"};
        
        Ocr.setUp(); // one time setup
        Ocr ocr = new Ocr(); // create a new OCR engine
        ocr.startEngine("eng", Ocr.SPEED_FAST); 
        
        Supporto supporto = new Supporto("Asprise");
        
        for (i = 1; i < 21; i++) {
            
            String file = "C:\\Users\\aless\\Desktop\\scanned_doc\\dir"+i+"\\img"+i+"."+estensione[i];
            
            supporto.timerStart();
            String result = ocr.recognize(new File[] {new File(file)}, Ocr.RECOGNIZE_TYPE_TEXT, Ocr.OUTPUT_FORMAT_PLAINTEXT);
            supporto.timerStop();
                        
            supporto.fileOut(file, result);
            
            System.out.println(file);
        }
        
        ocr.stopEngine();
        System.out.println("\nTempo totale: "+prova.timerStop());
    }
    
}
