package lotto.global.utils.constant;

public enum WinningPrizeType {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FORTH(4, 50000),
    FIFTH(3, 5000);

    private final int correctCount;
    private final int prizePrice;

    WinningPrizeType(int correctCount, int prizePrice) {
        this.correctCount = correctCount;
        this.prizePrice = prizePrice;
    }

    public int getPrizePrice() {
        return prizePrice;
    }

    public int getCorrectCount() {
        return correctCount;
    }
}
