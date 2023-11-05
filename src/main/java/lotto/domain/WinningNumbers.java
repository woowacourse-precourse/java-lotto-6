package lotto.domain;

public class WinningNumbers {
    private final WinningNumber winningNumber;
    private final BonusNumber bonusNumber;

    public WinningNumbers(WinningNumber winningNumber, BonusNumber bonusNumber) {
        validate(winningNumber, bonusNumber);
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    private void validate(WinningNumber winningNumber, BonusNumber bonusNumber) {
        if (winningNumber.getNumbers().contains(bonusNumber.getNumber())) {
            throw new IllegalArgumentException();
        }
    }
}
