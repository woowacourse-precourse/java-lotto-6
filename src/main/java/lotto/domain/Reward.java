package lotto.domain;

public enum Reward {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    FAIL(0, 0);

    private final int matchCount;
    private final int prize;

    Reward(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public Reward getReward(int matchCount, boolean matchBonus) {
        if(matchCount == FIRST.matchCount){
            return FIRST;
        }
        if(matchCount == SECOND.matchCount && matchBonus){
            return SECOND;
        }
        if (matchCount == THIRD.matchCount && !matchBonus) {
            return THIRD;
        }
        if(matchCount == FOURTH.matchCount){
            return FOURTH;
        }
        if(matchCount == FIFTH.matchCount){
            return FIFTH;
        }
        return FAIL;
    }

    public int getPrize() {
        return prize;
    }
    public int getMatchCount(){
        return matchCount;
    }

}
