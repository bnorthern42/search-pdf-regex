package net.northern.Parser;

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
 * TODO: JSON formatting
 **/
    public  String ReturnOccurences(String filePath, String regex, String Options) throws IOException {
        String opt = null;
        if(Options.contains("CSV"))
            opt=",";
        else if(Options.contains("BOOL"))
            opt="bool";
        else
            opt="";
        return match(PDF2Text.Convert(filePath), regex, opt);
    }

    /** Searches string with regex
     * @param input  String input
     * @param  searchPattern pattern to search with
     * @return  String value of all matches
     * */
    private  String match(String input, String searchPattern,String opt){
        Pattern pattern = Pattern.compile(searchPattern);
        Matcher matcher = pattern.matcher(input);
        String ret = "";
        while(matcher.find()){
            if(opt.contains(",")) {
                ret+=(matcher.group()+ ",");
            } else {
                ret+=matcher.group();
            }
        }
        if(opt.contains("bool") && ret.length() > 0)
            return "True";
        else if(opt.contains("bool") && ret.length() == 0)
            return "False";
        else
        return  ret;
    }
}