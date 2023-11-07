package lotto.domain;

public class WinningManager {
    WinningNumbers winningNumbers;
    WinningNumber bonusNumber;

    public WinningManager(WinningNumbers winningNumbers, WinningNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public WinningNumbers getWinningNumbers() {
        return winningNumbers;
    }

    public WinningNumber getBonusNumber() {
        return bonusNumber;
    }
}
