package net.northern.Parser;

import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class PDF2Text {

    public PDF2Text() {
    }

    public static   String Convert(String FilePath) throws IOException {
        File file = new File(FilePath);
        PDDocument doc = PDDocument.load(file);
        return new PDFTextStripper().getText(doc);

    }

}
