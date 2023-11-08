package lotto;


import static lotto.Constants.*;

public enum ResultCase {
    SIX_CORRECTNESS( 6,2000000000, SIX_CORRECTNESS_CASE),
    FIVE_AND_BONUS_CORRECTNESS(6,30000000, FIVE_AND_BONUS_CORRECTNESS_CASE),
    FIVE_CORRECTNESS( 5,1500000, FIVE_CORRECTNESS_CASE),
    FOUR_CORRECTNESS( 4,50000, FOUR_CORRECTNESS_CASE),
    THREE_CORRECTNESS( 3,5000, THREE_CORRECTNESS_CASE);

    private Integer correctness;
    private Integer price;
    private String comment;

    ResultCase(Integer correctness, Integer price, String comment) {
        this.correctness = correctness;
        this.price = price;
        this.comment = comment;
    }

    public Integer getCorrectness() {
        return this.correctness;
    }

    public Integer getPrice() {
        return this.price;
    }

    public String getComment() {
        return this.comment;
    }
}
