package lotto.model;

import lotto.exception.LottoException;

public class ResultLotto {

    private final Lotto winningLotto;
    private final int bonusNum;

    public ResultLotto(Lotto winningLotto, int bonusNum) {
        this.winningLotto = winningLotto;
        validateRange(bonusNum);
        this.bonusNum = bonusNum;
    }

    private void validateRange(int bonusNum) {
        if (bonusNum < 0 || bonusNum > 45) {
            throw new IllegalArgumentException(LottoException.INVALID_RANGE.getExceptionMessage());
        }
    }
}
