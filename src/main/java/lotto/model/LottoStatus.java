package lotto.model;

public class LottoStatus {
    private int correctNumber;
    private boolean isBonusNumberCorrect;

    public LottoStatus(int correctNumber) {
        this(correctNumber,false);
    }

    public LottoStatus(int correctNumber, boolean isBonusNumberCorrect) {
        this.correctNumber = correctNumber;
        this.isBonusNumberCorrect = isBonusNumberCorrect;
    }

    public int getCorrectNumber() {
        return correctNumber;
    }

    public boolean isBonusNumberCorrect() {
        return isBonusNumberCorrect;
    }

    public static LottoStatus createEmptyStatus() {
        return new LottoStatus(0,false);
    }

    public void update(NumberStatus numberStatus) {
        if (numberStatus.equals(NumberStatus.NOTHING)) {
            return;
        }
        if (numberStatus.equals(NumberStatus.CORRECT)) {
            correctNumber += 1;
            return;
        }
        if (numberStatus.equals(NumberStatus.BONUS)) {
            isBonusNumberCorrect = true;
        }
    }

    public boolean isSameStatus(LottoStatus lottoStatus, boolean isBonusRequired) {
        if (this.correctNumber != lottoStatus.correctNumber) {
            return false;
        }
        if (isBonusRequired) {
            return this.isBonusNumberCorrect == lottoStatus.isBonusNumberCorrect;
        }
        return true;
    }
}
