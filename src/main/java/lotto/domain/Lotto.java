package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lotto.constans.ErrorMessage;
import lotto.constans.GameMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateNumbersRange(numbers);
        validateDuplicated(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_LENGTH_EXCEPTION.getMessage());
        }
    }

    // TODO: 추가 기능 구현


    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validateNumbersRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(ErrorMessage.NUMBER_RANGE_EXCEPTION.getMessage());
            }
        }
    }

    private void validateDuplicated(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (Collections.frequency(numbers, number) > 1) {
                throw new IllegalArgumentException(ErrorMessage.NUMBER_DUPLICATED_EXCEPTION.getMessage());
            }
        }
    }

    public String lottoNumbersToString() {
        return GameMessage.LOTTO_NUMBER_PREFIX.getMessage() +
                numbers.stream().map(Objects::toString)
                        .collect(Collectors.joining(", ")) + GameMessage.LOTTO_NUMBER_SUFFIX.getMessage();
    }
}
