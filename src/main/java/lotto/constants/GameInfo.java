package lotto.constants;

public enum GameInfo {

    // MONEY
    USER_MONEY_MIN(1000),
    USER_MONEY_UNIT(1000),
    USER_MONEY_MAX(100000),

    // LOTTO
    LOTTO_PRICE(1000),
    LOTTO_COUNT(6),
    LOTTO_MIN_NUMBER(1),
    LOTTO_MAX_NUMBER(45);


    private final int price;

    GameInfo(int price) {
        this.price = price;
    }

    public int getNumber() {
        return price;
    }
}
