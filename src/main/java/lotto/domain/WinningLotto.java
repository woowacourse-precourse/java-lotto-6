package lotto.domain;

import java.util.List;
import lotto.constant.Constant;
import lotto.constant.Message;

public class WinningLotto extends Lotto {
    private final int bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        super(winningNumbers);
        validateBonusNumberRange(bonusNumber);
        validateDuplicated(winningNumbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumberRange(int bonusNumber) {
        if (bonusNumber < Constant.MINIMUM_LOTTO_NUMBER.getValue()
                || bonusNumber > Constant.MAXIMUM_LOTTO_NUMBER.getValue()) {
            throw new IllegalArgumentException(Message.ERROR_LOTTO_NUMBERS_OUT_OF_RANGE.getMessage());
        }
    }

    private void validateDuplicated(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(Message.ERROR_BONUS_NUMBER_DUPLICATED.getMessage());
        }
    }

    @Override
    public int match(List<Integer> lottoNumbers) {
        return super.match(lottoNumbers);
    }

    public boolean containsBonusNumber(List<Integer> lottoNumbers) {
        return lottoNumbers.contains(bonusNumber);
    }
}
