package lotto.domain;


public enum Rank {
    CORRECT_THREE(3, 5000L),
    CORRECT_FOUR(4, 50000L),
    CORRECT_FIVE(5, 1500000L),
    CORRECT_FIVE_BONUS(5, 30000000L),
    CORRECT_SIX(6, 2000000000L);

    private final int correctCount;
    private final Long winningAmount;

    Rank(int correctCount, Long winningAmount) {
        this.correctCount = correctCount;
        this.winningAmount = winningAmount;
    }

}
