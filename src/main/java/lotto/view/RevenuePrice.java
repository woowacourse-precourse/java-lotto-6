package lotto.view;

public enum RevenuePrice {
    INDEX_ZERO(2000000000),
    INDEX_ONE(30000000),
    INDEX_TWO(1500000),
    INDEX_THREE(50000),
    INDEX_FOUR(5000);

    public final int price;

    private RevenuePrice(int price) {
        this.price = price;
    }
}
