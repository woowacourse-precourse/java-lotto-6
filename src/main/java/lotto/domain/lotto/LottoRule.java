package lotto.domain.lotto;

public enum LottoRule {

    LOTTO_NUMBER_COUNT(6),
    LOTTO_MIN_NUMBER_INCLUSION(1),
    LOTTO_MAX_NUMBER_INCLUSION(45),
    LOTTO_PRICE(1000);

    private final int value;

    LottoRule(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
