package lotto.Option;

public enum GameOption {
    LOTTO_PRICE(1000),
    LOTTO_MAX_NUMBER(45),
    LOTTO_MIN_NUMBER(1),
    THREE_MONEY(5000),
    FOUR_MONEY(50000),
    FIVE_MONEY(1500000),
    FIVE_AND_BONUS_MONEY(30000000),
    SIX_MONEY(2000000000);

    private final int number;

    private GameOption(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
