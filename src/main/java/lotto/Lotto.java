package lotto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sortLotto(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        if (Set.copyOf(numbers).size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    @Override
    public String toString() {
        List<String> numbers = new ArrayList<>();

        for (Integer number : this.numbers) {
            numbers.add(String.valueOf(number));
        }
        return "[" + String.join(", ", numbers) + "]";
    }

    public List<Integer> sortLotto(List<Integer> numbers) {
        numbers.sort(Comparator.naturalOrder());
        return numbers;
    }

    public boolean findNumber(Integer number) {
        return this.numbers.contains(number);
    }
}
