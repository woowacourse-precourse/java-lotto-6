package lotto;


import static lotto.Constants.*;

public enum ResultCase {
    SIX_CORRECTNESS( FIRST_CORRECTNESS,FIRST_REWARD, SIX_CORRECTNESS_CASE),
    FIVE_AND_BONUS_CORRECTNESS(SECOND_CORRECTNESS,SECOND_REWARD, FIVE_AND_BONUS_CORRECTNESS_CASE),
    FIVE_CORRECTNESS( THIRD_CORRECTNESS,THIRD_REWARD, FIVE_CORRECTNESS_CASE),
    FOUR_CORRECTNESS( FOURTH_CORRECTNESS,FOURTH_REWARD, FOUR_CORRECTNESS_CASE),
    THREE_CORRECTNESS( FIFTH_CORRECTNESS,FIFTH_REWARD, THREE_CORRECTNESS_CASE);

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
