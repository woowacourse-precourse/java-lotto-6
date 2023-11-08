package lotto.config;

public enum LottoPrice {
    LOTTO_PRICE(1000);

    private final int value;

    LottoPrice(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
