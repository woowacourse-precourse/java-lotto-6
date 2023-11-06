package lotto.model;

public enum Rank {
    MISS(0, 0, "0개 일치 (0원) - %d개"),
    FIFTH(3, 5_000, "3개 일치 (5,000원) - %d개"),
    FOURTH(4, 50_000, "4개 일치 (50,000원) - %d개"),
    THIRD(5, 1_500_000, "5개 일치 (1,500,000원) - %d개"),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원) - %d개");

    private final int matchCount;
    private final int reward;
    private final String message;

    Rank(int matchCount, int reward, String message) {
        this.matchCount = matchCount;
        this.reward = reward;
        this.message = message;
    }

    public static Rank getRankByLotto(Lotto lotto, WinningLotto winningLotto) {
        int matchCount = lotto.getMatchCount(winningLotto.getWinningLottoNumbers());
        boolean isBonusMatch = lotto.hasBonusNumber(winningLotto.getBonusNumber());
        return getRank(matchCount, isBonusMatch);
    }

    private static Rank getRank(int matchCount, boolean isBonusMatch) {
        if (matchCount == FIRST.matchCount) {
            return FIRST;
        }
        if (matchCount == SECOND.getMatchCount() && isBonusMatch) {
            return SECOND;
        }
        if (matchCount == THIRD.matchCount) {
            return THIRD;
        }
        if (matchCount == FOURTH.matchCount) {
            return FOURTH;
        }
        if (matchCount == FIFTH.matchCount) {
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

    public String getMessage() {
        return message;
    }
}
