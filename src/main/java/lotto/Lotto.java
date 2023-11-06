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

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public int countEqualNumber(Lotto lotto) {
        List<Integer> originalNumbers = new ArrayList<>(this.numbers);
        List<Integer> compareNumbers = lotto.getNumbers();
        originalNumbers.retainAll(compareNumbers);
        return originalNumbers.size();
    }

    public boolean contain(Integer number) {
        return this.numbers.contains(number);
    }
}
