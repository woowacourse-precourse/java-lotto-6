package lotto.domain;

import lotto.exception.RangeLottoNumberException;

import java.util.List;

import static lotto.domain.Constant.MAX_RANGE;
import static lotto.domain.Constant.MIN_RANGE;

public class WonLotto extends Lotto{
    private final int bonusNumber;

    public WonLotto(List<Integer> lotto, Integer bonusNumber) {
        super(lotto);
        validateNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public void validateNumber(Integer bonusNumber) {
        validateRange(bonusNumber);
        validateRange(bonusNumber);
    }

    public void validateRange(Integer number) {
        if (!(MIN_RANGE <= number && number <= MAX_RANGE)) {
            throw new RangeLottoNumberException();
        }
    }

    public Rank calculateRank(Lotto userLotto) {
        int sameNumberCount = super.countSameNumber(userLotto);
        boolean isBonus = hasBonusNumber(userLotto);
        return Rank.getRank(sameNumberCount, isBonus);
    }

    public boolean hasBonusNumber(Lotto userLotto) {
        return userLotto.hasNumber(bonusNumber);
    }
}

