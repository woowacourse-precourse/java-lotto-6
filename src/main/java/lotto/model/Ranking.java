package lotto.model;

public enum Ranking {

    ZERO(0,0),
    ONE(0,0),
    TWO(0,0),
    THREE(3,5000),
    FOUR(4,50000),
    FIVE(5,1500000),
    FIVE_BONUS(5,30000000),
    SIXTH(6,200000000);

    private int count;
    private int reward;

    Ranking(int count, int reward){
        this.count = count;
        this.reward = reward;
    }

    public int getCount(){
        return count;
    }

    public int getReward(){
        return reward;
    }

}
