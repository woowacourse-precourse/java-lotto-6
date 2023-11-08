package lotto.validate;

import lotto.config.ErrorMessage;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Validator {


    public void validatePurchaseCost(String purchaseCost){
        validate_PositiveInteger(purchaseCost);
        validatePurchaseCost_Multiple1000(Integer.parseInt(purchaseCost));
    }
    public void validatePurchaseCost_Multiple1000(int tmpCost){
        if(tmpCost % 1000 != 0){
            throw new IllegalArgumentException(ErrorMessage.ERROR_PURCHASE_COST_MULTIPLE_1000.getErrorMessage());
        }
    }

    public String validateWinningNumbers(String winningNumber){
        List<String> winningNumberList = validateWinningNumbers_CountNumbers(winningNumber);
        validate_CorrectNumber(winningNumberList);
        return winningNumber;
    }
    public List<String> validateWinningNumbers_CountNumbers(String winningNumber){
        List<String> winningNumberList = Arrays.stream(winningNumber.split(",")).toList();
        if(winningNumberList.size() != 6){
            throw new IllegalArgumentException(ErrorMessage.ERROR_INPUT_WINNER_NUMBER_REGEX.getErrorMessage());
        }
        return winningNumberList;
    }


    public String validateBonusNumber(String bonusNumber){
        List<String> bonusNumberList = validateBonusNumber_CountNumbers(bonusNumber);
        validate_CorrectNumber(bonusNumberList);
        return bonusNumber;
    }
    public List<String> validateBonusNumber_CountNumbers(String bonusNumber){
        List<String> bonusNumberList = Arrays.stream(bonusNumber.split(",")).toList();
        if(bonusNumberList.size() != 1){
            throw new IllegalArgumentException(ErrorMessage.ERROR_BONUS_NUMBER_COUNT.getErrorMessage());
        }
        return bonusNumberList;
    }


    public void validate_PositiveInteger(String purchaseCost){
        if(!purchaseCost.matches("\\d+")){
            throw new NumberFormatException(ErrorMessage.ERROR_PURCHASE_COST_POSITIVE_INTEGER.getErrorMessage());
        }
    }
    public void validate_NumberRange(int number){
        if(number <= 0 | number > 45 ){
            throw new IllegalArgumentException(ErrorMessage.ERROR_NUMBER_RANGE.getErrorMessage());
        }
    }
    public void validate_CorrectNumber(List<String> numberList){
        for(String num : numberList){
            validate_PositiveInteger(num);
            validate_NumberRange(Integer.parseInt(num));
        }
    }

}
