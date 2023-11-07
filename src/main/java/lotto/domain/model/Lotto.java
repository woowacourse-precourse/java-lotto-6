package lotto.domain.model;

import java.util.Collections;
import java.util.List;

public class Lotto implements Comparable<Lotto> {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = Collections.unmodifiableList(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        long count = numbers.stream()
                .distinct()
                .count();
        if (count != numbers.size()){
            throw new IllegalArgumentException("중복 수를 포함하고 있습니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public int compareTo(Lotto other) {
        return (int)this.numbers
                .stream()
                .filter(other.numbers::contains)
                .count();
    }


    @Override
    public String toString() {
        return this.numbers.toString();
    }
}
