package lotto.enums;

public enum LottoConstants {
    LOTTO_PRICE(1000),
    LOTTO_START_NUMBER(1),
    LOTTO_END_NUMBER(45),
    LOTTO_PER_NUMBERS(6);

    private final int constant;

    LottoConstants(int constant) {
        this.constant = constant;
    }

    public int getConstant() {
        return constant;
    }
}
