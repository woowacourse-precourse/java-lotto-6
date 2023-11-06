package dto;

public class LottoCostRequst {
    public static final int LOTTOT_COST = 1000;
    private final int cost;

    public LottoCostRequst(int cost){
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }
}
