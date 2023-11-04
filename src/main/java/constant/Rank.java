package constant;

public enum Rank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, false, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0, false, 0);

    private final int match;
    private final boolean bonus;
    private final int prize;

    Rank(int match, boolean bonus, int prize) {
        this.match = match;
        this.bonus = bonus;
        this.prize = prize;
    }

    private int getMatch() {
        return match;
    }

    private boolean isBonus() {
        return bonus;
    }

    public int getPrize() {
        return prize;
    }

    public static Rank getRank(int match, boolean bonus) {
        if (match == 6) {
            return Rank.FIRST;
        }
        if (match == 5 && bonus) {
            return Rank.SECOND;
        }
        if (match == 5) {
            return Rank.THIRD;
        }
        if (match == 4) {
            return Rank.FOURTH;
        }

        if (match == 3) {
            return Rank.FIFTH;
        }

        return Rank.NONE;
    }
}
