package lotto.model;

public enum LottoResult {
    NONE(0,0),
    FIFTH(3,5000),
    FOURTH(4,50000),
    THIRD(5,1500000),
    SECOND(5,30000000),
    FIRST(6,2000000000);

    private final int matchCount;
    private final int prize;

    LottoResult(int matchCount,int prize){
        this.matchCount=matchCount;
        this.prize=prize;
    }

    public static LottoResult findRank(int matchCount, boolean hasBonus) {
        if (matchCount == 3) {
            return FIFTH;
        } else if (matchCount == 4) {
            return FOURTH;
        } else if (matchCount == 5 && !hasBonus) {
            return THIRD;
        } else if (matchCount == 5 && hasBonus) {
            return SECOND;
        } else if (matchCount == 6) {
            return FIRST;
        } else {
            return NONE;
        }
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }
}
