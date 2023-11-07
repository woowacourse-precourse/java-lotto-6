package lotto.data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        //추가 구현
        Set<Integer> unduplicatedNumbers = new HashSet<>(numbers);
        if (unduplicatedNumbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int countMatchNumbers(WinningNumbers winningNumbers) {
        int count = 0;
        for (int i = 0; i < numbers.size(); i++) {
            if (winningNumbers.getWinningNumbers().contains(numbers.get(i))) {
                count++;
            }
        }
        return count;
    }

    public boolean isMatchBonusNumber(BonusNumber bonusNumber) {
        if (numbers.contains(bonusNumber.get())) {
            return true;
        }
        return false;
    }
}
