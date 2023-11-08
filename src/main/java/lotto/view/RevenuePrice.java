package lotto.view;

public enum RevenuePrice {
    INDEX_ZERO(2000000000, 0),
    INDEX_ONE(30000000, 1),
    INDEX_TWO(1500000, 2),
    INDEX_THREE(50000, 3),
    INDEX_FOUR(5000, 4);

    public final int price;
    public final int index;

    private RevenuePrice(int price, int index) {
        this.price = price;
        this.index = index;
    }

    public static int getPriceByIndex(int index) {
        for (RevenuePrice revenuePrice : RevenuePrice.values()) {
            if (revenuePrice.index == index) {
                return revenuePrice.price;
            }
        }
        return 0;
    }
}
