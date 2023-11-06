package lotto.domain;

import static lotto.constant.ErrorMessageConstant.DUPLICATE_NUMBER_ERROR_MESSAGE;
import static lotto.constant.SystemConstant.NUMBER_COUNT;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        numbers = numbers.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        if (numbers.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_ERROR_MESSAGE.getErrorMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
