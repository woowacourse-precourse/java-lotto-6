package lotto.system.shop.domain;

public enum LottoRank {
    FIRST(1, 6, false, 2_000_000_000),
    SECOND(2, 5, true, 30_000_000),
    THIRD(3, 5, false, 1_500_000),
    FOURTH(4, 4, false, 50_000),
    FIFTH(5, 3, false, 5_000),
    MISS_MATCH_TWO(6, 2, false, 0),
    MISS_MATCH_ONE(6, 1, false, 0),
    MISS_ALL(6, 0, false, 0);
    private final Integer ranking;
    private final Integer matchCount;
    private final Boolean matchBonus;
    private final Integer winningMoney;

    LottoRank(Integer ranking, Integer matchCount, Boolean matchBonus, Integer winningMoney) {
        this.ranking = ranking;
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.winningMoney = winningMoney;
    }

    public static LottoRank of(Integer matchCount, Boolean matchBonus) {
        for (LottoRank rank : LottoRank.values()) {
            if (rank.matchCount.equals(matchCount) && rank.matchBonus.equals(matchBonus)) {
                return rank;
            }
        }
        return MISS_ALL;
    }

    public Integer getRanking() {
        return ranking;
    }

    public Integer getMatchCount() {
        return matchCount;
    }

    public Boolean getMatchBonus() {
        return matchBonus;
    }

    public Integer getWinningMoney() {
        return winningMoney;
    }

    public boolean isMiss() {
        return this.ranking.equals(6);
    }

    public int reverseComparator(LottoRank rank) {
        return getReverseComparator(rank);
    }

    private int getReverseComparator(LottoRank rank) {
        return -this.getRanking().compareTo(rank.getRanking());
    }
}
