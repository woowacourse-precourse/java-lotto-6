package constant;

public enum Reward {
    THREE(3,5000),
    FOUR(4,50000),
    FIVE(5,1500000),
    FIVE_WITH_BONUS(5,30000000),
    SIX(6,2000000000);

    public static final Reward[] REWARDS = values();
    private final int sameCount;
    private final int rewardAmount;

    Reward(int sameCount, int rewardAmount){
        this.sameCount = sameCount;
        this.rewardAmount = rewardAmount;
    }

    public int getSameCount(){
        return sameCount;
    }

    public int getReward(){
        return rewardAmount;
    }
}
