package lotto.domain;

public final class WinningCombination {

    private final WinningNumbers winningNumbers;
    private final BonusNumber bonusNumber;

    public WinningCombination(final WinningNumbers winningNumbers, final BonusNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }
}
