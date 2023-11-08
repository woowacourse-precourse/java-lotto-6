package model;

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

    public String toString() {
        return numbers.toString();
    }

    public int getLottoMatchingCount(List<Integer> lottoWinningNumbers) {
        int count = 0;

        for (Integer number : numbers) {
            if (lottoWinningNumbers.contains(number)) {
                count++;
            }
        }

        return count;
    }
    // TODO: 추가 기능 구현
}
