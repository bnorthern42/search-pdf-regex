package net.northern.Parser;

import net.northern.ParsePDF;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Find {

    public Find() {
    }
/** searches pdf with regex
 * @param filePath  path of file input
 * @param regex  pattern to search for
 * @return  String of all occurrences
 **/
    public  String ReturnOccurences(String filePath, String regex) throws IOException {
        return match(PDF2Text.Convert(filePath), regex);
    }

    /** Searches string with regex
     * @param input  String input
     * @param  searchPattern pattern to search with
     * @return  String value of all matches
     * */
    private  String match(String input, String searchPattern){
        Pattern pattern = Pattern.compile(searchPattern);
        Matcher matcher = pattern.matcher(input);
        String ret = "";
        while(matcher.find()){
            ret+=matcher.group();
        }
        return  ret;
    }
}