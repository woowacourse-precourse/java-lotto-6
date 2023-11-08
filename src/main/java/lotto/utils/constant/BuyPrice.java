package lotto.utils.constant;

import java.util.Objects;

public class BuyPrice {
    public static final int LOTTO_PRICE = 1_000;
    public static final int ZERO = 0;
    public static final String INVALID_PRICE_FORMAT_MESSAGE = "구매 금액은 숫자만 입력할 수 있습니다.";
    public static final String INVALID_PRICE_PER_LOTTO_MESSAGE = "로또 가격은 " + LOTTO_PRICE + "원 단위로만 입력할 수 있습니다.";
    public static final String INVALID_BUY_PRICE_ZERO_MESSAGE = "구매 금액은 " + ZERO + "원 이상이어야 합니다.";
    private final int buyPrice;

    public BuyPrice(String buyPrice) {
        validate(buyPrice);
        this.buyPrice = toInteger(buyPrice);
    }

    private void validate(String buyPrice) {
        int price = toInteger(buyPrice);
        validateZero(price);
        validateUnit(price);
    }

    private static int toInteger(String buyPrice) {
        try {
            return Integer.parseInt(buyPrice);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_PRICE_FORMAT_MESSAGE, e);
        }
    }

    private void validateUnit(int price) {
        if (price % LOTTO_PRICE != ZERO) {
            throw new IllegalArgumentException(INVALID_PRICE_PER_LOTTO_MESSAGE);
        }
    }

    private void validateZero(int price) {
        if (price == ZERO) {
            throw new IllegalArgumentException(INVALID_BUY_PRICE_ZERO_MESSAGE);
        }
    }

    public int getBuyCount() {
        return buyPrice / LOTTO_PRICE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BuyPrice buyPrice1 = (BuyPrice) o;
        return buyPrice == buyPrice1.buyPrice;
    }

    @Override
    public int hashCode() {
        return Objects.hash(buyPrice);
    }
}
