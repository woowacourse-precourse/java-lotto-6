package lotto.domain.winning;

import static lotto.error.ErrorMessage.NOT_UNIQUE_BONUS_NUMBER;

import lotto.domain.Lotto;
import lotto.domain.statics.WinningGrade;

public class WinningLotto {

    private final Lotto winningNumbers;
    private final BonusNumber bonusNumber;

    public WinningLotto(
            final Lotto winningNumbers,
            final BonusNumber bonusNumber
    ) {
        validateDuplicatedNumber(winningNumbers, bonusNumber);

        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public WinningGrade matchLotto(final Lotto lotto) {
        final int matchingCount = lotto.getMatchingCount(winningNumbers);
        final boolean bonusMatched = lotto.isBonusMatched(bonusNumber);

        return WinningGrade.getWinningType(matchingCount, bonusMatched);
    }

    private void validateDuplicatedNumber(final Lotto numbers, final BonusNumber bonusNumber) {
        final boolean duplicated = numbers.getNumbers()
                .contains(bonusNumber.getNumber());

        if (duplicated) {
            throw new IllegalArgumentException(NOT_UNIQUE_BONUS_NUMBER.getMessage());
        }
    }

}
