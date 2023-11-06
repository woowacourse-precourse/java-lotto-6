package lotto;

public enum Prize {
    SIX(6, "2,000,000,000"),
    BONUS(5, "30,000,000"),
    FIVE(5, "1,500,000"),
    FOUR(4, "50,000"),
    THREE(3, "5,000"),
    NONE(0, "0");

    private final int count;
    private final String prize;

    Prize(int count, String prize) {
        this.count = count;
        this.prize = prize;
    }

    public int getCount() {
        return count;
    }

    public String getPrize() {
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
