package lotto.model;

import java.util.List;

public class WinningLotto extends Lotto{
    Integer bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, Integer bonusNumber) {
        super(winningNumbers);
        this.bonusNumber = bonusNumber;
    }


    public Lotto getWinningLotto() {
        return this;
    }
    public List<Integer> getWinningNumbers() {
        return getLottoNumbers();
    }
    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
