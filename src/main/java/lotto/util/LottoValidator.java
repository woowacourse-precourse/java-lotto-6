package lotto.util;

import static lotto.exception.ExceptionMessage.EMPTY;
import static lotto.exception.ExceptionMessage.DUPLICATED;
import static lotto.exception.ExceptionMessage.OUT_OF_RANGE;

import java.util.List;
import lotto.exception.LottoException;

public class LottoValidator {
    private LottoValidator() {
        // 인스턴스 생성 방지용
    }

    public static void validateNotNull(String input) throws LottoException {
        if (input == null || input.trim().isEmpty()) {
            throw new LottoException(EMPTY);
        }
    }

    public static void validateNotDuplicate(List<Integer> numbers) throws LottoException {
        if (isDuplicated(numbers)) {
            throw new LottoException(DUPLICATED);
        }
    }

    public static void validateInRange(Integer number) throws LottoException {
        if (number < 1 || number > 45) {
            throw new LottoException(OUT_OF_RANGE);
        }
    }

    private static boolean isDuplicated(List<Integer> numbers) {
        long uniqueCount = numbers.stream()
                .distinct()
                .count();
        return uniqueCount < numbers.size();
    }
}
