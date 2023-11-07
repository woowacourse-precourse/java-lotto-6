package lotto.vo;

import java.util.List;

import static lotto.values.ExceptionMessage.*;
import static lotto.values.LottoInformation.*;

public class BonusNumber {
    int bonusNumber;

    public BonusNumber(String bonusNumber){
        checkException(bonusNumber);
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    public boolean checkException(String number){
        if(number.length()==0) throw new IllegalArgumentException(NOT_NULL.getMessage());
        if(number.length()!=TOTAL_BONUS_NUMBER.getValue()) throw new IllegalArgumentException(ONLY_ONE_FOR_BONUS_NUMBER.getMessage());
        if(!number.matches(ONLY_NUMBER.getMessage())) throw new IllegalArgumentException(NOT_NUMBER.getMessage());

        int num = Integer.parseInt(number);
        if(num<START_LOTTO_NUMBER.getValue() || num>LAST_LOTTO_NUMBER.getValue())
            throw new IllegalArgumentException(NOT_IN_NUMBER_RANGE.getMessage());

        bonusNumber = num;
        return true;
    }

    public boolean compareLotto(Lotto lotto){
        List<Integer> lottoNumbers = lotto.getNumbers();
        if(lottoNumbers.contains(bonusNumber)) return true;
        return false;
    }
}
