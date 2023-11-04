package lotto.dto;

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

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void printNumber() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (Integer number : numbers) {
            stringBuilder.append(number).append(", ");
        }
        stringBuilder.replace(stringBuilder.length() - 2, stringBuilder.length(), "]");
        System.out.println(stringBuilder);
    }
}
