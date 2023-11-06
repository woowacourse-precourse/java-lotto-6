package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class InputView {
    private static final String PURCHASE_COST_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String NULL_OR_EMPTY_ERROR_MESSAGE = "[ERROR] 공백이나 빈 값은 입력이 불가능합니다.";
    private static final String NOT_ALLOWED_CHARACTER_ERROR_MESSAGE = "[ERROR] 숫자만 입력이 가능합니다.";
    private static final String NAN_ERROR_MESSAGE = "[ERROR] 숫자가 아닌 값은 입력이 불가능합니다.";
    private static final Pattern WINNING_NUMBERS = Pattern.compile("^\\d+(,\\d+)*$");
    private static final String SPACE = " ";
    private static final String DELIMITER = ",";

    public static String getLine() {
        String input = read().trim();
        validateNullOrEmpty(input);

        return input;
    }

    public static long getPurchaseCost() {
        System.out.println(PURCHASE_COST_MESSAGE);
        String input = getLine();

        return toLong(input);
    }

    public static List<Integer> getWinningNumbers() {
        System.out.println(WINNING_NUMBER_MESSAGE);
        String input = getLine();
        validateCharacter(input);

        return toInts(split(input));
    }

    private static String read() {
        return Console.readLine();
    }

    private static void validateNullOrEmpty(String input) {
        if (input == null || input.isBlank() || input.contains(SPACE)) {
            throw new IllegalArgumentException(NULL_OR_EMPTY_ERROR_MESSAGE);
        }
    }

    private static void validateCharacter(String input) {
        if (!WINNING_NUMBERS.matcher(input).matches()) {
            throw new IllegalArgumentException(NOT_ALLOWED_CHARACTER_ERROR_MESSAGE);
        }
    }

    private static String[] split(String input) {
        return input.split(DELIMITER);
    }

    private static List<Integer> toInts(String[] inputs) {
        return Arrays.stream(inputs)
                .mapToInt(Integer::parseInt)
                .boxed()
                .toList();
    }

    private static long toLong(String amount) {
        long result;
        try {
            result = Long.parseLong(amount);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(NAN_ERROR_MESSAGE);
        }

        return result;
    }
}
