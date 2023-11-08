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

    public int countOfMatch(Lotto otherLotto) {
        List<Integer> otherNumbers = otherLotto.getNumbers();

        int count = 0;
        for (Integer number : numbers) {
            if (otherNumbers.contains(number)) {
                count++;
            }
        }

        return count;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
