package lotto.view;

import static lotto.util.ErrorMessage.INPUT_HAS_NOT_COMMA_MESSAGE;
import static lotto.util.ErrorMessage.INPUT_NUMBERS_SIZE_IS_NOT_CORRECT_MESSAGE;
import static lotto.util.ErrorMessage.PRICE_NOT_INTEGER_ERROR_MESSAGE;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    public static final String COMMA = ",";

    public static int getPurchaseLottoPrice() {
        String cost = Console.readLine();
        return convertToInt(cost);
    }

    public static List<Integer> getUserLottoNumber() {
        String input = Console.readLine();
        String[] numbers = getSplit(input);
        if (numbers.length != 6) {
            throw new IllegalArgumentException(
                    INPUT_NUMBERS_SIZE_IS_NOT_CORRECT_MESSAGE.getMessage());
        }
        return mapToInteger(numbers);
    }

    public static int getUserBonusNumber() {
        String input = Console.readLine();
        return convertToInt(input);
    }

    private static int convertToInt(String cost) {
        if (!cost.matches("\\d+")) {
            throw new IllegalArgumentException(PRICE_NOT_INTEGER_ERROR_MESSAGE.getMessage());
        }
        return Integer.parseInt(cost);
    }

    private static String[] getSplit(String input) {
        if (hasNotComma(input)) {
            throw new IllegalArgumentException(INPUT_HAS_NOT_COMMA_MESSAGE.getMessage());
        }
        return input.split(COMMA);
    }

    private static boolean hasNotComma(String input) {
        return !input.contains(COMMA);
    }

    private static List<Integer> mapToInteger(String[] numbers) {
        return Arrays.stream(numbers)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
