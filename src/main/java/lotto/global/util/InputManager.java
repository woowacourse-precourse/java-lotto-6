package lotto.global.util;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.global.enums.ErrorType.DIVIDED_INTO_1_000;
import static lotto.global.enums.ErrorType.DUPLICATE_BONUS_NUMBER_IN_LOTTO;
import static lotto.global.enums.ErrorType.EMPTY_INPUT_VALUE;
import static lotto.global.enums.ErrorType.INVALID_NUMBER_FORMAT;
import static lotto.global.enums.ErrorType.INVALID_RANGE_OF_LOTTO;
import static lotto.global.util.OutputManager.inputBonusNumberCommand;
import static lotto.global.util.OutputManager.inputPaymentCommand;
import static lotto.global.util.OutputManager.inputWinningNumberCommand;
import static lotto.global.util.OutputManager.printError;

import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;

public final class InputManager {

    public static int inputPayment() {

        while (true) {
            try {
                inputPaymentCommand();
                String payment = readLine().trim();
                return validatePayment(payment);
            } catch (IllegalArgumentException e) {
                printError(e);
            }
        }
    }

    public static int validatePayment(String input) {
        checkEmptyValue(input);

        int result = checkValidNumFormat(input);
        if (result % 1000 != 0) {
            throw new IllegalArgumentException(DIVIDED_INTO_1_000.getMessage());
        }

        return result;
    }

    public static Lotto inputWinningNumber() {

        while (true) {
            try {
                inputWinningNumberCommand();
                String winningNum = readLine();
                return new Lotto(validateWinningNumber(winningNum));
            } catch (IllegalArgumentException e) {
                printError(e);
            }
        }
    }

    private static List<Integer> validateWinningNumber(String input) {
        checkEmptyValue(input);

        String[] splitNums = input.trim().split(",\\s*");

        return Arrays.stream(splitNums)
                .map(splitNum -> {
                        int result = checkValidNumFormat(splitNum);
                        checkValidRangeOfNumber(result);
                        return result;
                    })
                .toList();
    }

    public static int inputBonusNumber(List<Integer> winNum) {

        while (true) {
            try {
                inputBonusNumberCommand();
                String bonusNum = readLine().trim();
                return validateBonusNumber(bonusNum, winNum);
            } catch (IllegalArgumentException e) {
                printError(e);
            }
        }
    }

    public static int validateBonusNumber(String input, List<Integer> winNum) {
        checkEmptyValue(input);

        int result = checkValidNumFormat(input);
        checkValidRangeOfNumber(result);
        if (winNum.contains(result)) {
            throw new IllegalArgumentException(DUPLICATE_BONUS_NUMBER_IN_LOTTO.getMessage());
        }

        return result;
    }

    private static void checkEmptyValue(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_INPUT_VALUE.getMessage());
        }
    }

    private static int checkValidNumFormat(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_FORMAT.getMessage());
        }
    }

    private static void checkValidRangeOfNumber(int result) {
        if (result < 1 || result > 45) {
            throw new IllegalArgumentException(INVALID_RANGE_OF_LOTTO.getMessage());
        }
    }
}
