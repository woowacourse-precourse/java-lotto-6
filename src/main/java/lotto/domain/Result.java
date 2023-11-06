package lotto.domain;

public class Result {

    private final WinningNumbers winningNumbers;
    private final BonusNumber bonusNumber;

    public Result(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        validateWinningNumbersContainBonusNumber(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateWinningNumbersContainBonusNumber(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }

    public boolean winningNumbersContain(int number) {
        return winningNumbers.contains(number);
    }

    public boolean bonusNumberIs(int number) {
        return bonusNumber.is(number);
    }

}
