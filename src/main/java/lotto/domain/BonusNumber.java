package lotto.domain;

import lotto.exception.BonusNumberException;
import lotto.util.StringToIntegerConverter;

import java.util.List;

public class BonusNumber {
    private int bonusNum;
    private StringToIntegerConverter stringToIntegerConverter = new StringToIntegerConverter();

    public BonusNumber(String bonusNumber, List<Integer> winnerNum) {
        validate(bonusNumber, winnerNum);
        this.bonusNum = stringToIntegerConverter.stringToInteger(bonusNumber);
    }

    private void validate(String bonusNumber, List<Integer> winnerNum) {
        BonusNumberException bonusNumberException = new BonusNumberException(bonusNumber, winnerNum);
    }

    public int getBonusNumber(){
        return bonusNum;
    }

}
