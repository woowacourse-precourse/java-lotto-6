package lotto.validator;

import java.util.Arrays;

import static lotto.constants.ErrorMessageConstants.*;
import static lotto.constants.LottoConstants.*;

public class Validator {

    public static void purchaseAmount(String inputPurchaseAmount) {
        int purchaseAmount = parseValidInteger(inputPurchaseAmount);

        if (isLessThanLottoPrice(purchaseAmount)) {
            throw new IllegalArgumentException(MINIMUM_PURCHASE_AMOUNT);
        }
        if (isNotDivisionForPrice(purchaseAmount)) {
            throw new IllegalArgumentException(NOT_DIVISION_BY_LOTTO_PRICE);
        }
    }

    public static void winningNumbers(String[] inputWinningNumbers) {
        if (isInvalidWinningNumbersSize(inputWinningNumbers)) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBERS_SIZE);
        }

        if (isNotIntegerWinningNumbers(inputWinningNumbers)) {
            throw new IllegalArgumentException(NOT_INTEGER_NUMBER);
        }

        if (isNumberOutOfRange(inputWinningNumbers)) {
            throw new IllegalArgumentException(NUMBER_OUT_OF_RANGE);
        }

        if (isDuplicateWinningNumbers(inputWinningNumbers)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBERS);
        }
    }

    public static void bonusNumber(String inputBonusNumber, String[] winningNumbers) {
        int bonusNumber = parseValidInteger(inputBonusNumber);

        if (isInvalidRangeNumber(bonusNumber)) {
            throw new IllegalArgumentException(NUMBER_OUT_OF_RANGE);
        }

        if (isBonusNumberIncluded(inputBonusNumber, winningNumbers)) {
            throw new IllegalArgumentException(BONUS_NUMBER_INCLUDED);
        }
    }

    private static boolean isNotInteger(String input) {
        try {
            Integer.parseInt(input);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private static int parseValidInteger(String input) {
        if (isNotInteger(input)) {
            throw new IllegalArgumentException(NOT_INTEGER_NUMBER);
        }

        return Integer.parseInt(input);
    }

    private static boolean isLessThanLottoPrice(int purchaseAmount) {
        return purchaseAmount < LOTTO_PRICE;
    }

    private static boolean isNotDivisionForPrice(int purchaseAmount) {
        return purchaseAmount % LOTTO_PRICE != ZERO;
    }

    private static boolean isInvalidWinningNumbersSize(String[] winningNumbers) {
        return winningNumbers.length != LOTTO_NUMBER_COUNT;
    }

    private static boolean isNotIntegerWinningNumbers(String[] winningNumbers) {
        return Arrays.stream(winningNumbers).anyMatch(Validator::isNotInteger);
    }

    private static boolean isNumberOutOfRange(String[] winningNumbers) {
        return Arrays.stream(winningNumbers)
                .mapToInt(Integer::parseInt)
                .anyMatch(number -> !(LOTTO_NUMBER_MIN <= number && number <= LOTTO_NUMBER_MAX));
    }

    private static boolean isDuplicateWinningNumbers(String[] winningNumbers) {
        return Arrays.stream(winningNumbers).distinct().count() != winningNumbers.length;
    }

    private static boolean isInvalidRangeNumber(int inputBonusNumber) {
        return !(LOTTO_NUMBER_MIN <= inputBonusNumber && inputBonusNumber <= LOTTO_NUMBER_MAX);
    }

    private static boolean isBonusNumberIncluded(String inputBonusNumber, String[] winningNumbers) {
        return Arrays.stream(winningNumbers).anyMatch(number -> number.equals(inputBonusNumber));
    }
}
