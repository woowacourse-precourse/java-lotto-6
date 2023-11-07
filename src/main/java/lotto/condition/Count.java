package lotto.condition;

public enum Count {
    THREE("3개 일치"),
    FOUR("4개 일치"),
    FIVE("5개 일치"),
    FIVE_AND_BONUS("5개 일치, 보너스 볼 일치"),
    SIX("6개 일치");

    private final String correctCount;

    Count(final String correctCount) {
        this.correctCount = correctCount;
    }

    public String getCorrectCount() {
        return correctCount;
    }
}
