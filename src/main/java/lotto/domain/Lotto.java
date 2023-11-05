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
        StringBuilder sb = new StringBuilder()
                .append("[")
                .append(numbers.get(0));
        for (int i = 1; i < numbers.size(); i++) {
            sb.append(", ").append(numbers.get(i));
        }
        sb.append("]");
        return sb.toString();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
