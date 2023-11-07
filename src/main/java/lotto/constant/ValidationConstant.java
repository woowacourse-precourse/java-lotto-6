package lotto.constant;

public enum ValidationConstant {
    MAX_LOTTO_NUMBER(45),
    MIN_LOTTO_NUMBER(1),
    LOTTO_SIZE(6),
    STANDARD_MONEY_UNIT(1000);

    int number;
    ValidationConstant(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
