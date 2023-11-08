package lotto;

public enum WinInformation {

    MATCH_ZERO(0, 0L),
    MATCH_ONE(1, 0L),
    MATCH_TWO(2, 0L),
    MATCH_THREE_RANK_FIFTH(3, 5000L),
    MATCH_FOUR_RANK_FOURTH(4, 50000L),
    MATCH_FIVE_NO_BONUS_RANK_THIRD(5, 1500000L),
    MATCH_FIVE_YES_BONUS_RANK_SECOND(6, 30000000L),
    MATCH_SIX_RANK_FIRST(6, 2000000000L);

    private int matchCount;
    private long winMoney;

    WinInformation(int matchCount, long winMoney) {
        this.matchCount = matchCount;
        this.winMoney = winMoney;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long getWinMoney() {
        return winMoney;
    }

}
