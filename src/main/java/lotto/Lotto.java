package lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        validateInRange(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ExceptionMessage.notLottoCount());
        }
    }

    // TODO: 추가 기능 구현
    private void validateDuplicate(List<Integer> numbers) {
        HashSet<Integer> duplicateCheck = new HashSet<>(numbers);
        if (numbers.size() != duplicateCheck.size()) {
            throw new IllegalArgumentException(ExceptionMessage.lottoDuplicated());
        }
    }

    private void validateInRange(List<Integer> numbers) {
        for(int n : numbers) {
            if(n < 1 || n > 45) {
                throw new IllegalArgumentException(ExceptionMessage.outOfRange());
            }
        }
    }

    public void validateBonusDuplicate(List<Integer> numbers, int bonus) {
        if(numbers.contains(bonus)) {
            throw new IllegalArgumentException(ExceptionMessage.bonusDuplicated());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
