package lotto.validator;

import java.util.Arrays;

import static lotto.constants.ErrorMessageConstants.*;
import static lotto.constants.LottoConstants.*;

public class Validator {

    public static void purchaseAmount(String inputPurchaseAmount) {
        if (isNotInteger(inputPurchaseAmount)) {
            throw new IllegalArgumentException(NOT_INTEGER_NUMBER);
        }

        int purchaseAmount = Integer.parseInt(inputPurchaseAmount);

        if (isLessThanLottoPrice(purchaseAmount)) {
            throw new IllegalArgumentException(MINIMUM_PURCHASE_AMOUNT);
        }

        if (isNotDivisionForPrice(purchaseAmount)) {
            throw new IllegalArgumentException(NOT_DIVISION_BY_LOTTO_PRICE);
        }
    }

    public static void inputWinningNumbers(String inputWinningNumbers) {
        String[] winningNumbers = inputWinningNumbers.split(",");

        if (isInvalidWinningNumbersSize(winningNumbers)) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBERS_SIZE);
        }

        if (isNotIntegerWinningNumbers(winningNumbers)) {
            throw new IllegalArgumentException(NOT_INTEGER_NUMBER);
        }

        if (isNumberOutOfRange(winningNumbers)) {
            throw new IllegalArgumentException(NUMBER_OUT_OF_RANGE);
        }

        if (isDuplicateWinningNumbers(winningNumbers)) {
            throw new IllegalArgumentException(DUPLICATE_WINNING_NUMBERS);
        }
    }

    public static void inputBonusNumber(String inputBonusNumber, String[] winningNumbers) {
        if (isNotInteger(inputBonusNumber)) {
            throw new IllegalArgumentException(NOT_INTEGER_NUMBER);
        }

        int bonusNumber = Integer.parseInt(inputBonusNumber);

        if (isInvalidRangeNumber(bonusNumber)) {
            throw new IllegalArgumentException(NUMBER_OUT_OF_RANGE);
        }

        if (isBonusNumberIncluded(inputBonusNumber, winningNumbers)) {
            throw new IllegalArgumentException(BONUS_NUMBER_INCLUDED);
        }
    }

    private static boolean isBonusNumberIncluded(String inputBonusNumber, String[] winningNumbers) {
        return Arrays.stream(winningNumbers).anyMatch(number -> number.equals(inputBonusNumber));
    }

    private static boolean isInvalidRangeNumber(int inputBonusNumber) {
        return !(LOTTO_NUMBER_MIN <= inputBonusNumber && inputBonusNumber <= LOTTO_NUMBER_MAX);
    }

    private static boolean isDuplicateWinningNumbers(String[] winningNumbers) {
        return Arrays.stream(winningNumbers).distinct().count() != winningNumbers.length;
    }

    private static boolean isNumberOutOfRange(String[] winningNumbers) {
        return Arrays.stream(winningNumbers)
                .mapToInt(Integer::parseInt)
                .anyMatch(number -> !(LOTTO_NUMBER_MIN <= number && number <= LOTTO_NUMBER_MAX));
    }

    private static boolean isNotIntegerWinningNumbers(String[] winningNumbers) {
         return Arrays.stream(winningNumbers).anyMatch(Validator::isNotInteger);
    }

    private static boolean isInvalidWinningNumbersSize(String[] winningNumbers) {
        return winningNumbers.length != LOTTO_NUMBER_COUNT;
    }


    private static boolean isLessThanLottoPrice(int purchaseAmount) {
        return purchaseAmount < LOTTO_PRICE;
    }

    private static boolean isNotDivisionForPrice(int purchaseAmount) {
        return purchaseAmount % LOTTO_PRICE != ZERO;
    }

    private static boolean isNotInteger(String input) {
        try {
            Integer.parseInt(input);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }
}
