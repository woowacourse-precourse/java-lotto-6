package lotto.domain;

public enum Prize {

    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5,1500000),
    FOURTH(4,50000),
    FIFTH(3,5000),
    FAIL(0,0);

    private final Integer matchCount;
    private final Integer winningAmount;

    Prize(Integer matchCount, Integer winningAmount) {
        this.matchCount = matchCount;
        this.winningAmount = winningAmount;
    }

    public static Prize getPrizeByMatchCount(int matchCount){
        for (Prize prize : values()) {
            if(prize.matchCount == matchCount){
                return prize;
            }
        }
        return FAIL;
    }
}
