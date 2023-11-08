package lotto.domain;

import java.util.List;
import java.util.Set;
import lotto.util.ErrorMessage;
import lotto.util.LottoConstants;

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

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_SIZE.toString());
        }
        if (Set.copyOf(numbers).size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE.toString());
        }
        numbers.forEach(number -> validateRange(number));
    }

    private void validateRange(int number) {
        if ((number < MIN_NUMBER) || (number > MAX_NUMBER)) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_RANGE.toString());
        }
    }
}
