package lotto.model;

public enum LottoGameSettingConstValue {
    MAX_LOTTO_NUMBER(45),
    MIN_LOTTO_NUMBER(1),
    LOTTO_NUMBER_SIZE(6),
    MAXIMUM_PURCHASE_AMOUNT(1000000000),
    LOTTO_PRICE(1000),
    FIRST_PRIZE_MONEY(2000000000),
    SECOND_PRIZE_MONEY(30000000),
    THIRD_PRIZE_MONEY(1500000),
    FOURTH_PRIZE_MONEY(50000),
    FIFTH_PRIZE_MONEY(5000);

    private final int value;

    LottoGameSettingConstValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public int getPrizeMoney(int i) {
        if (i == 1) {
            return FIRST_PRIZE_MONEY.getValue();
        } else if (i == 2) {
            return SECOND_PRIZE_MONEY.getValue();
        } else if (i == 3) {
            return THIRD_PRIZE_MONEY.getValue();
        } else if (i == 4) {
            return FOURTH_PRIZE_MONEY.getValue();
        } else if (i == 5) {
            return FIFTH_PRIZE_MONEY.getValue();
        }
        return 0;
    }
}
