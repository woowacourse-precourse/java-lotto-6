package lotto;

public enum MatchNumber {
    NONE(0,0),
    THREE(3,5000),
    FOUR(4,50000),
    FIVE(5,1500000),
    SIX(6,2000000000),
    FIVE_WITH_BONUS(5,30000000);

    private final int matchCount;
    private final int prize;

    MatchNumber(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }
    public static MatchNumber valueOf(int matchNumberCount,boolean bonusMatch) {
        if(matchNumberCount==5&& bonusMatch){
            return FIVE_WITH_BONUS;
        }
        for (MatchNumber value : MatchNumber.values()) {
            if (value.matchCount == matchNumberCount) {
                return value;
            }
        }
        return NONE;
    }
}
