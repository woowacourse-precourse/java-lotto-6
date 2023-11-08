package lotto.validator;

import lotto.exception.LottoGameException;

import java.util.HashSet;
import java.util.List;

import static lotto.exception.ErrorMessage.*;
import static lotto.utils.UtilNumber.*;

public class LottoValidator {
    public static void validInRangeNumber(List<Integer> numbers) throws LottoGameException {
        for (int lottoNumber : numbers) {
            if (lottoNumber < MIN_LOTTO_NUMBER.getNumber() || lottoNumber > MAX_LOTTO_NUMBER.getNumber()) {
                throw new LottoGameException(OUT_RANGE_ERROR_MESSAGE);
            }
        }
    }

    public static void validInRangeNumber(int number) throws LottoGameException {
        if (number < MIN_LOTTO_NUMBER.getNumber() || number > MAX_LOTTO_NUMBER.getNumber()) {
            throw new LottoGameException(OUT_RANGE_ERROR_MESSAGE);
        }
    }

    public static void validateNullValue(String value) throws LottoGameException {
        if (value.isBlank()) throw new LottoGameException(NULL_INPUT_ERROR_MESSAGE);
    }

    public static void validateDuplicateNumber(List<Integer> numbers) throws LottoGameException {
        HashSet<Integer> distinctNumbers = new HashSet<>(numbers);
        if (distinctNumbers.size() != 6) {
            throw new LottoGameException(DUPLICATE_ERROR_MESSAGE);
        }
    }

    public static void validateNoRemainderValue(int value) throws LottoGameException {
        if (value % LOTTO_COST.getNumber() != 0) throw new LottoGameException(HAVE_CHANGE_ERROR_MESSAGE);
    }

    public static void validateLottoLength(List<Integer> numbers) throws LottoGameException {
        if (numbers.size() != 6) {
            throw new LottoGameException(LENGTH_ERROR_MESSAGE);
        }
    }
}
