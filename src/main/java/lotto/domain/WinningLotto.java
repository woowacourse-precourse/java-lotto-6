package lotto.domain;

import java.util.List;
import lotto.domain.wrapper.LottoNumber;
import lotto.utils.ErrorMessage;

public class WinningLotto{
    private Lotto winningLotto;
    private LottoNumber bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        validateNumbersContainingBonusNumber(numbers, bonusNumber);
        winningLotto = new Lotto(numbers);
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    private void validateNumbersContainingBonusNumber(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(
                    ErrorMessage.WINNING_NUMBERS_CONTAINS_BONUS_NUMBER.getMessage());
        }
    }

    public int getSameNumber(Lotto lotto) {
        return lotto.getSameCount(winningLotto);
    }

    public boolean hasBonusNumber(Lotto lotto) {
        return lotto.hasBonusNumber(bonusNumber);
    }
}
