package lotto.domain;

import static lotto.constant.LottoConstant.MAX_LOTTO_NUMBER;
import static lotto.constant.LottoConstant.MIN_LOTTO_NUMBER;

import lotto.exception.ExceptionMessage;

public class WinningLotto {
    private final Lotto lotto;
    private final int bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        validateRange(bonusNumber);
        validateDuplicationBonusNumber(lotto, bonusNumber);

        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public Rank calcuateWinningRank(Lotto purchaseLotto) {
        int matchingNumberCount = purchaseLotto.getMatchingNumberCount(this.lotto);
        boolean isMatchBonusNumber = purchaseLotto.isContainBonusNumber(this.bonusNumber);

        return Rank.findRankBy(matchingNumberCount, isMatchBonusNumber);
    }

    private void validateRange(int bonusNumber) {
        if (bonusNumber < MIN_LOTTO_NUMBER || bonusNumber > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_RANGE_LOTTO_NUMBER.getDesc());
        }
    }

    private void validateDuplicationBonusNumber(Lotto lotto, int bonusNumber) {
        if (lotto.isContainBonusNumber(bonusNumber)) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATION_BONUS_NUMBER.getDesc());
        }
    }

}
