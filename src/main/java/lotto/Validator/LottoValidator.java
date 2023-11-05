package lotto.Validator;

import java.util.List;

public class LottoValidator {
    private static final int LOTTO_NUMBER_LENGTH = 6;
    private static final int MIN_LOTTO_NUM = 1;
    private static final int MAX_LOTTO_NUM = 45;

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
