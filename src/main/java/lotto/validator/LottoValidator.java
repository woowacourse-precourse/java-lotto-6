package lotto.validator;

import lotto.utils.ErrorCode;

public class LottoValidator {

    public void checkBlank(String input){
        if(input.isEmpty()) throw new IllegalArgumentException(ErrorCode.INVALID_NUMBERS.getMessage());
    }

    public void checkNumber(String input){
        if(input.matches("[^0-9,]*")) throw new IllegalArgumentException(ErrorCode.INVALID_NUMBERS.getMessage());
    }

    public void checkBonus(String input){
        if(input.matches("[^0-9]")) throw new IllegalArgumentException(ErrorCode.INVALID_NUMBERS.getMessage());
    }
}
