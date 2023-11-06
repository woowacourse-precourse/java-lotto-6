package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import lotto.utils.StringValidator;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;

    private static final String DELIMITER = ",";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    //FOR BONUS
    public Lotto(String number) {
        validate(number);
        validate(number.trim());
        this.numbers = stringListConvertToIntegerList(stringArrayToStringListByDelimiter(number));
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ExceptionStatus.LOTTO_COMMON_INVALID_SIZE.getMessage());
        }
        if (!isValidRange(numbers)) {
            throw new IllegalArgumentException(ExceptionStatus.LOTTO_COMMON_OUT_OF_RANGE.getMessage());
        }
        if (!isDuplicated(numbers)) {
            throw new IllegalArgumentException(ExceptionStatus.LOTTO_COMMON_OUT_OF_RANGE.getMessage());
        }
    }

    private void validate(String number) {
        if (StringValidator.isBlank(number)) {
            throw new IllegalArgumentException(ExceptionStatus.LOTTO_COMMON_EMPTY.getMessage());
        }
        // TODO: 숫자검증
    }

    private boolean isDuplicated(List<Integer> numbers) {
        return numbers.size() != numbers.stream().distinct().count();
    }

    private boolean isValidRange(List<Integer> numbers) {
        return numbers.stream().allMatch(number -> LOTTO_START_NUMBER <= number && LOTTO_END_NUMBER <= number);
    }

    private List<String> stringArrayToStringListByDelimiter(String number) {
        return List.of(number.split(DELIMITER));
    }

    private List<Integer> stringListConvertToIntegerList(List<String> numbers) {
        return numbers.stream().map(Integer::parseInt).collect(Collectors.toList());
    }

    // TODO: 추가 기능 구현
}
