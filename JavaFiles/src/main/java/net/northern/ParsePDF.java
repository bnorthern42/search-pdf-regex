package net.northern;

import net.northern.Parser.Find;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.logging.Level;

public class ParsePDF {
    private static final Logger LOG = LogManager.getLogger(ParsePDF.class);
    static String Options = "";
    public static void main(String[] args) {
        if (args.length == 0)
        {

            System.out.println("Invalid number of arguments\nFor Help please run --help or -h");
        }else{
            //remove font warnings


            // Argument Parser
            String fileName;
            String SearchTerm;

            for(String arg : args){
                if (arg.equals("--help") || arg.equals("-h") || arg.equals("man")) {
                    LOG.info(manpage);
                    System.exit(0);
                }

                if(arg.equals("--L1"))
                {
                    java.util.logging.Logger.getLogger("org.apache.pdfbox")
                            .setLevel(Level.ALL);

                }
                if(arg.equals("--L2"))
                {
                    java.util.logging.Logger.getLogger("org.apache.pdfbox")
                            .setLevel(Level.INFO);


                }
                if(arg.equals("--L3"))
                {
                    java.util.logging.Logger.getLogger("org.apache.pdfbox")
                            .setLevel(Level.WARNING);
                }
                if(arg.equals("--L4"))
                {
                    java.util.logging.Logger.getLogger("org.apache.pdfbox")
                            .setLevel(Level.SEVERE);

                }
                if(!arg.equals("--L1") && !arg.equals("--L2") && !arg.equals("--L3") && !arg.equals("--L4"))
                {
                    java.util.logging.Logger.getLogger("org.apache.pdfbox")
                            .setLevel(Level.OFF);

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
                LOG.warn("Filetype probably not supported **** Run --help for help");

            }
            SearchTerm=args[1];
            if(SearchTerm.length()== 0){
                LOG.warn("Search term empty **** Run --help for help");
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
            "ADDITIONAL OPS\n"+
            "\t --L<log_level>\t Outputs specific PDFbox log level, 1: debug, 2: info, 3: warning, 4: severe, Default: OFF\n"+
            " OPERANDS\n" +
            "\t inputFile\t A pdf file (REQUIRED)\n"+
            " \t searchTerm\t Either a simple string or REGEX (REQUIRED)\n"+
            "NOTES\n"+
            "\t While not applicable to the main library, the jar can be ran alone\n"+
            " DEPENDENCIES\n"+
            "\t PDFbox - Apache\n"+
            " AUTHORS\n"+
            " \t B. Northern\n"+
        " 'now with Java 8 :P'";
}
