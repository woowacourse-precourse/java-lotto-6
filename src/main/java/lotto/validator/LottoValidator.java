package lotto.validator;

import java.util.List;
import lotto.domain.Lotto;

public class LottoValidator {
    public static final String INVALID_LOTTO_SIZE_MESSAGE = "당첨 번호는" + Lotto.SIZE + "개 입니다.";
    public static final String DUPLICATE_NUMBERS_MESSAGE = "당첨 번호는 중복되지 않아야 합니다";

    public static void validateNumberSize(final List<Integer> numbers) {
        if (numbers.size() != Lotto.SIZE) {
            throw new IllegalArgumentException(INVALID_LOTTO_SIZE_MESSAGE);
        }
    }

    public static void validateDuplicateNumbers(final List<Integer> numbers) {
        for (Integer number : numbers) {
            long count = numbers.stream().filter(num -> num.equals(number)).count();

            if (count > 1) {
                throw new IllegalArgumentException(DUPLICATE_NUMBERS_MESSAGE);
            }
        }
    }
}
