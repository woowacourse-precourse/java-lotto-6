package lotto.domain;

public enum Prize {
    BLANK_ZERO(0,0L,"0"),
    BLANK_ONE(0,0L,"0"),
    BLANK_TWO(0,0L,"0"),
    FIFTH(3,5_000L,"5,000"),
    FORTH(4,50_000L,"50,000"),
    THIRD(5,1_500_000L,"1,500,000"),
    FIRST(6,2_000_000_000L,"2,000,000,000"),
    SECOND(5,30_000_000L,"30,000,000");





    final private int count;
    final private long reward;
    final private String numericCharacters;

    Prize(int count, long reward,String numericCharacters){
        this.count=count;
        this.reward=reward;
        this.numericCharacters=numericCharacters;
    }

    public int getCount() {
        return count;
    }

    public long getReward() {
        return reward;
    }

    public String getNumericCharacters() {
        return numericCharacters;
    }
}
