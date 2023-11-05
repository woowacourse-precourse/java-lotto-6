package lotto.domain;

import java.util.List;
import lotto.exception.ExceptionMessage;

public class WinningLotto {
    private final static int MIN_LOTTO_NUMBER = 1;
    private final static int MAX_LOTTO_NUMBER = 45;
    private final Lotto lotto;
    private final int bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        validateRange(bonusNumber);

        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(List<Integer> numbers, int bonusNumber){
        Lotto lotto = LottoGenerator.manualGenerate(numbers);
        return new WinningLotto(lotto, bonusNumber);
    }

    public Rank calcuateWinningRank(Lotto purchaseLotto){
        int matchingNumberCount = purchaseLotto.getMatchingNumberCount(this.lotto);
        boolean isMatchBonusNumber = purchaseLotto.isContainBonusNumber(this.bonusNumber);

        return Rank.findRankBy(matchingNumberCount, isMatchBonusNumber);
    }

    private void validateRange(int bonusNumber) {
        if (bonusNumber < MIN_LOTTO_NUMBER || bonusNumber > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_RANGE_LOTTO_NUMBER.getDesc());
        }
    }

}
