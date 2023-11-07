package lotto.vo;

import java.util.List;

public class BonusNumber {
    int bonusNumber;

    public BonusNumber(int bonusNumber){
        this.bonusNumber = bonusNumber;
    }

    public boolean compareLotto(Lotto lotto){
        List<Integer> lottoNumbers = lotto.getNumbers();
        if(lottoNumbers.contains(bonusNumber)) return true;
        return false;
    }
}
