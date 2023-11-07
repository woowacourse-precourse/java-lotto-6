package lotto.domain;

public enum LottoRank {
    FIRST(6, false),
    SECOND(5, true),
    THIRD(5, false),
    FOURTH(4, false),
    FIFTH(3, false),
    NONE(0, false);

    private final int matchCount;
    private final boolean matchBonus;

    LottoRank(int matchCount, boolean bonusMatch) {
        this.matchCount = matchCount;
        this.matchBonus = bonusMatch;
    }
    public static LottoRank determineRankByMatchResult(MatchResult matchResult) {
        int matchCount = matchResult.matchCount();
        boolean matchBonus = matchResult.matchBonus();
        if (matchCount!=5 && matchBonus == true){
            matchCount+=1;
            matchBonus=false;
        }
        for (LottoRank rank : values()) {
            if (rank.matchCount == matchCount && (!rank.matchBonus || matchBonus)) {
                return rank;
            }
        }
        return NONE;
    }
    public int getMatchCount() {
        return this.matchCount;
    }
    public boolean isMatchBonus(){
        return this.matchBonus;
    }
}
