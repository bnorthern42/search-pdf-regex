package net.northern;

import net.northern.Parser.Find;

import java.io.IOException;

public class ParsePDF {

    public static void main(String[] args) throws IOException {
        Find find = new Find();
        System.out.println(find.ReturnOccurences(args[0], args[1] ));
    }

}
