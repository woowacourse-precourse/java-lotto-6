package lotto.domain;

public enum LottoPrize {
    THREE_MATCHES(3, 5_000, false),
    FOUR_MATCHES(4, 50_000, false),
    FIVE_MATCHES(5, 1_500_000, false),
    FIVE_PLUS_BONUS(5, 30_000_000, true),
    SIX_MATCHES(6, 2_000_000_000, false);

    private final int matches;
    private final int prize;
    private final boolean bonus;

    LottoPrize(int matches, int prize, boolean bonus) {
        this.matches = matches;
        this.prize = prize;
        this.bonus = bonus;
    }

    public int getMatches() {
        return matches;
    }

    public int getPrize() {
        return prize;
    }

    public boolean isBonus() {
        return bonus;
    }
    
}
