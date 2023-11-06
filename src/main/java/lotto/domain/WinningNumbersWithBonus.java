package lotto.domain;

public class WinningNumbersWithBonus {
    private final Lotto winningNumbers;
    private final Ball bonusNumber;

    private WinningNumbersWithBonus(Lotto winningNumbers, Ball bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinningNumbersWithBonus createManual() {
        return new WinningNumbersWithBonus(Lotto.createWinningNumbers(), Ball.createManual());
    }

    public int countMatchingNumbers(Lotto lotto) {
        return lotto.countMatchingNumbers(winningNumbers);
    }

    public boolean containsFrom(Lotto lotto) {
        return lotto.contains(bonusNumber);
    }
}
