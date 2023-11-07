package lotto.domain;

public class WinningNumbers {
    private final MainNumbers mainNumbers;
    private final BonusNumber bonusNumber;

    public WinningNumbers(MainNumbers mainNumbers, BonusNumber bonusNumber) {
        this.mainNumbers = mainNumbers;
        this.bonusNumber = bonusNumber;
    }

    public boolean isMainNumber(int number) {
        return mainNumbers.isMainNumber(number);
    }

    public boolean isBonusNumber(int number) {
        return bonusNumber.isBonusNumber(number);
    }

}
