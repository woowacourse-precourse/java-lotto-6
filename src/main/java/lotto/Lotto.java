package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;    
    private static final int LOTTO_LENGTH = 6;
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
