package lotto.constant;

public enum LottoInformation {
    LOTTO_NUMBER_TOTAL_SIZE(6),
    MIN_LOTTO_NUMBER(1),
    MAX_LOTTO_NUMBER(45),
    MONEY_UNIT(1000);
    private final int number;

    LottoInformation(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
