package lotto.domain;

public enum Rank {
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    FIVE_WITH_BONUS(5, 3_000_000),
    SIX(6, 20_000_000);

    private final int match;
    private final int price;

    Rank(int match, int price) {
        this.match = match;
        this.price = price;
    }
}
