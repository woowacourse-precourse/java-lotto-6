package lotto.domain.validator;

import java.util.List;

public class LottoValidator {
    private static final Integer MIN_NUMBER = 0;
    private static final Integer MAX_NUMBER = 45;
    private static final String MESSAGE_DUPLICATE_ERROR = "[ERROR]: 중복된 번호를 제외해주세요.";
    private static final String MESSAGE_SIZE_ERROR = "[ERROR]: 6개의 숫자만 입력해주세요.";
    private static final String MESSAGE_RANGE_ERROR = "[ERROR]: 1 ~ 45 사이의 숫자만 입력해주세요.";

    public LottoValidator(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(MESSAGE_SIZE_ERROR);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(MESSAGE_DUPLICATE_ERROR);
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                throw new IllegalArgumentException(MESSAGE_RANGE_ERROR);
            }
        }
    }
}
