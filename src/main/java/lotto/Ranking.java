package lotto;

public enum Ranking {
    FIRST_PRIZE(1,6,  "2,000,000,000원"),
    SECOND_PRIZE(2, 5,  "30,000,000원"),
    THIRD_PRIZE(3, 5,  "1,500,000원"),
    FOURTH_PRIZE(4, 4,  "50,000원"),
    FIFTH_PRIZE(5, 3,  "5,000원"),
    FAILURE(0, 0, "0원");

    private final int rank;
    private final int sameNumberCount;
    private final String profit;


    Ranking(int rank, int sameNumberCount, String profit){
        this.rank = rank;
        this.sameNumberCount = sameNumberCount;
        this.profit = profit;
    }

    public int getSameNumberCount(){
        return sameNumberCount;
    }
}
