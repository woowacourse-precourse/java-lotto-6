package lotto.domain;

import static lotto.config.ErrorMessage.LOTTO_NUMBER_DUPLICATION_ERROR_MESSAGE;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }

        long distinctCount = numbers.stream().distinct().count();

        if (distinctCount < numbers.size()) {
            throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATION_ERROR_MESSAGE.getMessage());
        }
    }

    public boolean isContainNumber(Integer number) {
        return numbers.contains(number);
    }

    @Override
    public String toString() {
        String string = numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        return "[" + string + "]";
    }
}
