package lotto;

public enum LottoConstants {
    LOTTO_PRICE(1000),
    LOTTO_START_NUMBER(1),
    LOTTO_END_NUMBER(45),
    LOTTO_PER_NUMBERS(6),
    FIRST_PRIZE_MONEY(2000000000),
    SECOND_PRIZE_MONEY(30000000),
    THIRD_PRIZE_MONEY(1500000),
    FOURTH_PRIZE_MONEY(50000),
    FIFTH_PRIZE_MONEY(5000);

    private final int constant;

    private LottoConstants(int constant) {
        this.constant = constant;
    }

    public int getConstant() {
        return constant;
    }
}
