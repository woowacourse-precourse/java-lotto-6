package domain;

import java.util.Comparator;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        checkLottoValidation(numbers);
        this.numbers = sortLottoNumberByAscendingOrder(numbers);
    }

    private void checkLottoValidation(List<Integer> numbers) {
        validate(numbers);
        isLottoContainDuplicateNumber(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void isLottoContainDuplicateNumber(List<Integer> numbers) {
        List<Integer> check = numbers.stream().distinct().toList();
        if(check.size() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    private List<Integer> sortLottoNumberByAscendingOrder(List<Integer> numbers) {
        numbers.sort(Comparator.naturalOrder());
        return numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
