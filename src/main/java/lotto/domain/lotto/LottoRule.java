package lotto.domain.lotto;

public enum LottoRule {
    SIZE(6),
    MINIMUM(1),
    MAXIMUM(45),
    PRICE(1000),
    PERCENT(100);

    private final int value;

    LottoRule(final int value) {
        this.value = value;
    }

    public final int getValue() {
        return this.value;
    }
}
