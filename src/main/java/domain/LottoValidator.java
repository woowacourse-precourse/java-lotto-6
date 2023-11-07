package domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoValidator {

    public void validateDuplicate(List<Integer> numbers) {
        Set<Integer> duplicateRemove = new HashSet<>(numbers);
        if (numbers.size() != duplicateRemove.size()) {
            throw new IllegalArgumentException();
        }
    }

    public void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
}
