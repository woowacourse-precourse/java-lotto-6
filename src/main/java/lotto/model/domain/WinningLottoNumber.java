package lotto.model;

import java.util.List;

public class WinningLottoNumber {
    public List<Integer> winningNumberWithBonusNumber;
    public int bonusNumber;

    public WinningLottoNumber(List<Integer> winningNumberWithBonusNumber) {
        this.winningNumberWithBonusNumber = winningNumberWithBonusNumber;
    }
}
