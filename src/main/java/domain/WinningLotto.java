package domain;

import util.LottoRandomUtil;

import java.util.List;

public class WinningLotto {
    public int bonusNumber;
    private Lotto lotto;

    public WinningLotto() {

    }

    WinningLotto(List<Integer> numbers, int bonusNumber) {
        this.lotto = new Lotto(numbers);
        this.bonusNumber = bonusNumber;
    }

    public boolean contains(int number) {
        return lotto.contains(number);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public void setWinningNumber(List<Integer> winningNumber) {
        this.lotto = new Lotto(winningNumber);
    }
}
