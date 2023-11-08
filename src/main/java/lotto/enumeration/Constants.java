package lotto.enumeration;

public enum Constants {
    START_DIGIT(1),
    END_DIGIT(45),
    LOTTO_NUM(6),
    AMOUNT_LIMIT(2000000000),
    UNITS_OF_AMOUNT(1000);

    int constant;

    Constants(int constant) {
        this.constant = constant;
    }

    public int getConstant() {
        return this.constant;
    }
}
