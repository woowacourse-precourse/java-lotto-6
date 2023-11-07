package lotto.domain;

public class Price {

    private static final int MIN_AMOUNT = 1000;
    private static final int PRICE_UNIT = 1000;

    private final int price;

    public Price(int price) {
        validate(price);
        this.price = price;
    }

    private void validate(int price) {
        if (price < MIN_AMOUNT) {
            throw new IllegalArgumentException(String.format("[ERROR] 금액은 최소 %d원 이상 입력되어야 합니다.", MIN_AMOUNT));
        }

        if (price % PRICE_UNIT != 0) {
            throw new IllegalArgumentException(String.format("[ERROR] 금액은 %d원 단위로 입력이 가능합니다.",PRICE_UNIT));
        }
    }

    public int calculateLottoCount() {
        return this.price / PRICE_UNIT;
    }
}
