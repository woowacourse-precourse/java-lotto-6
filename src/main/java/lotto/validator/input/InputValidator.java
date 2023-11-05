package lotto.validator.input;

import lotto.view.message.exception.BudgetInputErrorMessage;
import lotto.view.message.exception.WinningCombinationInputErrorMessage;

public class InputValidator {
    public void validateInputBudgetIsNumber(String budget){
        if(!isNumber(budget)){
            throw new IllegalArgumentException(BudgetInputErrorMessage.NOT_NUMBER.getMessage());
        }
    }
    public void validateInputBonusNumber(String bonusNumber){
        if(!isNumber(bonusNumber)){
            throw new IllegalArgumentException(WinningCombinationInputErrorMessage.NOT_NUMBER_BONUS_NUMBER.getMessage());
        }
    }

    public void validateInputWinningNumbers(String winningNumbers){
        if(!isNumberWithComma(winningNumbers)){
            throw new IllegalArgumentException(WinningCombinationInputErrorMessage.INCORRECT_FORMET_WINNING_NUMBERS.getMessage());
        }
    }

    private boolean isNumber(String budget){
        return !(budget.isEmpty() || !budget.matches("^[0-9]*$"));
    }

    private boolean isNumberWithComma(String winningNumbers){
        return  !winningNumbers.isEmpty() && winningNumbers.matches("^[0-9,]*$");
    }

}
