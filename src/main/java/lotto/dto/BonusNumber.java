package lotto.dto;

import lotto.exception.LottoGameException;
import lotto.utils.Parser;

import static lotto.validator.LottoValidator.*;

public class BonusNumber {
    private int bonusNumber;

    private BonusNumber(String userInput) throws LottoGameException {
        validateNullValue(userInput);
        this.bonusNumber = Parser.parseStringToInt(userInput);
        validInRangeNumber(bonusNumber);
    }

    public static BonusNumber create(String userInput) throws LottoGameException {
        return new BonusNumber(userInput);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
