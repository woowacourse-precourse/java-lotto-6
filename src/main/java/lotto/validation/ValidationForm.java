package lotto.validation;

import lotto.property.ValidationProperty;

import static lotto.property.ValidationProperty.*;
import static lotto.validation.validator.CostValidator.costFormatIsCorrect;
import static lotto.validation.validator.CostValidator.costIsStandardUnder;
import static lotto.validation.validator.WinningValidator.*;


public class ValidationForm {

    public static void verifyFormatForInputValue(ValidationProperty validatorType, String inputValue) {
        if (validatorType.equals(WINNING)) {
            verifyForWinningNumber(inputValue);
        }
        if (validatorType.equals(WINNINGS)) {
            verifyForWinningNumbers(inputValue);
        }
        if (validatorType.equals(COST)) {
            verifyForPurchaseCost(inputValue);
        }
        if (validatorType.equals(BONUS)) {
            verifyForBonusNumber(inputValue);
        }
    }

    static void verifyForWinningNumbers(String winningNumbers) {
        winningsFormatIsCorrect(winningNumbers);
        winningsCountIsOverOrUnder(winningNumbers);
        winningsIsDuplicate(winningNumbers);
    }

    static void verifyForWinningNumber(String winningNumber) {
        valueIsEmpty(winningNumber);
        valueContainsSpace(winningNumber);
        valueIsNumeric(winningNumber);
        valueIsCorrectRange(winningNumber);
    }

    static void verifyForBonusNumber(String bonusNumber) {
        valueIsEmpty(bonusNumber);
        valueContainsSpace(bonusNumber);
        valueIsNumeric(bonusNumber);
        valueIsCorrectRange(bonusNumber);
    }

    static void verifyForPurchaseCost(String purchaseCost) {
        valueIsEmpty(purchaseCost);
        valueContainsSpace(purchaseCost);
        valueIsNumeric(purchaseCost);
        costIsStandardUnder(purchaseCost);
        costFormatIsCorrect(purchaseCost);
    }
}
