package lotto.validation;

import lotto.enums.Delimiter;
import lotto.enums.LottoValue;

public class PriceValidator {
    private static final String ERROR_PREFIX = Delimiter.ERROR_PREFIX.getDelimiter();

    private PriceValidator() {
    }

    public static void validate(long price) {
        validateZero(price);
        validateDivisibleByThousand(price);
        validateLimit(price);
    }

    private static void validateZero(long price) {
        if (price == 0) {
            throw new IllegalArgumentException(ERROR_PREFIX + "구입가격은 0을 입력할 수 없습니다.");
        }
    }

    private static void validateDivisibleByThousand(long price) {
        if (extractRemainderDividedByThousand(price) != 0) {
            throw new IllegalArgumentException(ERROR_PREFIX + "1000원 단위의 수를 입력해야 합니다.");
        }
    }

    private static long extractRemainderDividedByThousand(long price) {
        return price % LottoValue.PRICE_PER_LOTTO.getValue();
    }

    private static void validateLimit(long price) {
        if (price > LottoValue.PURCHASE_LIMIT_PRICE.getValue()) {
            throw new IllegalArgumentException(ERROR_PREFIX + "로또 구입 금액은 10만원을 초과할 수 없습니다.");
        }
    }
}
