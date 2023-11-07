package lotto;

import java.util.List;

import static lotto.ErrorMessage.NOT_INT;

public class Util {
    public static void println(String content) {
        System.out.println(content);
    }

    public static void println(List<Integer> list) {
        System.out.println(list);
    }

    public static int convertStringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(NOT_INT.getMessage());
        }
    }

}
