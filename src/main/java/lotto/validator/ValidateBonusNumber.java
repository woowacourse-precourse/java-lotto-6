package lotto.validator;

import java.util.StringTokenizer;
import lotto.model.Lotto;
import lotto.model.WinningNumber;
import lotto.validator.errormessage.ErrorMessage;

public class ValidateBonusNumber {
    
    static final int START_INCLUSIVE=1;
    static final int END_INCLUSIVE=45;
    public static void validateBonusNumber(String buyerInput){
        validateEmpty(buyerInput);
        validateConvertable(buyerInput);
        validateNumberRange(buyerInput);
    }

    private static void validateConvertable(String buyerInput) {
        if(!buyerInput.matches("-?\\d+")){
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER.getMessage());
        }
    }

    private static void validateEmpty(String buyerInput) {
        if(buyerInput.isBlank()){
            throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT.getMessage());
        }
    }

    private static void validateNumberRange(String buyerInput){
        int bonusNumber = Integer.parseInt(buyerInput);
        if(isOutOfRange(bonusNumber)){
            throw new IllegalArgumentException(ErrorMessage.NUMBER_OUT_OF_RANGE.getMessage());
        }

    }
    private static boolean isOutOfRange(int bonusNumber){
        if(bonusNumber<START_INCLUSIVE){
            return true;
        }
        if(bonusNumber>END_INCLUSIVE){
            return true;
        }
        return false;
    }
    public static void validateDuplicateBonusNumber(Lotto winningNumber,int bonusNumber){
        if(winningNumber.getLotto().contains(bonusNumber)){
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_BONUS_NUMBER.getMessage());
        }
    }
}
