package lotto.domain;

import java.util.List;

public class LottoWinning {
    private Lotto winningNumbers;
    private int bonusNumber;

    public LottoWinning(Lotto winningNumbers, int bonusNumber){
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getNumbers(){
        return winningNumbers.numbers();
    }

    public int getBonusNumber(){
        return bonusNumber;
    }
}
