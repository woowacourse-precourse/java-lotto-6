package lotto.constants;

public enum LottoEnum {
    LOTTO_SIZE(6),
    LOTTO_MIN_NUMBER(1),
    LOTTO_MAX_NUMBER(45),
    LOTTO_PRICE(1000),
    LOTTO_EQUAL_THREE_PRIZE_MONEY(5000),
    LOTTO_EQUAL_FOUR_PRIZE_MONEY(50000),
    LOTTO_EQUAL_FIVE_PRIZE_MONEY(1500000),
    LOTTO_EQUAL_FIVE_AND_BONUS_PRIZE_MONEY(30000000),
    LOTTO_EQUAL_SIX_PRIZE_MONEY(2000000000);

    private final int value;

    LottoEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
