package lotto.model.domain;

import java.util.List;

public class WinningLottoNumber {
    private List<Integer> winningNumberWithBonusNumber;
    private int bonusNumber;

    public List<Integer> getWinningNumberWithBonusNumber() {
        return winningNumberWithBonusNumber;
    }

    public void setWinningNumberWithBonusNumber(List<Integer> winningNumberWithBonusNumber) {
        this.winningNumberWithBonusNumber = winningNumberWithBonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }
}
