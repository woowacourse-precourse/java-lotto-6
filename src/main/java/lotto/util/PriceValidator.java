package lotto.util;

public class PriceValidator {
    private static final String MIN_PRICE_1000_MESSAGE = "금액은 1000원 이상이어야 합니다";
    private static final String UNIT_OF_1000_REQUIRED_MESSAGE = "금액은 1000원 단위로 입력되어야 합니다";

    private PriceValidator() {
    }

    public static void validatePrice(Integer price) {
        if (isUnder1000(price)) {
            throw new IllegalArgumentException(MIN_PRICE_1000_MESSAGE);
        }

        if (isDividedBy1000(price) == false) {
            throw new IllegalArgumentException(UNIT_OF_1000_REQUIRED_MESSAGE);
        }
    }

    private static boolean isDividedBy1000(int price) {
        if (price % 1000 == 0) {
            return true;
        }

        return false;
    }

    private static boolean isUnder1000(int price) {
        if (price < 1000) {
            return true;
        }

        return false;
    }
}
