package lotto.constants;

public enum Constant {

    MATCHED_SIX_PRICE(2000000000),
    MATCHED_FIVE_ONE_BONUS_PRICE(30000000),
    MATCHED_FIVE_PRICE(1500000),
    MATCHED_FOUR_PRICE(50000),
    MATCHED_THREE_PRICE(5000);

    private final Integer constant;

    Constant(Integer constant) {
        this.constant = constant;
    }

    public Integer getConstant() {
        return this.constant;
    }
}