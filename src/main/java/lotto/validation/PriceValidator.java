package lotto.validation;

import lotto.enums.ErrorMessage;

public class PriceValidator {
    private static final int ZERO = 0;
    private static final int STANDARD_OF_DIVIDE = 1000;

    private PriceValidator() {
    }

    public static void validate(int price) {
        validateZero(price);
        validateDivisibleByThousand(price);
        validateLimit(price);
    }


    private static void validateZero(int price) {
        if (price == ZERO) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ZERO.getMessage());
        }
    }

    private static void validateDivisibleByThousand(int price) {
        if (isNotDivisibleByThousand(price)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_DIVIDE.getMessage());
        }
    }

    private static boolean isNotDivisibleByThousand(int price) {
        if ((price % STANDARD_OF_DIVIDE) != ZERO) {
            return true;
        }
        return false;
    }

    private static void validateLimit(int price) {
        if (price > 100_000) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_LIMIT.getMessage());
        }
    }
}
