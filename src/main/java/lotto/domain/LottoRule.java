package lotto.domain;

public enum LottoRule {
    MIN(1),
    MAX(45),
    SIZE(6);

    private final int value;

    LottoRule(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    public static boolean outOfRange(int number) {
        return number < MIN.value || number > MAX.value;
    }
}
