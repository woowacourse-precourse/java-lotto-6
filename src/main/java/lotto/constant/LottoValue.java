package lotto.constant;

public enum LottoValue {
    NUMBER_MIN_VALUE(1),
    NUMBER_MAX_VALUE(45),
    WINNING_NUMBER_CNT(6),
    BONUS_NUMBER_CNT(1),
    PRICE_PER_PIECE(1000),
    MAXIMUM_PURCHASE_PRICE(100000000);

    private int value;

    LottoValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
