package lotto.domain;

public enum LottoNumber {
    MIN(1),
    MAX(45);

    private final int value;

    LottoNumber(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
