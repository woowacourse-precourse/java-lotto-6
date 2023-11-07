package lotto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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
        validateDuplication(numbers);
        validateRange(numbers);
    }

    private void validateDuplication(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_LOTTO);
        }
    }

    private void validateRange(List<Integer> numbers) {
        numbers.stream()
                .forEach(number -> Application.checkRange(number));
    }

    public String toString() {
        return ascend(numbers).toString();
    }

    public List<Integer> ascend(List<Integer> numbers) {
        List<Integer> result = new ArrayList<>(numbers);

        result.sort(Comparator.naturalOrder());

        return result;
    }
}
