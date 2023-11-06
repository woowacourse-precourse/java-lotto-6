package lotto.validator;

import static lotto.exception.ExceptionMessage.NULL_POINTER_EXCEPTION_MESSAGE;

import lotto.exception.LottoApplicationException;

public class InputValidator {

    public void validateNotNull(String input){
        if(input == null || input.isEmpty() ){
            throw new LottoApplicationException(NULL_POINTER_EXCEPTION_MESSAGE);
        }
    }

}
