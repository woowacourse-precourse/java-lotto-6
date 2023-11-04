package lotto.validation;

import lotto.property.ValidationProperty;

import static lotto.property.ValidationProperty.*;
import static lotto.validation.validator.WinningValidator.*;

public class ValidationForm {

    public static void verifyFormatForInputValue(ValidationProperty validatorType,String inputValue){
        if (validatorType.equals(WINNING)){
            verifyForWinningNumber(inputValue);
        }
        if (validatorType.equals(WINNINGS)){
            verifyForWinningNumbers(inputValue);
        }
    }

    static void verifyForWinningNumbers(String winningNumbers){
        winningsFormatIsCorrect(winningNumbers);
        winningsCountIsOverOrUnder(winningNumbers);
    }
    static void verifyForWinningNumber(String winningNumber){
        valueIsEmpty(winningNumber);
        valueContainsSpace(winningNumber);
        valueIsNumeric(winningNumber);
        winningOrBonusIsCorrectRange(winningNumber);
    }

}
