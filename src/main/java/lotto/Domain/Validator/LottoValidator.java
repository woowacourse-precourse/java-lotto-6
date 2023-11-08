package lotto.Domain.Validator;

import static lotto.Util.Constants.LOTTO_NUMBER_LENGTH;
import static lotto.Util.Constants.MAX_LOTTO_NUM;
import static lotto.Util.Constants.MIN_LOTTO_NUM;

import java.util.List;
import lotto.Util.ExceptionMessageFormatter;
import lotto.Util.LottoGameException;

public class LottoValidator {
    private LottoValidator() {

    }

    public static void doValidate(List<Integer> numbers) throws IllegalArgumentException {
        if (!isLottoLength(numbers)) {
            throw new IllegalArgumentException(
                    ExceptionMessageFormatter.makeMessage(LottoGameException.NOT_LOTTO_LENGTH.getMessage()));
        }
        if (hasLottoOutOfBoundaryNumber(numbers)) {
            throw new IllegalArgumentException(
                    ExceptionMessageFormatter.makeMessage(
                            LottoGameException.WRONG_BOUNDARY_NUMBER_IN_LOTTO.getMessage()));
        }
        if (hasDupNumber(numbers)) {
            throw new IllegalArgumentException(
                    ExceptionMessageFormatter.makeMessage(
                            LottoGameException.CONTAIN_DUPLICATE_NUMBER_IN_LOTTO.getMessage()));
        }
    }

    private static boolean isLottoLength(List<Integer> numbers) {
        return numbers.size() == LOTTO_NUMBER_LENGTH;
    }

    private static boolean hasLottoOutOfBoundaryNumber(List<Integer> numbers) {
        return numbers.stream().filter(num -> MIN_LOTTO_NUM <= num && MAX_LOTTO_NUM >= num).count()
                != LOTTO_NUMBER_LENGTH;
    }

    private static boolean hasDupNumber(List<Integer> numbers) {
        return numbers.stream().distinct().count() != numbers.size();
    }
}
