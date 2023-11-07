package domain;

import java.util.List;

public class WinningLotto {
    private Lotto lotto;
    private BonusNumber bonusNumber;

    public WinningLotto() {

    }

    WinningLotto(List<Integer> numbers, int bonusNumber) {
        this.lotto = new Lotto(numbers);
        this.bonusNumber = new BonusNumber(lotto, bonusNumber);
    }

    public boolean contains(int number) {
        return lotto.contains(number);
    }

    public int getBonusNumber() {
        return bonusNumber.getBonusNumber();
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = new BonusNumber(lotto, bonusNumber);
    }

    public void setWinningNumber(List<Integer> winningNumber) {
        this.lotto = new Lotto(winningNumber);
    }
}
