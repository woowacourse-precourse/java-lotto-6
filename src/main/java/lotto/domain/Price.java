package lotto.domain;

public class Price {

    public static final String PRICE_UNIT_VALID_LOG = "1,000원 단위로 입력해주세요.";
    public static final int STANDARD_UNIT = 1000;
    public final int price;

    public Price(final int price) {
        validateUnit(price);
        this.price = price;
    }

    private void validateUnit(final int price) {
        if (price % STANDARD_UNIT != 0) {
            throw new IllegalArgumentException(PRICE_UNIT_VALID_LOG);
        }
    }

    public int toInt() {
        return price;
    }
}


