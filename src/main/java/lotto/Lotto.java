package lotto;

import java.util.List;

public class Lotto {
    private static final int PRICE = 1000;

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

    public static int purchaseCount(int pay) {
        if (pay % PRICE != 0) {
            throw new IllegalArgumentException();
        }

        return pay / PRICE;
    }
}
