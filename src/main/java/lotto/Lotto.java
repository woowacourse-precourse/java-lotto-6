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

    public List<Integer> getNumbers() {
        return numbers;
    }

    // TODO: 추가 기능 구현

    public int countMatchingNumbers(Lotto otherLotto) {
        List<Integer> otherNumbers = otherLotto.getNumbers();
        int matchingCount = 0;

        for (int number : numbers) {
            if (otherNumbers.contains(number)) {
                matchingCount++;
            }
        }

        return matchingCount;
    }
}
