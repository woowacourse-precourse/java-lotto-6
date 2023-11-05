package lotto.Domain.Validator;

import static lotto.Util.Constants.LOTTO_NUMBER_LENGTH;
import static lotto.Util.Constants.MAX_LOTTO_NUM;
import static lotto.Util.Constants.MIN_LOTTO_NUM;

import java.util.List;

public class LottoValidator {

    public static void doValidate(List<Integer> numbers) throws IllegalArgumentException {
        if (!isLottoLength(numbers)) {
            throw new IllegalArgumentException();
        }
        if (hasLottoOutOfBoundaryNumber(numbers)) {
            throw new IllegalArgumentException();
        }
        if (hasDupNumber(numbers)) {
            throw new IllegalArgumentException();
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
