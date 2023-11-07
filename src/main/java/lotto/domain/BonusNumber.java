package lotto.domain;

import static lotto.utils.ErrorMessages.BONUS_NUMBER_DUPLICATE;

public class BonusNumber {
    private final LottoNumber bonusNumber;

    public BonusNumber(int number, WinningNumbers winningNumbers) {
        this.bonusNumber = new LottoNumber(number);
        validateDuplicate(winningNumbers);
    }

    private void validateDuplicate(WinningNumbers winningNumbers2) {
        if (winningNumbers2.isContain(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATE);
        }
    }

    public boolean isEquals(LottoNumber lottoNumber) {
        return bonusNumber.equals(lottoNumber);
    }
}
