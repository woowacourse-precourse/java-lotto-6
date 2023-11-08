package lotto.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import lotto.util.IntegerUtil;
import lotto.view.ErrorMessage;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplication(numbers);
        validateRange(numbers);
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_LOTTO);
        }
    }

    private void validateRange(List<Integer> numbers) {
        numbers.stream()
                .forEach(number -> IntegerUtil.checkRange(number));
    }

    public String toString() {
        return ascend(numbers).toString();
    }

    public List<Integer> ascend(List<Integer> numbers) {
        List<Integer> result = new ArrayList<>(numbers);

        result.sort(Comparator.naturalOrder());

        return result;
    }

    public boolean contains(Integer number) {
        return numbers.contains(number);
    }

    public int calculateSameNumber(Lotto another) {
        return (int) numbers.stream()
                .filter(number -> another.contains(number))
                .count();
    }
}
