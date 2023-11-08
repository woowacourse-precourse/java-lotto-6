package lotto;

public enum RESULT {
    THREE_STRIKE(5000), FOUR_STRIKE(50000), FIVE_STRIKE(1500000)
    , FIVE_STRIKE_AND_BONUS(30000000), SIX_STRIKE(2000000000), NONE(0);

    private int profit;

    RESULT(int profit) {
        this.profit = profit;
    }
}
