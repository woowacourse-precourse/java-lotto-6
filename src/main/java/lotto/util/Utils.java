package lotto.util;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    private static final String SPACE = " ";
    private static final String NONE = "";
    private static final String DELIMITER = ",";

    public static String removeSpace(String string) {
        return string.replace(SPACE, NONE);
    }

    public static List<Integer> convertStringToInt(String userInput) {
        String[] splitString = userInput.split(DELIMITER);
        List<Integer> stringToInt = new ArrayList<>();
        for (String string : splitString) {
            stringToInt.add(Integer.parseInt(string));
        }
        return stringToInt;
    }
}
