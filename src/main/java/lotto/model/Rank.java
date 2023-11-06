package lotto.model;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private final int matchCount;
    private final int reward;

    Rank(int matchCount, int reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public static Rank getRankByLotto(Lotto lotto, WinningLotto winningLotto) {
        int matchCount = lotto.getMatchCount(winningLotto.getWinningLottoNumbers());
        boolean isBonusMatch = lotto.hasBonusNumber(winningLotto.getBonusNumber());
        return getRank(matchCount, isBonusMatch);
    }

    private static Rank getRank(int matchCount, boolean isBonusMatch) {
        if (matchCount == 6) {
            return FIRST;
        }
        if (matchCount == 5 && isBonusMatch) {
            return SECOND;
        }
        if (matchCount == 5) {
            return THIRD;
        }
        if (matchCount == 4) {
            return FOURTH;
        }
        if (matchCount == 3) {
            return FIFTH;
        }
        return MISS;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getReward() {
        return reward;
    }
}
