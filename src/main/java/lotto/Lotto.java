package lotto;

import java.util.List;
import java.util.function.Predicate;

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
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public int compareWithNumberList(List<Integer> anotherNumbers) {
        return (int) numbers.stream()
                .filter(number -> anotherNumbers.stream()
                        .anyMatch(Predicate.isEqual(number)))
                .count();
    }

    public int compareWithAnotherLotto(Lotto another) {
        return another.compareWithNumberList(this.numbers);
    }
}
