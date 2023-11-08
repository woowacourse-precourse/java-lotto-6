package lotto.validation;

import static lotto.constant.Constant.LOTTO_CNT;
import static lotto.constant.Constant.LOTTO_MAX_VALUE;
import static lotto.constant.Constant.LOTTO_MIN_VALUE;
import static lotto.constant.Constant.LOTTO_PURCHASE_MINIMUM_AMOUNT;

import java.util.Arrays;
import java.util.regex.Pattern;
import lotto.error.ErrorMessage;

public class LottoInputValidator {

    private static final String REGEXP_PATTERN_ZERO_TO_NINE_NUMBER = "^[0-9]*$";

    public static void validateLottoPurchaseAmount(String lottoPurchaseAmount) {
        if (!isOnlyInteger(lottoPurchaseAmount)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_INTEGER_LOTTO_PURCHASE_AMOUNT.getMessage());
        }

        if (isStartZero(lottoPurchaseAmount)) {
            throw new IllegalArgumentException(ErrorMessage.START_ZERO_LOTTO_PURCHASE_AMOUNT.getMessage());
        }

        if (!isDividedByLottoPurchaseMinimumAmount(lottoPurchaseAmount)) {
            throw new IllegalArgumentException(
                    ErrorMessage.NOT_DIVIDE_LOTTO_PURCHASE_MINIMUM_AMOUNT.getMessage());
        }
    }

    public static void validateLottoWinningNumbers(String[] winningNumbers) {
        Arrays.stream(winningNumbers).forEach(number -> {
            if (number.isBlank()) {
                throw new IllegalArgumentException(ErrorMessage.BLANK_LOTTO_WINNING_NUMBER.getMessage());
            }
            if (!isOnlyInteger(number)) {
                throw new IllegalArgumentException(ErrorMessage.NOT_INTEGER_WINNING_NUMBER.getMessage());
            }
            if (isStartZero(number)) {
                throw new IllegalArgumentException(ErrorMessage.START_ZERO_WINNING_NUMBER.getMessage());
            }
            if (!isRightSize(winningNumbers.length)) {
                throw new IllegalArgumentException(ErrorMessage.NOT_RIGHT_SIZE_WINNING_NUMBER.getMessage());
            }
        });
    }

    public static void validateBonusNumber(String bonusNumber) {
        if (!isOnlyInteger(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_INTEGER_BONUS_NUMBER.getMessage());
        }
        if (isStartZero(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.START_ZERO_BONUS_NUMBER.getMessage());
        }
        if (!isInRangeLottoNumber(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.OVER_RANGE_BONUS_NUMBER.getMessage());
        }
    }

    private static boolean isOnlyInteger(String input) {
        return Pattern.matches(REGEXP_PATTERN_ZERO_TO_NINE_NUMBER, input);
    }

    private static boolean isStartZero(String input) {
        return input.charAt(0) == '0';
    }

    private static boolean isDividedByLottoPurchaseMinimumAmount(String input) {
        return Integer.parseInt(input) % LOTTO_PURCHASE_MINIMUM_AMOUNT == 0;
    }

    private static boolean isRightSize(int length) {
        return length == LOTTO_CNT;
    }

    private static boolean isInRangeLottoNumber(String numberString) {
        int number = Integer.parseInt(numberString);
        return number >= LOTTO_MIN_VALUE && number <= LOTTO_MAX_VALUE;
    }
}
