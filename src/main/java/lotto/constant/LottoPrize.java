package lotto.constant;

public enum LottoPrize {
    FIRST_PRIZE(6, 2_000_000_000)
    , SECOND_PRIZE(51, 30_000_000)
    , THIRD_PRIZE(5, 1_500_000)
    , FOURTH_PRIZE(4, 50_000)
    , FIFTH_PRIZE(3, 5_000)
    ;

    private final int numberOfMatch;
    private final int price;

    LottoPrize(int numberOfMatch, int price) {
        this.numberOfMatch = numberOfMatch;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public int getNumberOfMatch() {
        return numberOfMatch;
    }
}
