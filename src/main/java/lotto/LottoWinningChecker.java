package lotto;

public class LottoWinningChecker {
    private final int duplicationCounter;
    private final boolean bonusChecker;

    public LottoWinningChecker(int duplicationCounter, boolean bonusChecker) {
        this.duplicationCounter = duplicationCounter;
        this.bonusChecker = bonusChecker;
    }

    public int getDuplicationCounter() {
        return duplicationCounter;
    }

    public boolean getBonusChecker() {
        return bonusChecker;
    }
}