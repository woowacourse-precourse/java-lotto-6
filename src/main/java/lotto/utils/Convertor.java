package lotto.utils;

import java.util.Arrays;
import java.util.List;

public class Convertor {
    private final static String SEPARATOR = ",";
    public static List<String> convertStringToList(String input) {
        return Arrays.stream(input.split(SEPARATOR)).toList();
    }
}
