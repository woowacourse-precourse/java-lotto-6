package lotto.validator;

import java.util.stream.IntStream;

import lotto.error.LottoErrorMessage;
import lotto.exception.LottoNumberException;

import static lotto.common.LottoNumberRange.LOTTO_START_NUMBER;
import static lotto.common.LottoNumberRange.LOTTO_END_NUMBER;

public class ValidatorLottoNumber {
    static void validate(final int validateNumber){
        isLottoNumberOutOfRange(validateNumber);
    }

    private static void isLottoNumberOutOfRange(final int validateInteger) {
        if(isNumberOutOfRange(validateInteger, LOTTO_START_NUMBER, LOTTO_END_NUMBER)){
            throw LottoNumberException.of(LottoErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE) ;
        }
    }

    private static boolean isNumberOutOfRange(int number, int start, int end) {
        return IntStream.rangeClosed(start, end)
                        .noneMatch(n -> n == number);
    }
}
