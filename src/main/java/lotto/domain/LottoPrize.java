package lotto.domain;

public enum LottoPrize {
    THREE_MATCHES(3, 5_000),
    FOUR_MATCHES(4, 50_000),
    FIVE_MATCHES(5, 1_500_000),
    FIVE_PLUS_BONUS(5, 30_000_000, true),
    SIX_MATCHES(6, 2_000_000_000);

    private final int matches;
    private final int prize;
    private final boolean bonus;

    LottoPrize(int matches, int prize) {
        this(matches, prize, false);
    }

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

    public static LottoPrize findByMatchesAndBonus(int matches, boolean bonus) {
        for (LottoPrize prize : values()) {
            if (prize.getMatches() == matches && prize.isBonus() == bonus) {
                return prize;
            }
        }
        return null;
    }
}
