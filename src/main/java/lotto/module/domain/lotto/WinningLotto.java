package lotto.module.domain.lotto;

import lotto.global.exception.LottoException;

import java.util.List;

public class WinningLotto extends Lotto {
    private final int bonusNumber;

    private WinningLotto(final List<Integer> numbers, final int bonusNumber) {
        super(numbers);
        validateBonusNumberDuplicate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(final List<Integer> numbers, final int bonusNumber) {
        return new WinningLotto(numbers, bonusNumber);
    }

    public List<Integer> getNumbers() {
        return super.getNumbers();
    }

    public boolean isMatchesBonusNumber(Lotto lotto) {
        return lotto.contains(bonusNumber);
    }

    public int valuesContains(Lotto lotto) {
        return super.valuesContains(lotto);
    }

    private void validateBonusNumberDuplicate(final int bonusNumber) {
        if (super.contains(bonusNumber)) {
            throw new IllegalArgumentException(LottoException.LOTTO_BONUS_NUMBER_DUPLICATE_VALIDATION.getDefaultMessage());
        }
    }

}
