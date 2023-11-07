package lotto.domain;

public class WinningNumber {
    private final Lotto winningNumbers;
    private final int bonusNumber;

    public WinningNumber(Lotto winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Lotto getLotto() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
