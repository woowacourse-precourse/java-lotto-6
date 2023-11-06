package lotto;

public enum MatchNums {
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    SIX(6, 2_000_000_000),
    FIVE_AND_BONUS(55, 30_000_000);

    private final int num;
    private final int cost;

    MatchNums(int num, int cost){
        this.num = num;
        this.cost = cost;
    }

    public int getNum(){
        return num;
    }

    public int getCost(){
        return cost;
    }

}
