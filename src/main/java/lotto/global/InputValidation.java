package lotto.global;

import static lotto.global.ErrorMessage.INVALID_LOTTO_NUMBER_ERROR;
import static lotto.global.ErrorMessage.INVALID_LOTTO_SIZE_ERROR;
import static lotto.global.ErrorMessage.INVALID_NATURAL_NUMBER_ERROR;
import static lotto.global.ErrorMessage.INVALID_PRICE_UNIT_ERROR;
import static lotto.global.LottoInformation.LOTTO_BALLS_NUMBER;
import static lotto.global.LottoInformation.LOTTO_MAX_NUMBER;
import static lotto.global.LottoInformation.LOTTO_MIN_NUMBER;
import static lotto.global.LottoInformation.LOTTO_PRICE_UNIT;

import java.util.List;

public class InputValidation {
    private static final int ZERO = 0;

    public static int validPurchasePrice(final String userInput) {
        checkInteger(userInput);
        final int price = StringToInt(userInput);
        checkNaturalNumber(price);
        checkPurchaseAmount(price);
        return price;
    }

    private static void checkInteger(final String userInput) {
        try {
            StringToInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NATURAL_NUMBER_ERROR.getMessage());
        }
    }

    private static void checkNaturalNumber(final int price) {
        if (isSmallerOrSameThan(price, ZERO)) {
            throw new IllegalArgumentException(INVALID_NATURAL_NUMBER_ERROR.getMessage());
        }
    }

    private static void checkPurchaseAmount(final int price) {
        if (!isDividedBy(price, LOTTO_PRICE_UNIT)) {
            throw new IllegalArgumentException(INVALID_PRICE_UNIT_ERROR.getMessage());
        }
    }

    public static void validUserNumbers(final List<Integer> userNumbers) {
        checkNumberSize(userNumbers);
        for (Integer number : userNumbers) {
            checkNaturalNumber(number);
            checkInRange(number);
        }
    }

    private static void checkNumberSize(final List<Integer> userNumbers) {
        if (isUserNumberSizeValid(userNumbers)) {
            throw new IllegalArgumentException(INVALID_LOTTO_SIZE_ERROR.getMessage());
        }
    }

    private static boolean isUserNumberSizeValid(final List<Integer> userNumbers) {
        return userNumbers.size() != LOTTO_BALLS_NUMBER;
    }

    private static void checkInRange(final int number) {
        if (isOutOfRange(number)) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_ERROR.getMessage());
        }
    }

    private static boolean isOutOfRange(final int number) {
        return isSmallerThan(number, LOTTO_MIN_NUMBER) || isBiggerThan(number, LOTTO_MAX_NUMBER);
    }

    public static int validBonusNumber(final String userInput) {
        checkInteger(userInput);
        int bonusNumber = StringToInt(userInput);
        checkInRange(bonusNumber);
        return bonusNumber;
    }

    private static boolean isBiggerThan(final int number, final int pivot) {
        return number > pivot;
    }

    private static boolean isSmallerThan(final int number, final int pivot) {
        return number < pivot;
    }

    private static boolean isSmallerOrSameThan(final int number, final int pivot) {
        return number <= pivot;
    }

    private static boolean isDividedBy(final int number, final int pivot) {
        return number % pivot == ZERO;
    }

    private static int StringToInt(final String userInput) {
        return Integer.parseInt(userInput);
    }
}
