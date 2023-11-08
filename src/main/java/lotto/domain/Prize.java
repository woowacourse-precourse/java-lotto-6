package lotto.domain;

public class Prize {
    private final int prizeCriteria;
    private final long prizeAmount;
    private int matchedCount;

    public Prize(int match, long prizeAmount){
        this.prizeCriteria = match;
        this.prizeAmount = prizeAmount;
        this.matchedCount = 0;
    }

    public int getPrizeCriteria() {
        return prizeCriteria;
    }

    public long getPrizeAmount() {
        return prizeAmount;
    }

    public int getMatchedCount() {
        return matchedCount;
    }

    public void increaseMatchedCount(){
        this.matchedCount++;
    }
}
