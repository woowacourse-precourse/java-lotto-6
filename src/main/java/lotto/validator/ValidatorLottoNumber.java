package lotto.validator;

import java.util.stream.IntStream;
import java.util.List;

import lotto.error.LottoErrorMessage;
import lotto.exception.LottoNumberException;

import static lotto.common.LottoNumberRange.LOTTO_START_NUMBER;
import static lotto.common.LottoNumberRange.LOTTO_END_NUMBER;

public class ValidatorLottoNumber {
    public static void validate(final int validateNumber) {
        isLottoNumberOutOfRange(validateNumber);
    }

    public static void validateString(final String validateStringNumber){
        isNumericValue(validateStringNumber);
        validate(Integer.parseInt(validateStringNumber));
    }
    private static void isLottoNumberOutOfRange(final int validateInteger) {
        if (isNumberOutOfRange(validateInteger, LOTTO_START_NUMBER.getNumber(), LOTTO_END_NUMBER.getNumber())) {
            throw LottoNumberException.of(LottoErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE);
        }
    }

    private static boolean isNumberOutOfRange(int number, int start, int end) {
        return IntStream.rangeClosed(start, end)
                .noneMatch(n -> n == number);
    }

    private static void isNumericValue(String buyingPrice) {
        try {
            Integer.parseInt(buyingPrice);
        } catch (NumberFormatException e) {
            throw LottoNumberException.of(LottoErrorMessage.WRONG_LOTTO_NUMBER);
        }
    }

    public static void validateBonusNumber(String bonusNumber, List<Integer> winnerNumber) {
        validateString(bonusNumber);
        if(winnerNumber.contains(Integer.parseInt(bonusNumber))){
            throw LottoNumberException.of(LottoErrorMessage.ALREADY_WINNING_NUMBER);
        }
    }
}
