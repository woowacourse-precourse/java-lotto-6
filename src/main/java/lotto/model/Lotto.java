package lotto.model;

import java.util.List;
import java.util.HashSet;
import java.util.Set;

public class Lotto {
    private static final String LANGTH_ERROR = "[ERROR] 로또 번호는 6자리여야 합니다.";
    private static final String DUPLICATION_ERROR = "[ERROR] 중복된 수가 포함되어 있습니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }
    
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LANGTH_ERROR);
        }
        Set<Integer> numSet = new HashSet<Integer>(numbers);
        if (numbers.size() != numSet.size()) {
            throw new IllegalArgumentException(DUPLICATION_ERROR);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
