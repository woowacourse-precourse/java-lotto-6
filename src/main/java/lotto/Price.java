package lotto;

public enum Price {
    LOTTO(1000);

    private final int lotto;

    Price(int lotto) {
        this.lotto = lotto;
    }

    public int getLottoPrice() {
        return lotto;
    }
}
