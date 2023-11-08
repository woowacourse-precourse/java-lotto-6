package lotto.validator.input;

import lotto.view.message.exception.BudgetInputErrorMessage;
import lotto.view.message.exception.WinningCombinationInputErrorMessage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {
    public void validateInputBudgetIsNumber(String budget){
        if(!isNumber(budget)){
            BudgetInputErrorMessage.NOT_NUMBER.displayMessage();
            throw new IllegalArgumentException(BudgetInputErrorMessage.NOT_NUMBER.getMessage());
        }
    }
    public void validateInputBonusNumber(String bonusNumber){
        if(!isNumber(bonusNumber)){
            WinningCombinationInputErrorMessage.NOT_NUMBER_BONUS_NUMBER.displayMessage();
            throw new IllegalArgumentException(WinningCombinationInputErrorMessage.NOT_NUMBER_BONUS_NUMBER.getMessage());
        }
    }

    public void validateInputWinningNumbers(String winningNumbers){
        if(isWrongInputWinningNumbers(winningNumbers)){
            WinningCombinationInputErrorMessage.INCORRECT_FORMET_WINNING_NUMBERS.displayMessage();
            throw new IllegalArgumentException(WinningCombinationInputErrorMessage.INCORRECT_FORMET_WINNING_NUMBERS.getMessage());
        }
    }

    public boolean isWrongInputWinningNumbers(String winningNumbers){
        return !isNumberWithComma(winningNumbers) || isWrongSyntaxCommaWinningNumbers(winningNumbers);
    }

    private boolean isNumber(String budget){
        return !(budget.isEmpty() || !budget.matches("^[0-9]*$"));
    }

    private boolean isNumberWithComma(String winningNumbers){
        return  !winningNumbers.isEmpty() && winningNumbers.matches("^[0-9,]*$");
    }

    private boolean isWrongSyntaxCommaWinningNumbers(String winningNumbers){
        Pattern pattern = Pattern.compile("^,|,,|,$");
        Matcher matcher = pattern.matcher(winningNumbers);
        return matcher.find();
    }
}
