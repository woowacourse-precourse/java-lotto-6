package lotto.model;

public enum Ranking {

    ZERO(0,0,"0"),
    ONE(0,0,"0"),
    TWO(0,0,"0"),
    THREE(3,5000,"5,000"),
    FOUR(4,50000,"50,000"),
    FIVE(5,1500000,"1,500,000"),
    FIVE_BONUS(5,30000000,"30,000,000"),
    SIXTH(6,2000000000,"2,000,000,000");

    final private int count;
    final private int reward;
    final private String stringReward;

    Ranking(int count, int reward,String stringReward){
        this.count = count;
        this.reward = reward;
        this.stringReward = stringReward;
    }

    public int getCount(){
        return count;
    }

    public int getReward(){
        return reward;
    }

    public String getStringReward(){
        return stringReward;
    }

}
