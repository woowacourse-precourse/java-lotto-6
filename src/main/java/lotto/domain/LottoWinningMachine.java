package lotto.domain;

import java.util.List;

import static lotto.exception.ExceptionMessage.LottoMachineException.BONUS_NUMBER_MUST_BE_UNIQUE;

public class LottoWinningMachine {
    private final Lotto winningLotto;
    private final BonusNumber bonusNumber;

    private LottoWinningMachine(final Lotto winningLotto, final BonusNumber bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public static LottoWinningMachine drawWinningLotto(final List<Integer> winningNumbers, final int bonusNumber) {
        validateBonusNumberIsDuplicate(winningNumbers, bonusNumber);
        return new LottoWinningMachine(Lotto.create(winningNumbers), BonusNumber.create(bonusNumber));
    }

    private static void validateBonusNumberIsDuplicate(final List<Integer> winningNumbers, final int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_MUST_BE_UNIQUE.message);
        }
    }
}
