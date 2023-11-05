package lotto.domain;

import java.util.List;

public class WinningLotto {
    private final Lotto winningLottoNumbers;
    private final int bonusNumber;
    private final static int INIT = 0;

    public WinningLotto(Lotto winningNumbers, int bonusNumber) {
        this.winningLottoNumbers = winningNumbers;
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public int getScore(List<Integer> myLottoNumber) {
        int sameCount = winningLottoNumbers.getSameNumberCount(myLottoNumber);
        return calculateScore(myLottoNumber, sameCount);
    }

    private void validate(int bonusNumber){
        winningLottoNumbers.validateBonusNumber(bonusNumber);
    }

    private int calculateScore(List<Integer> myLottoNumber, int sameCount) {
        int score = sameCount;

        if (hasBonusNumber(myLottoNumber) && score == 5 || score == 6) {
            score++;
        }

        return score;
    }

    private Boolean hasBonusNumber(List<Integer> myLottoNumber) {
        if (myLottoNumber.contains(bonusNumber)) {//보너스 볼 일치
            return true;
        }

        return false;
    }
}
