package lotto.domain.validation;

import static lotto.domain.constant.LottoConstant.LOTTO_SIZE;
import static lotto.domain.constant.LottoConstant.MAX_RANGE;
import static lotto.domain.constant.LottoConstant.MIN_RANGE;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoValidationHandler {
    public final static String INVALID_DUPLICATED_LOTTO_NUMBERS_MESSAGE = "로또 번호에 중복된 숫자가 있습니다.";
    public final static String INVALID_LOTTO_NUMBERS_SIZE_MESSAGE = "로또 번호가 6개가 아닙니다.";
    public final static String INVALID_LOTTO_NUMBERS_RANGE_MESSAGE = "1 ~ 45 사이의 로또 번호가 아닙니다.";

    private LottoValidationHandler() {
    }

    public static void validateDuplicatedNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if(!isValidLottoSize(uniqueNumbers.size())) {
            throw new IllegalArgumentException(INVALID_DUPLICATED_LOTTO_NUMBERS_MESSAGE);
        }
    }

    public static void validationNumbersSize(List<Integer> numbers) {
        if(!isValidLottoSize(numbers.size())) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBERS_SIZE_MESSAGE);
        }
    }

    public static void validationNumbersRange(List<Integer> numbers) {
        for(Integer number : numbers) {
            if(!isValidNumberRange(number)) {
                throw new IllegalArgumentException(INVALID_LOTTO_NUMBERS_RANGE_MESSAGE);
            }
        }
    }

    private static boolean isValidLottoSize(int numbersSize) {
        return numbersSize == LOTTO_SIZE;
    }

    private static boolean isValidNumberRange(Integer number) {
        return number >= MIN_RANGE && number <= MAX_RANGE;
    }
}
