package lotto.domain.lotto;

import java.util.List;
import lotto.validator.domain.BonusNumberValidator;

public class WinningLotto {

    private final Lotto lotto;
    private final int bonusNumber;

    private WinningLotto(final Lotto lotto, final int bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto createFrom(final List<Integer> winningNumbers, final int bonusNumber) {
        Lotto lotto = Lotto.createFrom(winningNumbers);
        BonusNumberValidator.validateBonusNumber(lotto, bonusNumber);
        return new WinningLotto(lotto, bonusNumber);
    }

    public LottoRewardCondition findCompareResult(final Lotto compareLotto) {
        int sameNumberCount = lotto.extractSameCount(compareLotto);
        boolean hasBonusNumber = compareLotto.contains(bonusNumber);
        return LottoRewardCondition.findLottoReward(sameNumberCount, hasBonusNumber);
    }
}
