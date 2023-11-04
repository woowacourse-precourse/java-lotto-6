package lotto.constants;

public enum GameInfo {

    // MONEY
    USER_MONEY_MIN(1000),
    USER_MONEY_UNIT(1000),
    USER_MONEY_MAX(100000),

    // LOTTO
    LOTTO_PRICE(1000);


    private final int price;

    GameInfo(int price) {
        this.price = price;
    }

    public int getNumber() {
        return price;
    }
}
