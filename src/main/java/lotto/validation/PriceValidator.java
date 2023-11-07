package lotto.validation;

import lotto.enums.ErrorMessage;
import lotto.enums.LottoValue;

public class PriceValidator {

    private PriceValidator() {
    }

    public static void validate(long price) {
        validateZero(price);
        validateDivisibleByThousand(price);
        validateLimit(price);
    }

    private static void validateZero(long price) {
        if (price == 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ZERO.getMessage());
        }
    }

    private static void validateDivisibleByThousand(long price) {
        if (extractRemainderDividedByThousand(price) != 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_DIVIDE.getMessage());
        }
    }

    private static long extractRemainderDividedByThousand(long price) {
        return price % LottoValue.PRICE_PER_LOTTO.getValue();
    }

    private static void validateLimit(long price) {
        if (price > LottoValue.PURCHASE_LIMIT_PRICE.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_LIMIT.getMessage());
        }
    }
}
