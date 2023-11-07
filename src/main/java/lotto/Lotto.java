package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private List<Integer> numbers;
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

    public int countMatchWithWinningLotto(Lotto winningLotto) {
        int count = 0;
        for (Integer number : numbers) {
            if (winningLotto.contains(number)) {
                count++;
            }
        }
        return count;
    }

    public static int getPrice() {
        return PRICE;
    }
}
