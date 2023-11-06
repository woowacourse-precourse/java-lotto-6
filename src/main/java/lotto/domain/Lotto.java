package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateNumberBoundary(numbers);
        validateSize(numbers);
        validateDuplication(numbers);
    }

    private void validateNumberBoundary(List<Integer> winningNumbers) {
        for(int num : winningNumbers) {
            if(num<1 || num>45)
                throw new IllegalArgumentException();
        }
    }

    private void validateSize(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplication(List<Integer> winningNumbers) {
        int setSize = Set.copyOf(winningNumbers).size();
        if(setSize != 6)
            throw new IllegalArgumentException();
    }

    // TODO: 추가 기능 구현
}
