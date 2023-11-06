package lotto.domain.enums;

public enum Constant {

    LOTTO_MIN_NUMBER(1),
    LOTTO_MAX_NUMBER(45),
    LOTTO_NUMBER_LENGTH(6);

    private final int constant;

    Constant(int constant) {
        this.constant = constant;
    }

    public int getConstant() {
        return constant;
    }

}
