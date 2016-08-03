/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package provaocr.example;

import com.asprise.ocr.Ocr;
import java.io.File;
/**
 *
 * @author aless
 */
public class AspriseExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Ocr.setUp(); // one time setup
        Ocr ocr = new Ocr(); // create a new OCR engine
        ocr.startEngine("eng", Ocr.SPEED_FASTEST); // English
        System.out.println("Converting...\n");
        String s = ocr.recognize(new File[] {new File("src/file/test.pdf")}, Ocr.RECOGNIZE_TYPE_ALL, Ocr.OUTPUT_FORMAT_PLAINTEXT);
        System.out.println("Result: \n\n" + s);
        // ocr more images here ...
        ocr.stopEngine();

    }
    
}
