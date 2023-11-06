package lotto.constant;

public enum PriceConstant {
    FIFTH_PLACE(3, 5_000),
    FOURTH_PLACE(4, 50_000),
    THIRD_PLACE(5, 1_500_000),
    SECOND_PLACE(5, 30_000_000),
    FIRST_PLACE(6, 2_000_000_000);

    private final int count;
    private final int price;

    PriceConstant(int count, int price) {
        this.count = count;
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public static int getPricebyCount(int count) {
        int priceByCount = 0;

        for (PriceConstant priceConstant : PriceConstant.values()) {
            if (priceConstant.count == count) {
                priceByCount = priceConstant.price;
            }
        }
        return priceByCount;
    }
}
