package util;

public enum LottoWinningPrice {
    FIRST_PRICE(2000000000),
    SECOND_PRICE(30000000),
    THIRD_PRICE(1500000),
    FOURTH_PRICE(50000),
    FIFTH_PRICE(5000);

    private final int price;

    LottoWinningPrice(int price) {
        this.price = price;
    }

    public int get() {
        return price;
    }
}
