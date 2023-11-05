package lotto;

public class LottoWinningNumbers {

    private final Lotto winningNumbers;
    private final BonusNumber bonusNumber;

    public LottoWinningNumbers(final Lotto winningNumbers, final BonusNumber bonusNumber) {
        validate(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validate(final Lotto winningNumbers, final BonusNumber bonusNumber) {
        if (hasDuplicates(winningNumbers, bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean hasDuplicates(final Lotto winningNumbers, final BonusNumber bonusNumber) {
        return winningNumbers.contains(bonusNumber.getNumber());
    }

}
