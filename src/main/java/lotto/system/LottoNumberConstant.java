package lotto.system;

public enum LottoNumberConstant {
    LENGTH(6),
    MIN(1),
    MAX(45);

    private final int value;

    LottoNumberConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
