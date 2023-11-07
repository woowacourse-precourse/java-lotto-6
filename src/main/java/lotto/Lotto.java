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
        if (!isCorrectRange(numbers)) {
            throw new IllegalArgumentException();
        }
        if (hasDuplicated(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않는 숫자여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현

    protected boolean isCorrectRange(int bonusNumber) {
        return bonusNumber >= 1 && bonusNumber <= 45;
    }

    protected boolean isCorrectRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (!isCorrectRange(number)) {
                return false;
            }
        }
        return true;
    }

    protected boolean hasDuplicated(List<Integer> numbers) {
        List<Integer> unDuplicatedNumbers = new ArrayList<>();
        for (Integer number : numbers) {
            if (!unDuplicatedNumbers.contains(number)) {
                unDuplicatedNumbers.add(number);
            }
        }
        return unDuplicatedNumbers.size() < 6;
    }

    public int getSameNumberCount(List<Integer> winningNumbers) {
        int count = 0;
        for (Integer number : numbers) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    protected List<Integer> getNumbers() {
        return numbers;
    }

    public Result getResult(WinningLotto winningLotto) {
        int count = getSameNumberCount(winningLotto.getNumbers());
        if (count == 6) {
            return Result.FIRST;
        }
        if (count == 5) {
            if (numbers.contains(winningLotto.getBonusNumber())) {
                return Result.SECOND;
            }
            return Result.THIRD;
        }
        if (count == 4) {
            return Result.FOURTH;
        }
        if (count == 3) {
            return Result.FIFTH;
        }
        return Result.NONE;
    }

}
