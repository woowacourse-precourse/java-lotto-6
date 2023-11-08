package lotto.rule;

public enum LottoGameRule {
    LOTTO_NUMBERS_SIZE(6),
    MIN_LOTTO_NUMBER(1),
    MAX_LOTTO_NUMBER(45),
    LOTTO_COST_UNIT(1000),
    INITIAL_WINNING_NUMBER(0),
    EARNINGS_RATE_PERCENTAGE(100);

    private final int constant;

    LottoGameRule(int constant) {
        this.constant = constant;
    }

    public int getConstant() {
        return constant;
    }

}
