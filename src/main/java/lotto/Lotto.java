package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicatedNumbers(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicatedNumbers(List<Integer> numbers) {
        Set<Integer> setForCheckSize = new HashSet<>(numbers);
        if (numbers.size() != setForCheckSize.size()) {
            throw new IllegalArgumentException("[ERROR] : 중복된 번호가 포함되어 있습니다.");
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
