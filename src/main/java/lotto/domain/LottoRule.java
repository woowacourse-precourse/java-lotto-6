package lotto.domain;

public enum LottoRule {
    MIN(1),
    MAX(45),
    SIZE(6);

    private final int value;

    LottoRule(final int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    public static boolean outOfRange(final int number) {
        return number < MIN.value || number > MAX.value;
    }
}
