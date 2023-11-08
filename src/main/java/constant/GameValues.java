package constant;


public enum GameValues {
    MONEY_UNIT(1000),
    MIN_LOTTO_NUM(1),
    MAX_LOTTO_NUM(45),
    MAX_MONEY(1000000),
    MIN_MONEY(1000),
    LOTTO_WINNING_NUM_SIZE(6);

    private final int value;


    GameValues(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }


    @Override
    public String toString() {
        return String.valueOf(this.value);
    }

}
