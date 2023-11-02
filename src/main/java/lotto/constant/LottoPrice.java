package lotto.constant;

public enum LottoPrice {
    LOTTO_PRICE(1000);

    private final int number;

    LottoPrice(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
