package lotto;


import static lotto.Constants.*;

public enum ResultCase {
    SIX_CORRECTNESS( 6,2000000000, SIX_CORRECTNESS_CASE),
    FIVE_AND_BONUS_CORRECTNESS(6,30000000, FIVE_AND_BONUS_CORRECTNESS_CASE),
    FIVE_CORRECTNESS( 5,1500000, FIVE_CORRECTNESS_CASE),
    FOUR_CORRECTNESS( 4,50000, FOUR_CORRECTNESS_CASE),
    THREE_CORRECTNESS( 3,5000, THREE_CORRECTNESS_CASE);

    private int correctness;
    private int price;
    private String inform;

    ResultCase(int correctness, int price, String inform) {
        this.correctness = correctness;
        this.price = price;
        this.inform = inform;
    }

    public int getCorrectness() {
        return this.correctness;
    }

    public int getPrice() {
        return this.price;
    }

    public String getInform() {
        return this.inform;
    }
}
