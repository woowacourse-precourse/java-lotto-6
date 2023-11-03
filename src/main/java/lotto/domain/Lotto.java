package lotto.domain;

import java.util.HashSet;
import java.util.List;

import static lotto.utils.Constants.*;

public class Lotto {
    private static final String INVALID_NUMBERS_SIZE_EXCEPTION_FORMAT = "로또는 총 %d개의 번호로 이루어져야 합니다.";
    private static final String OUT_OF_RANGE_NUMBER_EXCEPTION_FORMAT = "로또 번호는 %d부터 %d 사이의 숫자여야 합니다.";
    private static final String DUPLICATED_NUMBER_EXCEPTION_MESSAGE = "로또 번호들 중 중복된 숫자가 존재합니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (isInvalidSize(numbers)) {
            throw new IllegalArgumentException(
                    String.format(INVALID_NUMBERS_SIZE_EXCEPTION_FORMAT, LOTTO_NUMBERS_SIZE));
        }
        if (hasOutOfRangeNumber(numbers)) {
            throw new IllegalArgumentException(
                    String.format(OUT_OF_RANGE_NUMBER_EXCEPTION_FORMAT, MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER));
        }
        if (hasDuplicatedNumber(numbers)) {
            throw new IllegalArgumentException(DUPLICATED_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    private boolean isInvalidSize(List<Integer> numbers) {
        return numbers.size() != LOTTO_NUMBERS_SIZE;
    }

    private boolean hasOutOfRangeNumber(List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(this::isOutOfRange);
    }

    private boolean isOutOfRange(int number) {
        return number < MINIMUM_LOTTO_NUMBER || number > MAXIMUM_LOTTO_NUMBER;
    }

    private boolean hasDuplicatedNumber(List<Integer> numbers) {
        return numbers.size() != new HashSet<>(numbers).size();
    }
}
