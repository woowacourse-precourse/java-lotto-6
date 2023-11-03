package lotto.domain;

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

        List<Integer> checker = new ArrayList<>();
        for (int number : numbers) {
            if (checker.contains(number)) {
                throw new IllegalArgumentException();
            }
            checker.add(number);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean contains(int number) {
        return this.numbers.contains(number);
    }

    public String toString() {
        List<Integer> sorted = getIntegers();

        StringBuilder string = new StringBuilder("[");
        for (int index = 0; index < sorted.size(); index++) {
            string.append(sorted.get(index));
            if (index == sorted.size() - 1) {
                break;
            }
            string.append(", ");
        }
        string.append("]");

        return String.valueOf(string);
    }

    private List<Integer> getIntegers() {
        List<Integer> sorted = new ArrayList<>(this.numbers);
        sorted.sort(Comparator.naturalOrder());
        return sorted;
    }
}
