package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import lotto.util.IllegalArgumentMessage;
import lotto.util.LottoConstant;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplication(numbers);
        validateRange(numbers);
        this.numbers = sortedNumbers(numbers);
    }

    private List<Integer> sortedNumbers(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LottoConstant.PICK_COUNT) {
            throw new IllegalArgumentException(IllegalArgumentMessage.ERROR_PICK_COUNT);
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException(IllegalArgumentMessage.ERROR_DUPLICATION_MESSAGE);
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < LottoConstant.MINIMUM_RANGE || number > LottoConstant.MAXIMUM_RANGE) {
                throw new IllegalArgumentException(IllegalArgumentMessage.ERROR_RANGE_MESSAGE);
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
