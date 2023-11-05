package lotto.domain;

public class WinningNumber {
    private final Lotto winningNumbers;
    private final BonusNumber bonusNumber;

    public WinningNumber(Lotto winningNumbers, BonusNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }
}
