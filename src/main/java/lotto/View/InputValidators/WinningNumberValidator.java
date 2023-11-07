package lotto.View.InputValidators;

import lotto.Model.Enums.ErrorMessages;

import java.util.List;

public class WinningNumberValidator extends InputValidator{
    private List<Integer> validatedWinningNumber;

    public WinningNumberValidator() throws IllegalArgumentException{
        validateWinningNumber(super.userInput);
    }
    public List<Integer> returnValidatedWinningNumber(){
        return validatedWinningNumber;
    }
    private void validateWinningNumber(String userInputWinningNumber) throws IllegalArgumentException{
        List<Integer> winningNumber;
        try{
            winningNumber = validateStringIsIntegers(userInputWinningNumber);
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException(ErrorMessages.WINNING_NUMBER_FORM.getString());
        }
        validatedWinningNumber = winningNumber;
    }
}
