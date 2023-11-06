package lotto.constant;

public enum PriceConstant {
    FIFTH_PLACE("fifth", 3, 5_000),
    FOURTH_PLACE("fourth", 4, 50_000),
    THIRD_PLACE("third", 5, 1_500_000),
    SECOND_PLACE("second", 5, 30_000_000),
    FIRST_PLACE("first", 6, 2_000_000_000);

    private final String label;
    private final int count;
    private final int price;

    PriceConstant(String label, int count, int price) {
        this.label = label;
        this.count = count;
        this.price = price;
    }

    public String getLabel() {
        return label;
    }

    public int getCount() {
        return count;
    }

    public static int getPriceByLabel(String label) {
        int priceByLabel = 0;

        for (PriceConstant priceConstant : PriceConstant.values()) {
            if (priceConstant.label.equals(label)) {
                priceByLabel = priceConstant.price;
            }
        }
        return priceByLabel;
    }

    public static int getCountByLabel(String label) {
        int countByLabel = 0;

        for (PriceConstant priceConstant : PriceConstant.values()) {
            if (priceConstant.label.equals(label)) {
                countByLabel = priceConstant.count;
            }
        }
        return countByLabel;
    }
}
