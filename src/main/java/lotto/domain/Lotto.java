package lotto.domain;

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

    public String getNumbers() {
        return String.join(", ", numbers.stream().map(number -> number.toString()).toList());
    }

    public int getMatchCount(List<Integer> winningNumbers) {
        int count = 0;

        for (Integer number : numbers) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }

        return count;
    }

    public boolean isMatch(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
