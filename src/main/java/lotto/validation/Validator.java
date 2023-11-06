package lotto.validation;

import lotto.exception.LottoException;

public class Validator {
    private static final String winningLottoNumbersFormat = "^\\d{1,2}(,\\d{1,2}){5}$"; // "1,2,23,43,45,32", 당첨 번호 정규식

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
        if (!lottoNumbers.matches(winningLottoNumbersFormat)) {
            throw new LottoException(LottoException.ErrorMessage.DUPLICATE_LOTTO_NUMBERS.getMessage());
        }
    }
}
