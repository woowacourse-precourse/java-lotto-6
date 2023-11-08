package lotto.model;
import lotto.exception.*;
import java.util.List;
public class Lotto {
    private final List<Integer> numbers;
    public Lotto(List<Integer> numbers) {
        validateLength(numbers);
        validateDuplicated(numbers);
        this.numbers = numbers;
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new InvalidLottoLengthException();
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    private void validateDuplicated(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != 6) {
            throw new DuplicatedNumberException();
        }
    }

    @Override
    public String toString() {
        String DELIMITER = ", ";
        return String.join(DELIMITER, numbers.stream().map(String::valueOf).toList());
    }
}