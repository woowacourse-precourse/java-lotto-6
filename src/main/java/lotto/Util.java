package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.Constant.NUMBER_DELIMITER;

public class Util {
    public static void println(String content) {
        System.out.println(content);
    }

    public static void println(List<Integer> list) {
        System.out.println(list);
    }

    public static int convertStringToInt(String input) {
        return Integer.parseInt(input);
    }

    public static List<Integer> convertStringToIntegerList(String input) {
        return Arrays.stream(convertStringToSplitArray(input))
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .collect(Collectors.toList());
    }

    public static String[] convertStringToSplitArray(String input) {
        return input.split(NUMBER_DELIMITER);
    }
}
