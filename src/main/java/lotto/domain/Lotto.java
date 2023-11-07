package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.output.Constants.LottoConstants.LOTTO_DUPLICATE_ERROR_MESSAGE;
import static lotto.output.Constants.LottoConstants.LOTTO_SIX_NUMBERS;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicates(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_SIX_NUMBERS);
        }
    }

    private void validateDuplicates(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>();
        for (int number : numbers) {
            if (!numberSet.add(number)) {
                throw new IllegalArgumentException(LOTTO_DUPLICATE_ERROR_MESSAGE);
            }
        }
    }

}

