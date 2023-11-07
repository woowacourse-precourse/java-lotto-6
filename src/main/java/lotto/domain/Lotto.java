package lotto.domain;

import static lotto.constant.ConstantInteger.LOTTO_MAX_NUMBER;
import static lotto.constant.ConstantInteger.LOTTO_MIN_NUMBER;
import static lotto.exception.ExceptionMessage.DUPLICATED_NUMBER_MESSAGE;
import static lotto.exception.ExceptionMessage.NOT_IN_RANGE_NUMBER_INPUT_MESSAGE;
import static lotto.exception.ExceptionMessage.UNAVAILABLE_NUMBER_COUNT;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sortNumbers(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateCount(numbers);
        validateDuplicate(numbers);
        validateNumberRange(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    // TODO: 추가 기능 구현
    private void validateCount(List<Integer> numbers) {
        if (numbers.size()!=6) {
            throw new IllegalArgumentException(UNAVAILABLE_NUMBER_COUNT.getMessage());
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count()!=numbers.size()) {
            throw new IllegalArgumentException(DUPLICATED_NUMBER_MESSAGE.getMessage());
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        if (!isInRangeAllNumber(numbers)) {
            throw new IllegalArgumentException(NOT_IN_RANGE_NUMBER_INPUT_MESSAGE.getMessage());
        }
    }

    private boolean isInRangeAllNumber(List<Integer> numbers) {
        return numbers.stream().allMatch(number -> isInRangeNumber(number));
    }

    private boolean isInRangeNumber(Integer number) {
        return LOTTO_MIN_NUMBER <= number && number <= LOTTO_MAX_NUMBER;
    }

    private List<Integer> sortNumbers(List<Integer> numbers) {
        return numbers.stream().sorted().collect(Collectors.toList());
    }

}
