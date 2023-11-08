package lotto.model.lottoResultChecker;



public enum LottoRank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0, false, 0);

    private final int matchCount;
    private final boolean matchBonus;
    private final int winningMoney;

    LottoRank(int matchCount, boolean matchBonus, int winningMoney) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.winningMoney = winningMoney;
    }

    public int getMatchCount() {
        return matchCount;
    }


    public int getWinningMoney() {
        return winningMoney;
    }

    public boolean matches(int count, boolean bonus) {
        if (this == SECOND) {
            return matchCount == count && matchBonus == bonus;
        }
        return matchCount == count;
    }

    public static LottoRank findRank(int matchCount, boolean matchBonus) {
        for (LottoRank rank : LottoRank.values()) {
            if (rank.matches(matchCount, matchBonus)) {
                return rank;
            }
        }
        return NONE;
    }
}
