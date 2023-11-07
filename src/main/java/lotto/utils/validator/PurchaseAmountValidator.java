package lotto.utils.validator;

import lotto.utils.message.PurchaseAmountExceptionMessage;

public class PurchaseAmountValidator {

    private static final long LOTTO_COUNTS_MIN_LIMIT = 1L;
    private static final long LOTTO_COUNTS_MAX_LIMIT = 100_000L;
    private static final long LOTTO_PRICE_UNIT = 1000L;

    public static void validate(String input) {
        validateBlank(input);
        validateMaxLength(input);
        validateNumeric(input);
        validateRange(input);
        validateAmountUnit(input);
    }

    private static void validateBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(PurchaseAmountExceptionMessage.BLANK.getError());
        }
    }

    private static void validateMaxLength(String input) {
        if (input == null || input.length() > String.valueOf(LOTTO_COUNTS_MAX_LIMIT * LOTTO_PRICE_UNIT).length()) {
            throw new IllegalArgumentException(PurchaseAmountExceptionMessage.EXCEED_LENGTH.getError());
        }
    }

    private static void validateNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(PurchaseAmountExceptionMessage.NOT_NUMERIC.getError(), e);
        }
    }

    private static void validateRange(String input) {
        int purchaseAmount = Integer.parseInt(input);

        if (purchaseAmount < LOTTO_COUNTS_MIN_LIMIT * LOTTO_PRICE_UNIT ||
                purchaseAmount > LOTTO_COUNTS_MAX_LIMIT * LOTTO_PRICE_UNIT) {
            throw new IllegalArgumentException(PurchaseAmountExceptionMessage.OUT_OF_AMOUNT_RANGE.getError());
        }
    }

    private static void validateAmountUnit(String input) {
        int purchaseAmount = Integer.parseInt(input);

        if (purchaseAmount % LOTTO_PRICE_UNIT != 0) {
            throw new IllegalArgumentException(PurchaseAmountExceptionMessage.INVALID_AMOUNT_UNIT.getError());
        }
    }
}
