package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.ValidationUtils;

import java.util.Arrays;
import java.util.List;

import static lotto.constants.LottoConstants.LOTTO_NUMBERS_DELIMITER;
import static lotto.exception.ErrorMessage.WINNING_NUMBERS_NOT_NUMERIC;
import static lotto.exception.ErrorMessage.WINNING_NUMBERS_STARTS_OR_ENDS_WITH_DELIMITER;

public class InputView {
    public long readPurchaseAmount() {
        String purchaseAmountInput = Console.readLine();
        return ValidationUtils.validateLong(purchaseAmountInput);
    }

    public int readBonusNumber() {
        String bonusNumberInput = Console.readLine();
        return ValidationUtils.validateInteger(bonusNumberInput);
    }

    public List<Integer> readWinningNumbers() {
        String winningNumbersInput = Console.readLine();
        return parseWinningNumbersInput(winningNumbersInput);
    }

    private static List<Integer> parseWinningNumbersInput(String input) {
        validateStartsOrEndsWithDelimiter(input);
        return Arrays.stream(input.split(LOTTO_NUMBERS_DELIMITER))
                .map(InputView::safeParseInt)
                .toList();
    }

    private static void validateStartsOrEndsWithDelimiter(String input) {
        if (input.startsWith(LOTTO_NUMBERS_DELIMITER) || input.endsWith(LOTTO_NUMBERS_DELIMITER)) {
            throw new IllegalArgumentException(WINNING_NUMBERS_STARTS_OR_ENDS_WITH_DELIMITER.getMessage());
        }
    }

    private static Integer safeParseInt(String input) {
        try {
            int number = Integer.parseInt(input);
            ValidationUtils.validateRange(number);
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(WINNING_NUMBERS_NOT_NUMERIC.getMessage());
        }
    }
}
