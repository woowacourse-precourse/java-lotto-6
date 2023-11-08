package domain;

public class LottoWinningNumbers {
    private final WinningNumbers winningNumbers;
    private final BonusNumber bonusNumber;

    private LottoWinningNumbers(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static LottoWinningNumbers createWinningNumbers(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        validateDuplicateBonusNumber(winningNumbers, bonusNumber);
        return new LottoWinningNumbers(winningNumbers, bonusNumber);
    }

    private static void validateDuplicateBonusNumber(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        bonusNumber.exceptionIfDuplicate(winningNumbers);
    }
}
