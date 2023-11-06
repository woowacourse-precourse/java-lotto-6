package lotto.domain;

import static lotto.exception.ExceptionMessage.DUPLICATE_BONUSE_NUMBER;


public class WinningLotto {
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

        if (myLotto.checkContains(bonusNumber) && score == 5 || score == 6) {
            score++;
        }

        return score;
    }

    private void validate(int bonusNumber) {
        if (winningLottoNumbers.checkContains(bonusNumber)) {
            System.out.println(DUPLICATE_BONUSE_NUMBER.getMessage());
            throw new IllegalArgumentException();
        }
    }
}
