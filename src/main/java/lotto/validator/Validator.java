package lotto.validator;

import lotto.exception.InvalidNumberFormatException;
import lotto.exception.LottoException;

public class Validator {

    public static void validateNumeric(String input) throws InvalidNumberFormatException {
        try {
            Integer.valueOf(input);
        } catch (NumberFormatException e) {
            throw new InvalidNumberFormatException(InvalidNumberFormatException.ErrorMessage.NUMBER.getMessage());
        }
    }

    public static void validatedWinningNumbersFormat(String lottoNumbers) throws LottoException {
        String regex = "^\\d{1,2}(,\\d{1,2}){5}$";
        if (!lottoNumbers.matches(regex)) {
            throw new LottoException(LottoException.ErrorMessage.INVALID_NUMBERS.getMessage());
        }
    }
}
