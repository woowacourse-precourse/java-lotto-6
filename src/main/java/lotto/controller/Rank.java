package lotto.controller;

public enum Rank {
    NONE(0, " (0원)", 0),
    FIFTH(3, " (5,000원)", 5000),
    FOURTH(4, " (50,000원)", 50000),
    THIRD(5, " (1,500,000원)", 1500000),
    SECOND(5, ", 보너스 볼 일치 (30,000,000원)", 30000000),
    FIRST(6, " (2,000,000,000원)", 2000000000);

    private final int score;
    private final String earn;
    private final long price;

    Rank(int score, String earn, long price) {
        this.score = score;
        this.earn = earn;
        this.price = price;
    }

    public static Rank value(int count, boolean gotBonus) {
        if (count == SECOND.score && gotBonus) {
            return SECOND;
        }
        for (Rank rank : values()) {
            if (rank.score == count && rank != SECOND) {
                return rank;
            }
        }
        return NONE;
    }

    public int getScore() {
        return score;
    }

    public String getEarn() {
        return earn;
    }

    public long getPrice() {
        return price;
    }
}