package lotto.model;

public class WinningNumbers {

    private final Lotto lotto;
    private final Integer bonusNumber;

    public WinningNumbers(Lotto lotto, Integer bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }
}
