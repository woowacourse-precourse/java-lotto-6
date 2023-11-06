package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;
    private static final String OPEN_SQUARE_BRACKETS = "[";
    private static final String CLOSE_SQUARE_BRACKETS = "]";
    private static final int PRICE = 1000;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        sort();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    private void sort() {
        Collections.sort(numbers);
    }

    public String toString() {
        String result = numbers.stream().map(String::valueOf).collect(Collectors.joining(", "));
        return OPEN_SQUARE_BRACKETS + result + CLOSE_SQUARE_BRACKETS;
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public static int getPrice() {
        return PRICE;
    }
}
