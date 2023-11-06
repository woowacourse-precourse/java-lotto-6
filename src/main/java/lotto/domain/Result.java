package lotto.domain;

import lotto.constant.ExceptionMessage;

public class Result {

    private final WinningNumbers winningNumbers;
    private final BonusNumber bonusNumber;

    public Result(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        validateOverlap(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateOverlap(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ExceptionMessage.BONUS_NUMBER_OVERLAPPED_MESSAGE);
        }
    }

    public boolean winningNumbersContain(int number) {
        return winningNumbers.contains(number);
    }

    public boolean bonusNumberIs(int number) {
        return bonusNumber.is(number);
    }

}
