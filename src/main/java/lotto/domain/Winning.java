package lotto.domain;

public enum Winning {
    FIND(1, 0),
    THIRD(3, 5_000),
    FOURTH(4, 50_000),
    FIFTH(5, 1_500_000),
    FIFTH_WITH_BONUS(7, 30_000_000),
    SIXTH(6, 2_000_000_000);

    private final int label;
    private final int price;

    Winning(int label, int price) {
        this.label = label;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public Winning valueOf(int label) {
        for (Winning winning : Winning.values()) {
            if (label == winning.label) {
                return winning;
            }
        }

        return null;
    }
}
