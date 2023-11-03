package lotto;

import java.util.Arrays;

public enum Statistic {
    CORRECT_THREE(3, 5000),
    CORRECT_FOUR(4, 50_000),
    CORRECT_FIVE(5, 1_500_000),
    CORRECT_FIVE_WITH_BONUS(5, 3_000_000),
    CORRECT_SIX(6, 2_000_000_000);

    private int correctCount;
    private int prize;

    Statistic(int correctNum, int prize) {
        this.correctCount = correctNum;
        this.prize = prize;
    }

    public Statistic getResult(int correctCount){
        return Arrays.stream(values())
                .filter(s -> s.correctCount == correctCount)
                .findFirst()
                .orElseThrow();
    }

    public int getCorrectCount() {
        return correctCount;
    }
    public int getPrize() {
        return prize;
    }

}
