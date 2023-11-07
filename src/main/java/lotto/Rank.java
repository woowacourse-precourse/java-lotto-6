package lotto;

public enum Rank {

    RANK_1(6, 2_000_000_000),
    RANK_2(5, 30_000_000),
    RANK_3(5, 1_500_000),
    RANK_4(4, 50_000),
    RANK_5(3, 5_000),
    RANK_NONE(0, 0);

    private int correctCount;
    private int price;

    Rank(int correctCount, int price) {
        this.correctCount = correctCount;
        this.price = price;
    }

    public static Rank find(int correctCount, boolean hasBonus) {
        if (correctCount == 5 && hasBonus) {
            return RANK_2;
        }

        if (correctCount == 5) {
            return RANK_3;
        }

        for (Rank rank : values()) {
            if (rank.correctCount == correctCount) {
                return rank;
            }
        }
        return RANK_NONE;
    }

    public int getPrice() {
        return price;
    }
}