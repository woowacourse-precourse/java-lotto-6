package lotto.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningLottoValidator {
    private static final int MAX_LOTTO_SIZE = 6;
    private static final int DUPLICATE_LOTTO_SIZE = MAX_LOTTO_SIZE + 1;
    private static final int MINIMUM_LOTTO_NUMBER = 1;
    private static final int MAXIMUM_LOTTO_NUMBER = 45;
    private static final String SIZE_EXCEPTION = "[ERROR] 당첨 번호의 개수는 6개 입니다.";
    private static final String DUPLICATE_EXCEPTION = "[ERROR] 당첨 번호와 보너스번호는 서로 다른 7개의 숫자입니다.";
    private static final String OUT_OF_RANGE_EXCEPTION = "[ERROR] 당첨 번호와 보너스 번호는 1부터 45 사이의 숫자여야 합니다.";

    public static void validateWinningLotto(List<Integer> numbers, int bonusNumber) {
        validateSize(numbers);
        validateRangeOfNumber(numbers);
        validateDuplicate(numbers, bonusNumber);

        validateRangeOfBonusNumber(bonusNumber);
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != MAX_LOTTO_SIZE) {
            throw new IllegalArgumentException(SIZE_EXCEPTION);
        }
    }

    private static void validateDuplicate(List<Integer> numbers, int bonusNumber) {
        Set<Integer> nonDuplicateNumbers = new HashSet<>(numbers);
        nonDuplicateNumbers.add(bonusNumber);
        if (nonDuplicateNumbers.size() != DUPLICATE_LOTTO_SIZE) {
            throw new IllegalArgumentException(DUPLICATE_EXCEPTION);
        }
    }

    private static void validateRangeOfNumber(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number < MINIMUM_LOTTO_NUMBER || number > MAXIMUM_LOTTO_NUMBER)) {
            throw new IllegalArgumentException(OUT_OF_RANGE_EXCEPTION);
        }
    }

    private static void validateRangeOfBonusNumber(int bonusNumber) {
        if (bonusNumber < MINIMUM_LOTTO_NUMBER || bonusNumber > MAXIMUM_LOTTO_NUMBER) {
            throw new IllegalArgumentException(OUT_OF_RANGE_EXCEPTION);
        }
    }
}
