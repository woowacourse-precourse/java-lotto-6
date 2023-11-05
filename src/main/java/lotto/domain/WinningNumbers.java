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
        if (hasDuplicateNumber(winningNumber, bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean hasDuplicateNumber(WinningNumber winningNumber, BonusNumber bonusNumber) {
        return winningNumber.getNumbers().contains(bonusNumber.getNumber());
    }
}
