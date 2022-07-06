package net.northern;

import net.northern.Parser.Find;

import java.io.IOException;

public class ParsePDF {
    static String Options;
    public static void main(String[] args) throws IOException {
        if (args.length == 0)
        {
            System.out.println("Invalid number of arguments\nFor Help please run --help or -h");
        }else{
            // Argument Parser
            String fileName;
            String SearchTerm;

            for(String arg : args){
                if (arg.equals("--help") || arg.equals("-h") || arg.equals("man")) {
                    System.out.println(ParsePDF.manpage);
                    System.exit(0);
                }
                if (arg.equals("--csv"))
                    Options="CSV";
                if(arg.equals("--json"))
                    Options="JSON";
                if(arg.equals("--bool"))
                    Options="BOOL";

            }
            fileName=args[0];
            if(fileName.length()== 0){
                System.out.println("Filetype probably not supported\n Run --help for help");
            }
            SearchTerm=args[1];
            if(SearchTerm.length()== 0){
                System.out.println("Search term empty\n Run --help for help");
            }

            Find find = new Find();


            System.out.println(find.ReturnOccurences(fileName, SearchTerm, Options));

        }

    }
static String manpage= ""+
         "PARSE-PDF-REGEX(1)\n"+
        "NAME\n"+
            " \t parse-pdf-regex - a simple search for pdfs\n"+
            "   SYNOPSIS\n"+
            "  \t java -jar parsePDF.jar inputFile | searchString [options]DESCRIPTION"+
            "\tSearches over a PDF document and outputs one long string or outputs results in various formats\n"+
            " OPTIONS\n"+
            "  \t  --json\tOutputs result in JSON format (not yet implemented)\n"+
            "\t --csv\tOutputs result in CSV format\n"+
            " \t --bool\tOutputs true or false if term exists in PDF\n"+
            " OPERANDS\n" +
            "\t inputFile\t A pdf file (REQUIRED)\n"+
            " \t searchTerm\t Either a simple string or REGEX (REQUIRED)\n"+
            "NOTES\n"+
            "\t While not applicable to the main library, the jar can be ran alone\n"+
            " DEPENDENCIES\n"+
            "\t PDFbox - Apache\n"+
            " AUTHORS\n"+
            " \t B. Northern\n"+
        " 'now with Java 11 :P'";
}
