package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Map<Integer, Boolean> numberChecker = new HashMap<>();
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        for (Integer number : numbers) {
            if (Boolean.TRUE.equals(numberChecker.get(number)))
                throw new IllegalArgumentException();
            numberChecker.put(number, Boolean.TRUE);
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
