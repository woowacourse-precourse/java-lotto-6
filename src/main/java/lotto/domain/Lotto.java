package lotto.domain;

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
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");

        numbers.stream().forEach(element -> {
            sb.append(element).append(", ");
        });
        sb.delete(sb.length() - 2 , sb.length()).append("]");

        return sb.toString();
    }

}
