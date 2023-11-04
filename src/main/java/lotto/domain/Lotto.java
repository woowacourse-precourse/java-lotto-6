package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateDuplicateNumber(numbers);
        validateLottoSize(numbers);
        validateNumberRange(numbers);
    }

    private void validateNumberRange(List<Integer> numbers) {
        List<Integer> a = numbers.stream().filter(h -> h < 0 || h > 45).toList();
        if (!a.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicateNumber(List<Integer> numbers) {
        final Set<Integer> set = new HashSet<>();

        for (Integer yourInt : numbers) {
            if (!set.add(yourInt)) {
                throw new IllegalArgumentException();
            }
        }
    }

    public int match(Lotto lotto) {
        int matchedNumber = 0;
        for (int i = 0; i < 6; i++) {
            if (this.numbers.get(i).equals(lotto.numbers.get(i))) {
                matchedNumber++;
            }
        }
        return matchedNumber;
    }

}
