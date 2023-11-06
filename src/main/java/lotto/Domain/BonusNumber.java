package lotto.Domain;

import java.util.List;
import lotto.Constants.ExceptionMessage;

public class BonusNumber {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private final int bonusNumber;

    public  BonusNumber(int bonusNumber, List<Integer> winningNumbers){
        this.bonusNumber = bonusNumber;
    }

    private void checkNumberRange(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw ExceptionMessage.INTPUT_NUMBER_LENGTH.throwexception();
        }
    }
}
