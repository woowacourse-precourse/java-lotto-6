package lotto.util;

/**
 * 로또 구입 개수, 가격에 관련된 Integer 정보가 저장된다.
 */
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
