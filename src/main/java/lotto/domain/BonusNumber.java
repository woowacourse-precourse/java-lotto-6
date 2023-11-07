package lotto.domain;

import static lotto.utils.ErrorMessage.IS_BONUS_NUMBER_DUPLICATED;

public class BonusNumber extends LottoSingleNumber {
    public BonusNumber(int bonusNumber, Lotto winningNumbers) {
        super(bonusNumber);
        isBonusNumberDuplicated(bonusNumber, winningNumbers);
    }

    private void isBonusNumberDuplicated(int number, Lotto winningNumbers) {
        if (winningNumbers.containsNumber(number)) {
            throw new IllegalArgumentException(IS_BONUS_NUMBER_DUPLICATED.getMessage());
        }
    }
}
