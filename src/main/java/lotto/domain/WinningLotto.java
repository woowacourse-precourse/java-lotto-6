package lotto.domain;

import java.util.List;
import lotto.config.LottoConfig;
import lotto.exception.BonusNumberDuplicatedException;
import lotto.exception.BonusNumberOutOfRangeException;

public class WinningLotto extends Lotto {

    private Integer bonusNumber;

    private WinningLotto(List<Integer> numbers) {
        super(numbers);
    }

    public static WinningLotto from(List<Integer> numbers) {
        return new WinningLotto(numbers);
    }

    public void addBonusNumber(Integer bonusNumber) {
        validateBonusNumber(bonusNumber);
        if (this.bonusNumber != null) {
            return;
        }
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(Integer bonusNumber) {
        if (bonusNumber < LottoConfig.MIN_LOTTO_NUMBER || bonusNumber > LottoConfig.MAX_LOTTO_NUMBER) {
            throw new BonusNumberOutOfRangeException(bonusNumber);
        }
        if (this.containsNumber(bonusNumber)) {
            throw new BonusNumberDuplicatedException(bonusNumber);
        }
    }
}
