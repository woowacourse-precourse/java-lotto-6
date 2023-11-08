package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class LottoWinning {
    private Lotto winningNumbers;
    private int bonusNumber;

    public LottoWinning(){}

    public LottoWinning(Lotto winningNumbers, int bonusNumber){
        this.winningNumbers = winningNumbers;
        validate(bonusNumber);
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
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(int bonusNumber){
        if(Objects.nonNull(winningNumbers) && winningNumbers.contains(bonusNumber)){
            throw new IllegalArgumentException();
        }
    }
}
