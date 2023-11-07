package lotto.model;

import java.util.List;
import java.util.stream.Collectors;
import lotto.view.ErrorMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {

        validateSize(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
        this.numbers = numbers.stream().sorted().collect(Collectors.toList());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean contains(Integer integer) {
        return numbers.contains(integer);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            ErrorMessage.sizeException();
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            ErrorMessage.duplicateException();
            throw new IllegalArgumentException();
        }
    }

    private void validateRange(List<Integer> numbers) {
        long count = numbers.stream()
                .filter((number) -> number >= LottoUtil.MIN_NUMBER && number <= LottoUtil.MAX_NUMBER)
                .distinct()
                .count();

        if (count != numbers.size()) {
            ErrorMessage.rangeException();
            throw new IllegalArgumentException();
        }
    }
}
