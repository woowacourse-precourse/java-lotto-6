package lotto;

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

    public String lottoFormat() {
        StringBuilder result = new StringBuilder();

        for (Integer number : numbers) {
            if (!result.isEmpty()) {
                result.append(", ");
            }
            result.append(number);
        }

        return "[" + result.toString() + "]";
    }

}
