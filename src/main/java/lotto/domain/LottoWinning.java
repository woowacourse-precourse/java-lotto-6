package lotto.domain;

import java.util.List;

public class LottoWinning {
    private Lotto winningNumbers;
    private int bonusNumber;

    public LottoWinning(){}

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

    public void setWinningNumbers(Lotto winningNumbers){
        this.winningNumbers = winningNumbers;
    }

    public void setBonusNumber(int bonusNumber){
        this.bonusNumber = bonusNumber;
    }
}
