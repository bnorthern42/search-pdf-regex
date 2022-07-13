package net.northern.Parser;

import org.apache.commons.io.FilenameUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class PDF2Text {

   private final static String  SupportedExtension = "pdf";


    public static   String Convert(String FilePath){
        String ext =FilenameUtils.getExtension(FilePath);
        if(!Objects.equals(ext, SupportedExtension)) {
            throw new RuntimeException(" Wrong File type, given:  " + ext + " \n\tHowever,  " + SupportedExtension  + "  was Expected!");
        }


        File file = new File(FilePath);
        try {
            PDDocument doc =  PDDocument.load(file);
            return new PDFTextStripper().getText(doc);
        } catch (IOException e) {
            System.out.println("Error in Trying to convert PDF: " + e.getMessage());
            return  null;
        }


    }
    private static String getExtension(String filename) {
        return FilenameUtils.getExtension(filename);
    }

    private static  String getFileName(String filepath){
        return FilenameUtils.getName(filepath); // for ex. C:\blah\blah\Docs\MyFile.pdf ==> MyFile.pdf
    }

}
