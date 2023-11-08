package lotto.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lotto.utils.Constants.NOT_INTEGER_ERROR;
import static lotto.utils.Validator.checkInteger;

public class StringUtils {

    public static int stringToInt(String text) {
        checkInteger(text);
        return Integer.parseInt(text);
    }

    public static List<String> splitString(String input) {
        String[] parts = input.split(",");
        return Arrays.asList(parts);
    }

    public static List<Integer> convertToIntegerList(List<String> stringList) {
        List<Integer> integerList = new ArrayList<>();
        for (String str : stringList) {
            try {
                int number = Integer.parseInt(str);
                integerList.add(number);
            } catch (NumberFormatException e) {
                System.out.println(NOT_INTEGER_ERROR);
            }
        }
        return integerList;
    }
}
