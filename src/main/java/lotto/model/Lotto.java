package lotto.model;
import lotto.exception.*;
import java.util.List;
public record Lotto(List<Integer> numbers) {
    public Lotto {
        validateDuplicated(numbers);
        validateLength(numbers);
    }
    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new InvalidLottoLengthException();
        }
    }
    private void validateDuplicated(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != 6) {
            throw new DuplicatedNumberException();
        }
    }
    @Override
    public String toString() {
        String DELIMITER = ",";
        return String.join(DELIMITER, numbers.stream().map(String::valueOf).toList());
    }
}