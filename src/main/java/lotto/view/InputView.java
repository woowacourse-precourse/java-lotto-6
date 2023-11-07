package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.ErrorMessage;
import lotto.exception.LottoGameException;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    public static int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();

        validatePurchaseAmountInput(input);

        return Integer.parseInt(input);
    }

    public static List<Integer> getWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String input = Console.readLine();

        validateWinningNumbersInput(removeSpaces(input));

        return toIntegers(split(removeSpaces(input)));
    }

    public static Integer getBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String input = Console.readLine();

        validateBonusNumberInput(input);

        return toInteger(input);
    }

    private static void validatePurchaseAmountInput(String input) {
        if (isNotPositiveInteger(input)) {
            throw new LottoGameException(ErrorMessage.NON_POSITIVE_INTEGER);
        }
    }

    private static void validateWinningNumbersInput(String input) {
        if (endsWithComma(input)) {
            throw new LottoGameException(ErrorMessage.LAST_COMMA);
        }
        if (hasNotPositiveInteger(split(input))) {
            throw new LottoGameException(ErrorMessage.NON_POSITIVE_INTEGER);
        }
        if (isNotSixIntegers(split(input))) {
            throw new LottoGameException(ErrorMessage.INVALID_INTEGER_COUNT);
        }
    }

    private static void validateBonusNumberInput(String input) {
        if (isNotPositiveInteger(input)) {
            throw new LottoGameException(ErrorMessage.NON_POSITIVE_INTEGER);
        }
    }

    private static int toInteger(String input) {
        return Integer.parseInt(input);
    }

    private static List<Integer> toIntegers(String[] values) {
        List<Integer> integers = new ArrayList<>();
        for (String value : values) {
            integers.add(toInteger(value));
        }
        return integers;
    }

    private static boolean isNotPositiveInteger(String input) {
        try {
            return toInteger(input) <= 0;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private static String[] split(String input) {
        return input.split(",");
    }

    private static boolean hasNotPositiveInteger(String[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            String numberStr = numbers[i].trim();

            if (isNotPositiveInteger(numberStr)) {
                return true;
            }
        }
        return false;
    }

    private static boolean endsWithComma(String input) {
        return input.endsWith(",");
    }

    private static boolean isNotSixIntegers(String[] numbers) {
        return numbers.length != 6;
    }

    private static String removeSpaces(String input) {
        return input.replaceAll(" ", "");
    }
}
