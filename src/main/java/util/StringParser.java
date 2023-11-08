package util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.PatternSyntaxException;

public class StringParser {

    public static Integer toInteger(String value) throws IllegalArgumentException {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] " + e);
        }
    }

}
