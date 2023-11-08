package lotto.domain;

public class WinningNumbers {

    private final Lotto mainNumbers;
    private final BonusNumber bonusNumber;

    public WinningNumbers(Lotto mainNumbers, BonusNumber bonusNumber) {
        this.mainNumbers = mainNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Lotto getMainNumbers() {
        return mainNumbers;
    }

    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }

}
