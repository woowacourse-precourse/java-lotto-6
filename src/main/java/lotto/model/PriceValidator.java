package lotto.model;

public class PriceValidator {

    private static final int MIN_PRICE = 1000;

    public static int validate(String price) {
        validateNumber(price);
        validateMinPrice(price);
        validatePriceUnit(price);
        return Integer.parseInt(price) / MIN_PRICE;
    }

    private static void validateNumber(String price) {
        try {
            Integer.parseInt(price);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(LottoError.LOTTO_INPUT_FAILED_PRICE.getMessage());
        }
    }

    private static void validateMinPrice(String price) {
        if(Integer.parseInt(price) < MIN_PRICE) {
            throw new IllegalArgumentException(LottoError.LOTTO_PRICE.getMessage());
        }
    }
    private static void validatePriceUnit(String price) {
        if(Integer.parseInt(price) % MIN_PRICE != 0) {
            throw new IllegalArgumentException(LottoError.LOTTO_PRICE.getMessage());
        }
    }
}
