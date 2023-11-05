package lotto.util;

import java.util.Arrays;
import java.util.List;

public class ConvertStr {

    public static List<String> splitByComma(String input) {
        return Arrays.asList(input.split(","));
    }

    public static List<Integer> strsToIntegers(List<String> list) {
        return list.stream().map(Integer::parseInt).toList();
    }
}