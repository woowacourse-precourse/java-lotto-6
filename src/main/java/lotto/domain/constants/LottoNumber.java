package lotto.domain.constants;
public enum LottoNumber {
    MIN_NUMBER(1),
    MAX_NUMBER(45),
    NUMBER_COUNT(6);

    private final int value;

    LottoNumber(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}