package lotto.domain;

public enum LottoRankRule {

    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    ;

    private int matchingCount;
    private boolean needBonusNumberMatch;
    private int prize;

    LottoRankRule(int matchingCount, boolean needBonusNumberMatch, int prize) {
        this.matchingCount = matchingCount;
        this.needBonusNumberMatch = needBonusNumberMatch;
        this.prize = prize;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public boolean getNeedBonusNumberMatch() {
        return needBonusNumberMatch;
    }

    public int getPrize() {
        return prize;
    }

}
