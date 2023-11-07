package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.utils.Constants;
import lotto.utils.ErrorConstants;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(final List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateDuplicateNumber(numbers);
        validateNumbersBoundary(numbers);
        this.numbers = new ArrayList<>(numbers);
        Collections.sort(this.numbers);
    }

    @Override
    public String toString() {
        final List<String> numbers = this.numbers.stream()
                .map(Object::toString)
                .toList();
        return Constants.START_BRACKET + String.join(", ", numbers) + Constants.END_BRACKET;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validateNumbersSize(final List<Integer> numbers) {
        if (numbers.size() != Constants.LOTTO_SIZE) {
            throw new IllegalArgumentException(ErrorConstants.LOTTO_SIZE);
        }
    }

    private void validateDuplicateNumber(final List<Integer> numbers) {
        final Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (numbers.size() != uniqueNumbers.size()) {
            throw new IllegalArgumentException(ErrorConstants.LOTTO_NUMBER_DUPLICATE);
        }
    }

    private void validateNumbersBoundary(final List<Integer> numbers) {
        final boolean isBoundary = numbers.stream()
                .anyMatch(number -> number < Constants.MIN_GENERATE_VALUE || number > Constants.MAX_GENERATE_VALUE);
        if (isBoundary) {
            throw new IllegalArgumentException(ErrorConstants.LOTTO_NUMBER_BOUNDARY);
        }
    }
}