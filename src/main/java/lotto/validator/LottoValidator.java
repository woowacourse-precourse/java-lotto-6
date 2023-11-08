package lotto.validator;

import static lotto.model.lotto.LottoConstant.LOTTO_SIZE;
import static lotto.model.lotto.LottoConstant.MAX_NUMBER;
import static lotto.model.lotto.LottoConstant.MIN_NUMBER;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.lotto.LottoDuplicateException;
import lotto.exception.lotto.LottoOutOfRangeException;
import lotto.exception.lotto.LottoSizeException;

public class LottoValidator {
    // 로또 비즈니스 로직 검증

    public static void validateLotto(List<Integer> numbers){
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
    }
    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE.getValue()) {
            throw new LottoSizeException();
        }
    }

    private static void validateDuplicate(List<Integer> numbers) {
        if (hasDuplicate(numbers)) {
            throw new LottoDuplicateException();
        }
    }

    private static void validateRange(List<Integer> numbers) {
        if (outOfRange(numbers)) {
            throw new LottoOutOfRangeException();
        }
    }

    private static boolean hasDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        return numbers.stream()
                .anyMatch(num -> !uniqueNumbers.add(num));
    }

    private static boolean outOfRange(List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(number -> number < MIN_NUMBER.getValue() || number > MAX_NUMBER.getValue());
    }


}
