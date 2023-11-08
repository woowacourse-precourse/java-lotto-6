package lotto.domain;

import lotto.exception.InvalidInput;


public class WinningLotto {
    private static final int FIRST_SCORE = 6;
    private static final int SECOND_SCORE = 5;
    private final Lotto winningLottoNumbers;
    private final int bonusNumber;

    public WinningLotto(Lotto winningNumbers, int bonusNumber) {
        this.winningLottoNumbers = winningNumbers;
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public int getScore(Lotto myLotto) {
        int sameCount = winningLottoNumbers.getSameNumberCount(myLotto);
        return calculateScore(myLotto, sameCount);
    }

    private int calculateScore(Lotto myLotto, int sameCount) {
        int score = sameCount;

        if (myLotto.checkContainsSameNumber(bonusNumber) && score == SECOND_SCORE || score == FIRST_SCORE) {
            score++;
        }

        return score;
    }

    private void validate(int bonusNumber) {
        InvalidInput invalidInput = new InvalidInput();

        if (invalidInput.outOfRangeNumberException(bonusNumber)) {
            throw new IllegalArgumentException();
        } else if (invalidInput.duplicateNumberException(winningLottoNumbers, bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }

}
