package lotto;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    private final int matchCount;
    private final int prize;
    private final boolean bonusMatch;

    Rank(int matchCount, int prize) {
        this(matchCount, prize, false);
    }

    Rank(int matchCount, int prize, boolean bonusMatch) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.bonusMatch = bonusMatch;
    }

    public static Rank calculateRank(Lotto userLotto, Lotto winningLotto, int bonusNumber) {
        int matchCount = (int) userLotto.getNumbers().stream()
                                        .filter(winningLotto.getNumbers()::contains)
                                        .count();
        boolean bonusMatch = userLotto.getNumbers().contains(bonusNumber);
        
        // Special handling for the second prize
        if (matchCount == 5 && bonusMatch) {
            return SECOND;
        }

        for (Rank rank : values()) {
            if (matchCount == rank.matchCount && (!rank.bonusMatch || bonusMatch)) {
                return rank;
            }
        }

        return NONE;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }
    
    public boolean isBonusMatch() {
        return bonusMatch;
    }
}
