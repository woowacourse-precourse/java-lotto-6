package lotto.validator;

import static lotto.exception.ErrorMessage.DUPLICATE_BONUS_NUMBER;
import static lotto.exception.ErrorMessage.DUPLICATE_WINNING_NUMBERS;
import static lotto.exception.ErrorMessage.OUTSIDE_RANGE;
import static lotto.exception.ErrorMessage.UNFIT_UNIT;
import static lotto.exception.ErrorMessage.WRONG_SIZE;

import java.util.List;
import lotto.domain.Lotto;
import lotto.exception.LottoException;

public class Validator {
    private static final int LOTTO_SIZE = 6;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_PRISE = 1000;
    private static final int PROPER_REMAINDER = 0;

    public static void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw LottoException.of(WRONG_SIZE);
        }
    }

    public static void validateRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(Validator::measureRange)) {
            throw LottoException.of(OUTSIDE_RANGE);
        }
    }

    public static void validateDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != LOTTO_SIZE) {
            throw LottoException.of(DUPLICATE_WINNING_NUMBERS);
        }
    }

    public static void validateUnique(int number, Lotto numbers) {
        if (numbers.getNumbers().contains(number)) {
            throw LottoException.of(DUPLICATE_BONUS_NUMBER);
        }
    }

    // LOTTO_PRISE를 한 곳에서 관리하기 위해 리턴 값 설정함
    public static int validateUnit(int purchaseAmount) {
        if (calculateRemainder(purchaseAmount) != PROPER_REMAINDER) {
            throw LottoException.of(UNFIT_UNIT);
        }
        return calculateUnit(purchaseAmount);
    }

    private static int calculateUnit(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRISE;
    }

    private static int calculateRemainder(int purchaseAmount) {
        return purchaseAmount % LOTTO_PRISE;
    }

    private static boolean measureRange(Integer number) {
        return number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER;
    }
}
