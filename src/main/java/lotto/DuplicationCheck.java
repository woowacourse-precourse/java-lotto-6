package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DuplicationCheck {
    public static void validateDuplication(List<Integer> numbers) throws IllegalArgumentException {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (numbers.size() != uniqueNumbers.size()) {
            throw new IllegalArgumentException();
        }
    }
}
