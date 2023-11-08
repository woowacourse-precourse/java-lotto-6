package lotto.domain;

import static lotto.constants.LottoRank.SECOND;
import static lotto.constants.LottoRank.THIRD;

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

    public boolean isSecondWinner() {
        return isBonusCorrect && correctCount == SECOND.getCorrectCount();
    }

    public boolean isThirdWinner() {
        return !isBonusCorrect && correctCount == THIRD.getCorrectCount();
    }

    public boolean isBonusCorrect() {
        return isBonusCorrect;
    }
}
