package lotto.domain;

public enum LottoStandard {
    SIZE(6),
    MIN(1),
    MAX(45);

    private final int number;

    LottoStandard(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
