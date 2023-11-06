package lotto.domain;

public class LottoBuyPrice {

    private static final double ALLOWED_AMOUNT_UNIT = 1000.0;

    private final int price;

    public LottoBuyPrice(int price) {
        validatePrice(price);
        this.price = price;
    }

    private void validatePrice(int price) {
        if (!isPositiveNumber(price) || !isAllowedAmountUnit(price)) {
            throw new IllegalArgumentException("유효하지 않은 로또 구입 금액입니다.");
        }
    }

    private boolean isPositiveNumber(int price) {
        return price > 0;
    }

    private boolean isAllowedAmountUnit(int price) {
        return price % ALLOWED_AMOUNT_UNIT == 0;
    }
}
