package lotto.enums;

public enum Ranking {
    FIRST(2_000_000_000, 6, false),
    SECOND(30_000_000, 5, true),
    THIRD(1_500_000, 5, false),
    FORTH(50_000, 4, false),
    FIFTH(5_000, 3, false),
    BLANK(0, 2, false);

    private final int prize;
    private final int corrects;
    private final boolean bonus;

    Ranking(int prize, int corrects, boolean bonus) {
        this.prize = prize;
        this.corrects = corrects;
        this.bonus = bonus;
    }

    public int getPrize() {
        return prize;
    }

    public int getCorrects() {
        return corrects;
    }

    public boolean isBonus() {
        return bonus;
    }
}
