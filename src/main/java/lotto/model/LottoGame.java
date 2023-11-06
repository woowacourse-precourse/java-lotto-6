package lotto.model;

import java.util.List;

public class LottoGame {
    private int[] winningNumbers;
    private int bonusNumber;

    public LottoGame(int[] winningNumbers, int bonusNumber){
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }
}
