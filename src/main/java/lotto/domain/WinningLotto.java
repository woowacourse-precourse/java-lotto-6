package lotto.domain;

import java.util.List;
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
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(Message.ERROR_LOTTO_NUMBERS_OUT_OF_RANGE.toString());
        }
    }

    private void validateDuplicated(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(Message.ERROR_BONUS_NUMBER_DUPLICATED.toString());
        }
    }

    @Override
    public int match(List<Integer> lottoNumbers) {
        return super.match(lottoNumbers);
    }

    public boolean containBonusNumber(List<Integer> lottoNumbers) {
        return lottoNumbers.contains(bonusNumber);
    }
}
