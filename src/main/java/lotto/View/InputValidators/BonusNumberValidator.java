package lotto.View.InputValidators;

import lotto.Exceptions.DupeNumbersException;
import lotto.Model.Enums.ErrorMessages;

import java.util.List;

public class BonusNumberValidator extends InputValidator{
    private int validatedBonusNumber;
    private List<Integer> winningNumber;

    public BonusNumberValidator(List<Integer> winningNumber) throws IllegalArgumentException{
        this.winningNumber = winningNumber;
        validateBonusNumber(super.userInput);
    }

    public int returnValidatedBonusNumber(){
        return validatedBonusNumber;
    }
    private void validateBonusNumber(String userInputBonusNumber) throws IllegalArgumentException{
        int bonusNumber;
        try{
            bonusNumber = validateStringIsInt(userInputBonusNumber);
            winningNumber.add(bonusNumber);
            validateNumbersDupeCheck(winningNumber);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(ErrorMessages.BONUS_NUMBER_FORM_OR_RANGE.getString());
        }catch (DupeNumbersException e){
            throw new IllegalArgumentException(ErrorMessages.BONUS_NUMBER_DUPE.getString());
        }
        validatedBonusNumber = bonusNumber;
    }
}
