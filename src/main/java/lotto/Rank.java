package lotto;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    NONE(0, 0);

    private final int matchCount;
    private final int prize;

    Rank(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static Rank findRank(Lotto userLotto, Lotto winningLotto, int bonusNumber) {
        int matchCount = (int) userLotto.getNumbers().stream()
                                        .filter(winningLotto.getNumbers()::contains)
                                        .count();
        boolean bonusMatch = userLotto.getNumbers().contains(bonusNumber);
        if (matchCount == 6) return FIRST;
        if (matchCount == 5 && bonusMatch) return SECOND;
        if (matchCount == 5) return THIRD;
        if (matchCount == 4) return FOURTH;
        if (matchCount == 3) return FIFTH;
        return NONE;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }
}