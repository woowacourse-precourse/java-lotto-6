package lotto.constant;

public enum LottoNumber {
    RANGE_START_NUMBER(1),
    RANGE_END_NUMBER(45),
    LOTTO_NUMBER_COUNT(6);

    private final int number;

    LottoNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
