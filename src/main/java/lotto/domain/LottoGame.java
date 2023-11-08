package lotto.domain;

import lotto.data.Messages;

public class LottoGame {
    private final Lotto winningNum;
    private final Integer bonusNum;

    public LottoGame(Lotto winningNum, Integer bonusNum) {
        this.winningNum = winningNum;
        validateBonusNum(bonusNum);
        this.bonusNum = bonusNum;
    }

    private void validateBonusNum(Integer bonusNum) {
        if (bonusNum < 0 || 45 < bonusNum) {
            throw new IllegalArgumentException(Messages.LOTTO_RANGE_ERROR_MESSAGE);
        }
    }

    public Lotto getWinningNum() {
        return winningNum;
    }

    public Integer getBonusNum() {
        return bonusNum;
    }
}
