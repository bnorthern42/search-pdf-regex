package net.northern.Parser;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class FindTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void match() {
        String input = "bbbbbbbbbabbbbbbbbbbbbbbbbbbb";
        String searchPattern = "a";
        String opt = "bool";

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
        Integer retlength= ret.length();
        if(opt.contains("bool") && ret.length() > 0) {
            assertNotEquals(retlength, 0);
        }
        else if(opt.contains("bool") && ret.length() == 0) {
            assertEquals(retlength,0);
        }
        else {
            assertNull(ret);
        }
    }
}