package lotto.module.lotto;

import lotto.global.exception.LottoException;

import java.util.List;

public class WinningLotto extends Lotto {
    private final int bonusNumber;

    private WinningLotto(final Lotto lotto, final int bonusNumber) {
        super(lotto.getNumbers());
        validateBonusNumberDuplicate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(final Lotto lotto, final int bonusNumber) {
        return new WinningLotto(lotto, bonusNumber);
    }

    public List<Integer> getNumbers() {
        return super.getNumbers();
    }

    public boolean isMatchesBonusNumber(Lotto lotto) {
        return lotto.contains(bonusNumber);
    }

    public int numbersContains(Lotto lotto) {
        return super.numbersContains(lotto);
    }

    private void validateBonusNumberDuplicate(final int bonusNumber) {
        if (super.contains(bonusNumber)) {
            throw new IllegalArgumentException(LottoException.LOTTO_BONUS_NUMBER_DUPLICATE_VALIDATION.getDefaultMessage());
        }
    }

}
