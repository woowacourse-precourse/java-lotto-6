package domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;
    
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicated((numbers));
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorConstants.INPUT_SIX_NUMBER.getMessage());
        }
    }

    // TODO: 추가 기능 구현
    private void validateDuplicated(List<Integer> numbers) {
        Set<Integer> nonDuplicatedSet = new HashSet<>(numbers);

        if (nonDuplicatedSet.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorConstants.INPUT_UNIQUE_NUMBER.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
