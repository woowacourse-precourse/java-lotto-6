package lotto.model;

import java.util.List;

public class PrizeNumbers {
    private Lotto winningNumbers;
    private LottoNumber bonusNumber;

    public PrizeNumbers(List<Integer> winningNumbers){
        this.winningNumbers = new Lotto(winningNumbers);
    }

    public void setBonusNumber(Integer bonusNumber){
        validateDuplication(bonusNumber);
        this.bonusNumber = new LottoNumber(bonusNumber);

    }

    public void validateDuplication(Integer bonusNumber){
        if(winningNumbers.contains(bonusNumber)){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨번호와 중복되지 않아야 한다.");
        }
    }

    
}
