package lotto.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningLottoValidator {
    private static final int MAX_LOTTO_SIZE = 6;
    private static final int DUPLICATE_LOTTO_SIZE = MAX_LOTTO_SIZE + 1;
    private static final int MIN = 1;
    private static final int MAX = 45;
    private static final String SIZE_EXCEPTION = "[ERROR] 당첨 번호의 개수는 6개 입니다.";
    private static final String DUPLICATE_EXCEPTION = "[ERROR] 당첨 번호와 보너스번호는 서로 다른 7개의 숫자입니다.";
    private static final String OUT_OF_RANGE_EXCEPTION = "[ERROR] 당첨 번호와 보너스 번호는 1부터 45 사이의 숫자여야 합니다.";

    public static void validateWinningLotto(List<Integer> numbers, int bonusNumber) {
        validateSize(numbers);
        validateDuplicate(numbers, bonusNumber);
        validateRangeOfNumber(numbers);
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
        if (numbers.stream().anyMatch(number -> number < MIN || number > MAX)) {
            throw new IllegalArgumentException(OUT_OF_RANGE_EXCEPTION);
        }
    }

    private static void validateRangeOfBonusNumber(int bonusNumbers) {
        if (bonusNumbers < MIN || bonusNumbers > MAX) {
            throw new IllegalArgumentException(OUT_OF_RANGE_EXCEPTION);
        }
    }
}
