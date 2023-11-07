package lotto.util;

public class PriceValidator {
    private static final String MIN_PRICE_1000_MESSAGE = "금액은 1000원 이상이어야 합니다";
    private static final String UNIT_OF_1000_REQUIRED_MESSAGE = "금액은 1000원 단위로 입력되어야 합니다";

    private PriceValidator() {
    }

    public static void validatePrice(Integer price) {
        validateIsUnder1000(price);
        validateIsDividedBy1000(price);
    }

    private static void validateIsDividedBy1000(int price) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException(UNIT_OF_1000_REQUIRED_MESSAGE);
        }
    }

    private static void validateIsUnder1000(int price) {
        if (price < 1000) {
            throw new IllegalArgumentException(MIN_PRICE_1000_MESSAGE);
        }
    }
}
