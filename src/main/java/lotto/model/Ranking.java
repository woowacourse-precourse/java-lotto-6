package lotto.model;

public enum Ranking {

    ONE,
    TWO,
    THREE,
    FOUR,
    FIVE,
    FIVE_BONUS,
    SIXTH;

    private int count;
    private int reward;

    public int getCount(){
        return count;
    }

    public int getReward(){
        return reward;
    }

}
