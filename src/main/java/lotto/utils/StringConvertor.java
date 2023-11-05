package lotto.utils;

import java.util.Arrays;
import java.util.List;

public class StringConvertor {
    public static int stringToInt(String input) {
        return Integer.parseInt(input);
    }

    public static List<Integer> stringToList(String input) {
        return Arrays.stream(input.split(",")).map(Integer::parseInt).toList();
    }

}
