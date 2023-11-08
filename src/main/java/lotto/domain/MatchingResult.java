package lotto.domain;

public class MatchingResult {

    private final int correctCount;
    private final boolean isBonusCorrect;

    public MatchingResult(int correctCount, boolean isBonusCorrect) {
        this.correctCount = correctCount;
        this.isBonusCorrect = isBonusCorrect;
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public boolean isBonusCorrect() {
        return isBonusCorrect;
    }
}
