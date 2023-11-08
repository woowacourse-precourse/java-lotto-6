package lotto;

import java.util.Arrays;
import java.util.List;

public class InputProcessor {
    public static int parsePrice(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(CustomErrorMessage.NUMBER_FORMAT);
        }
    }

    public static List<Integer> getWinningNumbers(String input) {
        try {
            return Arrays.stream(input.split(","))
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new NumberFormatException(CustomErrorMessage.NUMBER_FORMAT);
        }
    }

    public static Integer getBonusNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(CustomErrorMessage.NUMBER_FORMAT);
        }
    }
}
