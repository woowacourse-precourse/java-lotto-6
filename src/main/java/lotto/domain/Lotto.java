package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import lotto.utils.StringValidator;

public class Lotto {
    private final List<Integer> numbers;


    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    //FOR BONUS
    public Lotto(String number) {
        validate(number);
        validate(number.trim());
        this.numbers = convertToIntegerList(splitByDelimiter(number));
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoPolicy.LOTTO_SIZE) {
            throw new IllegalArgumentException(ExceptionStatus.LOTTO_COMMON_INVALID_SIZE.getMessage());
        }
        if (!isValidRange(numbers)) {
            throw new IllegalArgumentException(ExceptionStatus.LOTTO_COMMON_OUT_OF_RANGE.getMessage());
        }
        if (isDuplicated(numbers)) {
            throw new IllegalArgumentException(ExceptionStatus.LOTTO_COMMON_DUPLICATE.getMessage());
        }
    }

    private void validate(String number) {
        if (StringValidator.isBlank(number)) {
            throw new IllegalArgumentException(ExceptionStatus.LOTTO_COMMON_EMPTY.getMessage());
        }
        List<String> splitNumbers = splitByDelimiter(number);
        if (!isNumber(splitNumbers)) {
            throw new IllegalArgumentException(ExceptionStatus.LOTTO_COMMON_EMPTY.getMessage());
        }
        validate(convertToIntegerList(splitNumbers));
    }

    private boolean isNumber(List<String> numbers) {
        return numbers.stream().allMatch(number -> number.chars().allMatch(Character::isDigit));
    }

    private boolean isDuplicated(List<Integer> numbers) {
        return numbers.size() != numbers.stream().distinct().count();
    }

    private boolean isValidRange(List<Integer> numbers) {
        return numbers.stream()
                .allMatch(number -> LottoPolicy.LOTTO_START_NUMBER <= number && number <= LottoPolicy.LOTTO_END_NUMBER);
    }

    private List<String> splitByDelimiter(String number) {
        return List.of(number.split(LottoPolicy.DELIMITER));
    }

    private List<Integer> convertToIntegerList(List<String> numbers) {
        return numbers.stream().map(Integer::parseInt).collect(Collectors.toList());
    }
}
