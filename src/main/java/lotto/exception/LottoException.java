package lotto.exception;

import lotto.constant.ExceptionConstant;
import lotto.constant.LottoConstant;

import java.util.List;

public class LottoException extends IllegalArgumentException {

    public LottoException(String message) {
        super(message);
    }

    public static void ensureValidSize(List<Integer> numbers) {
        if (numbers.size() != LottoConstant.LOTTO_NUMBER_COUNT) {
            throw new LottoException(ExceptionConstant.LENGTH_ERROR_MESSAGE);
        }
    }

    public static void ensureDistinctNumbers(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != LottoConstant.LOTTO_NUMBER_COUNT) {
            throw new LottoException(ExceptionConstant.DUPLICATE_ERROR_MESSAGE);
        }
    }

    public static void ensureNumbersWithinRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number < LottoConstant.MIN_LOTTO_NUMBER || number > LottoConstant.MAX_LOTTO_NUMBER)) {
            throw new LottoException(ExceptionConstant.BOUNDARY_ERROR_MESSAGE);
        }
    }
}
