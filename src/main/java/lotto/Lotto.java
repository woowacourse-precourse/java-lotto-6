package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        DuplicationCheck.validateDuplication(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public void printLotto() {
        System.out.println(numbers.toString());
    }

    public int compareWinningNumber(List<Integer> winningNumbers) {
        int matchCount = 0;
        for (int number : winningNumbers) {
            if (numbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public boolean compareBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
