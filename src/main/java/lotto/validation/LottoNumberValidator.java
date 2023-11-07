package lotto.validation;

import java.util.List;
import java.util.stream.Collectors;
import lotto.enums.Delimiter;
import lotto.enums.LottoValue;

public class LottoNumberValidator {
    private static final String ERROR_PREFIX = Delimiter.ERROR_PREFIX.getDelimiter();

    private LottoNumberValidator() {
    }

    public static void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplication(numbers);
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != LottoValue.NUMBER_COUNT.getValue()) {
            throw new IllegalArgumentException(ERROR_PREFIX + "로또 번호는 6개의 번호로 이뤄져야 합니다.");
        }
    }

    private static void validateRange(List<Integer> numbers) {
        int minNumberRange = LottoValue.MIN_LOTTO_NUMBER_RANGE.getValue();
        int maxNumberRange = LottoValue.MAX_LOTTO_NUMBER_RANGE.getValue();
        numbers.stream().forEach(number -> {
            if (number < minNumberRange || number > maxNumberRange) {
                throw new IllegalArgumentException(ERROR_PREFIX + "로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        });
    }

    private static void validateDuplication(List<Integer> numbers) {
        int deDuplicatedCount = numbers.stream().collect(Collectors.toSet()).size();
        if (numbers.size() != deDuplicatedCount) {
            throw new IllegalArgumentException(ERROR_PREFIX + "중복된 번호를 입력할 수 없습니다.");
        }
    }
}
