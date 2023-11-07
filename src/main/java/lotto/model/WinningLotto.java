package lotto.model;

import static lotto.error.ErrorMessage.NOT_UNIQUE_BONUS_NUMBER;

import lotto.WinningGrade;

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
        int matchingCount = lotto.getMatchingCount(winningNumbers);
        boolean bonusMatched = lotto.isBonusMatched(bonusNumber);

        return WinningGrade.getWinningType(matchingCount, bonusMatched);
    }

    private void validateDuplicatedNumber(Lotto numbers, BonusNumber bonusNumber) {
        boolean duplicated = numbers.getNumbers()
                .contains(bonusNumber.getNumber());

        if (duplicated) {
            throw new IllegalArgumentException(NOT_UNIQUE_BONUS_NUMBER.getMessage());
        }
    }

}
