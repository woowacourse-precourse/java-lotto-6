package lotto.validator;

import static lotto.exception.ExceptionMessage.NOT_NUMBER_EXCEPTION_MESSAGE;
import static lotto.exception.ExceptionMessage.NULL_POINTER_EXCEPTION_MESSAGE;

import lotto.exception.LottoApplicationException;

public class InputValidator {

    public void validateNotNull(String input){
        if(input == null || input.isEmpty() ){
            throw new LottoApplicationException(NULL_POINTER_EXCEPTION_MESSAGE);
        }
    }

    public void validateNumber(String input){
        if(!input.chars().allMatch(Character::isDigit)){
            throw new LottoApplicationException(NOT_NUMBER_EXCEPTION_MESSAGE);
        }
    }

}
