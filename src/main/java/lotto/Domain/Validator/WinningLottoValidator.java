package lotto.Domain.Validator;

import static lotto.Util.Constants.LOTTO_NUMBER_LENGTH;
import static lotto.Util.Constants.MAX_LOTTO_NUM;
import static lotto.Util.Constants.MIN_LOTTO_NUM;

import java.util.List;

public class WinningLottoValidator {
    public static void doValidate(List<Integer> numbers, int bonusNum) {
        if (!isLottoNumLength(numbers)) {
            throw new IllegalArgumentException();
        }
        if (hasOutOfBoundaryNumber(numbers)) {
            throw new IllegalArgumentException();
        }
        if (hasDupNumber(numbers)) {
            throw new IllegalArgumentException();
        }
        if (!isInBoundary(bonusNum)) {
            throw new IllegalArgumentException();
        }
        if (hasBonusNumber(numbers, bonusNum)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isLottoNumLength(List<Integer> numbers) {
        return numbers.size() == LOTTO_NUMBER_LENGTH;
    }

    private static boolean hasDupNumber(List<Integer> numbers) {
        return numbers.stream().distinct().count() != numbers.size();
    }

    private static boolean hasOutOfBoundaryNumber(List<Integer> numbers) {
        return numbers.stream().filter(num -> isInBoundary(num)).count()
                != LOTTO_NUMBER_LENGTH;
    }

    private static boolean isInBoundary(int num) {
        return num >= MIN_LOTTO_NUM && num <= MAX_LOTTO_NUM;
    }

    private static boolean hasBonusNumber(List<Integer> numbers, int bonusNum) {
        return numbers.contains(bonusNum);
    }
}
