package lotto.model;

public enum LottoGameSettingConstValue {
    MAX_LOTTO_NUMBER(45),
    MIN_LOTTO_NUMBER(1),
    LOTTO_NUMBER_SIZE(6),
    MAXIMUM_PURCHASE_AMOUNT(1000000000),
    LOTTO_PRICE(1000),
    FIRST_RANK(1),
    LAST_RANK(5),
    FIRST_PRIZE_NUMBER(6),
    SECOND_PRIZE_NUMBER(5),
    SECOND_PRIZE_BONUS_NUMBER(1),
    THIRD_PRIZE_NUMBER(5),
    FOURTH_PRIZE_NUMBER(4),
    FIFTH_PRIZE_NUMBER(3),
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

    public int getPrizeMoney(int rank) {
        if (rank == 1) {
            return FIRST_PRIZE_MONEY.getValue();
        } else if (rank == 2) {
            return SECOND_PRIZE_MONEY.getValue();
        } else if (rank == 3) {
            return THIRD_PRIZE_MONEY.getValue();
        } else if (rank == 4) {
            return FOURTH_PRIZE_MONEY.getValue();
        } else if (rank == 5) {
            return FIFTH_PRIZE_MONEY.getValue();
        }
        return 0;
    }
}
