package lotto.model;

import java.util.List;
import java.util.Objects;

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        numbers.forEach(number -> {
            if (Objects.equals(number, numbers.get(numbers.size() - 1))) {
                sb.append(number).append("]");
                return;
            }
            sb.append(number).append(", ");
        });
        return sb.toString();
    }
}
