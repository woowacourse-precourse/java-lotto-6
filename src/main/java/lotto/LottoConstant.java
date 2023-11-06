package lotto;

public enum LottoConstant {

    MIN_AMOUNT_OF_LOTTO(1_000),
    MAX_AMOUNT_OF_LOTTO(100_000);

    private final int price;

    LottoConstant(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
