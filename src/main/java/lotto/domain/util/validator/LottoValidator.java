package lotto.domain.util.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.domain.config.LottoConfig;
import lotto.domain.config.ValidatorConfig;

public class LottoValidator {
    private static final String ERROR_MESSAGE = ValidatorConfig.ERROR_MESSAGE.getMessage();
    private static final String NOT_LOTTO_SIZE_ERROR_MESSAGE = "로또 번호는 %d개 입니다.";
    private static final String DUPLICATION_LOTTO_ERROR_MESSAGE = "로또 번호에 중복된 번호가 있습니다.";
    private static final String NOT_LOTTO_NUMBER_SIZE_ERROR_MESSAGE = "로또 번호는 %d부터 %d 사이의 숫자여야 합니다.";
    private static final int LOTTO_SIZE = LottoConfig.SIZE.getValue();
    private static final int LOTTO_MINIMUM_NUMBER = LottoConfig.MINIMUM_NUMBER.getValue();
    private static final int LOTTO_MAXIMUM_NUMBER = LottoConfig.MAXIMUM_NUMBER.getValue();

    private LottoValidator() {
    }

    public static void validate(List<Integer> numbers) {
        checkNumberOfLotto(numbers);
        checkDuplication(numbers);
        checkNumberInRange(numbers);
    }

    private static void checkNumberOfLotto(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {

            throw new IllegalArgumentException(ERROR_MESSAGE + String.format(NOT_LOTTO_SIZE_ERROR_MESSAGE, LOTTO_SIZE));
        }
    }

    private static void checkDuplication(List<Integer> numbers) {
        Set unique = new HashSet(numbers);

        if (unique.size() != numbers.size()) {
            throw new IllegalArgumentException(ERROR_MESSAGE + DUPLICATION_LOTTO_ERROR_MESSAGE);
        }
    }

    private static void checkNumberInRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < LOTTO_MINIMUM_NUMBER || number > LOTTO_MAXIMUM_NUMBER) {
                throw new IllegalArgumentException(
                        ERROR_MESSAGE + String.format(NOT_LOTTO_NUMBER_SIZE_ERROR_MESSAGE, LOTTO_MINIMUM_NUMBER,
                                LOTTO_MAXIMUM_NUMBER));
            }
        }
    }
}
