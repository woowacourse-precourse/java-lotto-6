package lotto.exception;

import lotto.domain.CorrectCount;
import lotto.util.ErrorMessage;

public class LottoValidator {

    public static void validate(CorrectCount replace) throws IllegalArgumentException {
        if(replace == null){
            throw new IllegalStateException(String.valueOf(ErrorMessage.ERROR_NOT_FOUND_LOTTO));
        }
    }
}
