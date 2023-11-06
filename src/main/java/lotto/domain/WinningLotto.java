package lotto.domain;

import static lotto.exception.ExceptionMessage.LOTTO_NUMBER_OUT_OF_RANGE;
import static lotto.exception.ExceptionMessage.WINNING_NUMBERS_AND_BONUS_NUMBER;
import static lotto.view.NumberConstant.INCREASE_NUMBER;
import static lotto.view.NumberConstant.MAXIMUM_LOTTO_NUMBER;
import static lotto.view.NumberConstant.MINIMUM_LOTTO_NUMBER;

import lotto.exception.LottoGameException;

public class WinningLotto {
    
    private final Lotto winningLotto;
    private final Integer bonusNumber;
    
    private WinningLotto(Lotto winningLotto, Integer bonusNumber) {
        validate(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }
    
    public static WinningLotto of(final Lotto winningNumbers, final Integer bonusNumber) {
        return new WinningLotto(winningNumbers, bonusNumber);
    }
    
    public long countMatchingNumbers(Lotto lotto) {
        long result = countMatchingWinningNumbers(lotto);
        if (containsBonusNumber(lotto)) {
            result += INCREASE_NUMBER;
        }
        return result;
    }
    
    public boolean containsBonusNumber(Lotto lotto) {
        return lotto.contains(bonusNumber);
    }
    
    private long countMatchingWinningNumbers(Lotto lotto) {
        return winningLotto.countMatchingWinningNumbers(lotto);
    }
    
    private void validate(final Lotto winningLotto, final Integer bonusNumber) {
        validateDuplicate(winningLotto, bonusNumber);
        validateRange(bonusNumber);
    }
    
    private void validateDuplicate(final Lotto winningLotto, final Integer bonusNumber) {
        if (hasDuplicate(winningLotto, bonusNumber)) {
            throw LottoGameException.from(WINNING_NUMBERS_AND_BONUS_NUMBER);
        }
    }
    
    private boolean hasDuplicate(final Lotto winningLotto, final Integer bonusNumber) {
        return winningLotto.contains(bonusNumber);
    }
    
    private void validateRange(final Integer bonusNumber) {
        if (notValidateRange(bonusNumber)) {
            throw LottoGameException.from(LOTTO_NUMBER_OUT_OF_RANGE);
        }
    }
    
    private boolean notValidateRange(final Integer bonusNumber) {
        return bonusNumber < MINIMUM_LOTTO_NUMBER || MAXIMUM_LOTTO_NUMBER < bonusNumber;
    }
}
