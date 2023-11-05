package lotto.validator;

import lotto.exception.LottoException;

public class Validator {

    public static void validateLottoAmountNumeric(String input) throws LottoException {
        try {
            Integer.valueOf(input);
        } catch (NumberFormatException e) {
            throw new LottoException(LottoException.ErrorMessage.LOTTO_MIN_AMOUNT.getMessage());
        }
    }

    public static void validateBonusNumberNumeric(String input) throws LottoException {
        try {
            Integer.valueOf(input);
        } catch (NumberFormatException e) {
            throw new LottoException(LottoException.ErrorMessage.RANGE_BONUS_NUMBER.getMessage());
        }
    }

    public static void validatedWinningNumbersFormat(String lottoNumbers) throws LottoException {
        String regex = "^\\d{1,2}(,\\d{1,2}){5}$";
        if (!lottoNumbers.matches(regex)) {
            throw new LottoException(LottoException.ErrorMessage.DUPLICATE_LOTTO_NUMBERS.getMessage());
        }
    }
}
