package lotto.util;

public enum AmountOfLotto {
    MINIMUM_PRICE(1),
    MAXIMUM_PRICE(Integer.MAX_VALUE),

    LOTTO_PRICE(1000),

    MINIMUM_AMOUNT_OF_LOTTO(0),
    MAXIMUM_AMOUNT_OF_LOTTO(2147483);

    private final Integer price;

    AmountOfLotto(Integer price) {
        this.price = price;
    }

    public Integer getPrice() {
        return price;
    }
}
