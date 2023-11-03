package lotto.domain.util.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.domain.config.LottoConfig;

public class LottoValidator {
    private static final int LOTTO_SIZE = LottoConfig.LOTTO_SIZE.getValue();
    private static final int LOTTO_MINIMUM_NUMBER = LottoConfig.LOTTO_MINIMUM_NUMBER.getValue();
    private static final int LOTTO_MAXIMUM_NUMBER = LottoConfig.LOTTO_MAXIMUM_NUMBER.getValue();

    public static void validate(List<Integer> numbers) {
        checkNumberOfLotto(numbers);
        checkDuplication(numbers);
        checkNumberInRange(numbers);
    }

    private static void checkNumberOfLotto(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 " + LOTTO_SIZE + "개 입니다.");
        }
    }

    private static void checkDuplication(List<Integer> numbers) {
        Set unique = new HashSet(numbers);

        if (unique.size() != numbers.size()) {
            throw new IllegalStateException("[ERROR] 로또 번호에 중복된 번호가 있습니다.");
        }
    }

    private static void checkNumberInRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < LOTTO_MINIMUM_NUMBER || number > LOTTO_MAXIMUM_NUMBER) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }
}
