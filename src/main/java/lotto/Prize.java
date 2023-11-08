package lotto;

public enum Prize {
    NONE(0, 0),
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    BONUS(5, 30_000_000),
    SIX(6, 2_000_000_000);

    private final int count;
    private final int prize;

    Prize(int count, int prize) {
        this.count = count;
        this.prize = prize;
    }

    public int getCount() {
        return count;
    }

    public int getPrize() {
        return prize;
    }

    public static Prize valueOf(int matchCount, boolean hasBonus) {
        if (matchCount == 6) return SIX;
        if (matchCount == 5 && hasBonus) return BONUS;
        if (matchCount == 5) return FIVE;
        if (matchCount == 4) return FOUR;
        if (matchCount == 3) return THREE;
        return NONE;
    }
}
