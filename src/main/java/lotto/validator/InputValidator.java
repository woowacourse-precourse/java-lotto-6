package lotto.validator;

import static lotto.exception.ErrorMessage.EMPTY;
import static lotto.exception.ErrorMessage.INVALID_DELIMITER;
import static lotto.exception.ErrorMessage.IS_NOT_NUMBER;

import lotto.exception.LottoException;

public class InputValidator {
    public InputValidator(){

    }
    public static void validateEmpty(final String input) {
        if (input.isEmpty()) {
            throw LottoException.of(EMPTY);
        }
    }

    public static void validateNumber(final String number){
        if(!isNumber(number)){
            throw LottoException.of(IS_NOT_NUMBER);
        }
    }
    public static boolean isNumber(final String number) {
        return String.valueOf(number).matches("\\d+");
    }

    public static void validateInputFormat(String input) {
        if (!input.matches("\\d+(," + "\\d+)+")) {
           throw LottoException.of(INVALID_DELIMITER);
        }
    }

}