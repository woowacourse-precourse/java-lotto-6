package lotto;

import java.util.ArrayList;
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

    // TODO: 추가 기능 구현



    public int countEqualNumber(List<Integer> numbers) {
        List<Integer> originalNumbers = new ArrayList<>(this.numbers);
        originalNumbers.retainAll(numbers);
        return originalNumbers.size();
    }

    public boolean contain(Integer number) {
        return this.numbers.contains(number);
    }
}
