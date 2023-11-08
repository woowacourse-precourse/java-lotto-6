package lotto.model;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static lotto.model.ErrorMessage.NUMBER_COUNT_ERROR;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        numberDuplication(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(NUMBER_COUNT_ERROR.toString());
        }
    }

    private void numberDuplication(List<Integer> winNumber) {
        Set<Integer> setWinNumber = winNumber.stream().collect(Collectors.toSet());
        if (winNumber.size() != setWinNumber.size()) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
