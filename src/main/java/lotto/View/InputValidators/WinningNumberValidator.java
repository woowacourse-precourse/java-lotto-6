package lotto.View.InputValidators;

import lotto.Exceptions.DupeNumbersException;
import lotto.Exceptions.NumberNotInRangeException;
import lotto.Model.Enums.ErrorMessages;
import lotto.Model.Enums.MeaningfulNumbers;
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
            validateNumbersInRange(winningNumber,
                    MeaningfulNumbers.LOTTO_RANGE_MIN.intValue(), MeaningfulNumbers.LOTTO_RANGE_MAX.intValue());
            validateNumbersDupeCheck(winningNumber);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(ErrorMessages.WINNING_NUMBER_FORM.getString());
        }catch (NumberNotInRangeException e){
            throw new IllegalArgumentException(ErrorMessages.LOTTO_NUMBER_RANGE.getString());
        }catch (DupeNumbersException e){
            throw new IllegalArgumentException(ErrorMessages.WINNING_NUMBER_DUPE.getString());
        }
        validatedWinningNumber = winningNumber;
    }
}
