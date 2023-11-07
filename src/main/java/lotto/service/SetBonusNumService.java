package lotto.service;

import static lotto.values.ExceptionMessage.*;
import static lotto.values.LottoInformation.*;
public class SetBonusNumService {
    int bonusNumber;
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
    public int getBonusNumber(){
        return bonusNumber;
    }
}
