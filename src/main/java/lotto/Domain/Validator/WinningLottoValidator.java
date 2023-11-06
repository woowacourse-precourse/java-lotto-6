package lotto.Domain.Validator;

import static lotto.Util.Constants.LOTTO_NUMBER_LENGTH;
import static lotto.Util.Constants.MAX_LOTTO_NUM;
import static lotto.Util.Constants.MIN_LOTTO_NUM;

import java.util.List;
import lotto.Util.ExceptionMessageFormatter;
import lotto.Util.LottoGameException;

public class WinningLottoValidator {
    private WinningLottoValidator() {

    }

    public static void doValidate(List<Integer> numbers, int bonusNum) {
        if (!isLottoNumLength(numbers)) {
            throw new IllegalArgumentException(
                    ExceptionMessageFormatter.makeMessage(LottoGameException.NOT_LOTTO_LENGTH.getMessage()));
        }
        if (hasOutOfBoundaryNumber(numbers)) {
            throw new IllegalArgumentException(ExceptionMessageFormatter.makeMessage(
                    LottoGameException.WRONG_BOUNDARY_NUMBER_IN_WINNING_NUMBER.getMessage()));
        }
        if (hasDupNumber(numbers)) {
            throw new IllegalArgumentException(ExceptionMessageFormatter.makeMessage(
                    LottoGameException.CONTAIN_DUPLICATE_NUMBER_IN_WINNING_NUMBER.getMessage()));
        }
        if (!isInBoundary(bonusNum)) {
            throw new IllegalArgumentException(
                    ExceptionMessageFormatter.makeMessage(LottoGameException.WRONG_BOUNDARY_BONUS_NUMBER.getMessage()));
        }
        if (hasBonusNumber(numbers, bonusNum)) {
            throw new IllegalArgumentException(
                    ExceptionMessageFormatter.makeMessage(LottoGameException.INCLUDE_BONUS_NUMBER.getMessage()));
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
