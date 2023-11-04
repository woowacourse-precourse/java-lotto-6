package lotto.domain;

public class WinningNumber {
    private Lotto lotto;
    private int bonusNumber;

    public WinningNumber(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public Lotto getWinningNumber() {
        return lotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
