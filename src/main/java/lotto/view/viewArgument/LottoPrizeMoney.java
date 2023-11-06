package lotto.view.viewArgument;

public enum LottoPrizeMoney {
    FIRST_GRADE("6", 2000000000),
    SECOND_GRADE("5 + bonus", 30000000),
    THIRD_GRADE("5", 1500000),
    FOURTH_GRADE("4", 50000),
    FIFTH_GRADE("3", 5000);

    private final String correctCount;
    private final int prizeMoney;

    private LottoPrizeMoney(String correctCount, int prizeMoney) {
        this.correctCount = correctCount;
        this.prizeMoney = prizeMoney;
    }
    public String getCorrectCount() {
        return correctCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
