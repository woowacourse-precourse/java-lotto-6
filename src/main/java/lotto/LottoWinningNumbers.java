package lotto;

public class LottoWinningNumbers {

    private final Lotto winningNumbers;
    private final BonusNumber bonusNumber;

    public LottoWinningNumbers(final Lotto winningNumbers, final BonusNumber bonusNumber) {
        validate(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Lotto getWinningNumbers() {
        return winningNumbers;
    }

    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }

    private void validate(final Lotto winningNumbers, final BonusNumber bonusNumber) {
        if (hasDuplicates(winningNumbers, bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 당첨번호와 보너스번호가 중복된 값을 가집니다.");
        }
    }

    private boolean hasDuplicates(final Lotto winningNumbers, final BonusNumber bonusNumber) {
        return winningNumbers.contains(bonusNumber.getNumber());
    }

}
