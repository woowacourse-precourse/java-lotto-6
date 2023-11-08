package lotto.domain;

import java.util.List;
import java.util.Set;
import lotto.constants.ErrorMessage;
import lotto.constants.LottoConstants;

public class Lotto implements LottoConstants {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream()
                .sorted()
                .toList();
    }

    public String concatNumbers() {
        return numbers.toString();
    }

    public int contains(int number) {
        if (numbers.contains(number)) {
            return 1;
        }
        return 0;
    }

    public int compareMatches(Lotto winningNumbers) {
        int matchCount = 0;
        for (int number : numbers) {
            matchCount += winningNumbers.contains(number);
        }
        return matchCount;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_SIZE.toString());
        }
        if (Set.copyOf(numbers).size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE.toString());
        }
        numbers.forEach(this::validateRange);
    }

    private void validateRange(int number) {
        if ((number < MIN_NUMBER) || (number > MAX_NUMBER)) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_RANGE.toString());
        }
    }
}
