package lotto.model.lottoResultChecker;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.constant.ErrorMessages.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_INPUT);
        }
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(SIX_NUMBERS_REQUIRED + numbers.size());
        }
        if (numbers.stream().anyMatch(number -> number < 1 || number > 45)) {
            throw new IllegalArgumentException(NUMBER_RANGE);
        }
        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numberSet.size() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER);
        }
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }
}


