package lotto.domain;

public enum LottoNumberRule {
    MIN(1),
    MAX(45),
    COUNT(6);

    private final int number;

    LottoNumberRule(int value) {
        this.number = value;
    }

    public int number() {
        return this.number;
    }
}
