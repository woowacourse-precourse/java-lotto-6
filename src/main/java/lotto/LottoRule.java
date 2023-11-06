package lotto;

public enum LottoRule {
    LOTTO_NUMBER_START(1),
    LOTTO_NUMBER_END(45),
    LOTTO_NUMBER_COUNT(6),
    LOTTO_PRICE(1000);

    private final int value;

    LottoRule(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }
}
