package lotto;

public enum Ranking {
    FIRST_PRIZE(1,6,  2_000_000_000),
    SECOND_PRIZE(2, 5,  30_000_000),
    THIRD_PRIZE(3, 5,  1_500_000),
    FOURTH_PRIZE(4, 4,  50_000),
    FIFTH_PRIZE(5, 3,  5_000),
    FAILURE(0, 0, 0);

    private final int rank;
    private final int sameNumberCount;
    private final int profit;

    Ranking(int rank, int sameNumberCount, int profit){
        this.rank = rank;
        this.sameNumberCount = sameNumberCount;
        this.profit = profit;
    }

    public int getSameNumberCount(){
        return sameNumberCount;
    }

    public int getRank(){
        return rank;
    }

    public int getProfit(){
        return profit;
    }
}
