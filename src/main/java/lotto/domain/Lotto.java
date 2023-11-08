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

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_SIZE.getMessage(LOTTO_SIZE));
        }
        if (Set.copyOf(numbers).size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE.getMessage());
        }
        numbers.forEach(number -> validateRange(number));
    }

    private void validateRange(int number) {
        if ((number < MIN_NUMBER) || (number > MAX_NUMBER)) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_RANGE.getMessage(MIN_NUMBER, MAX_NUMBER));
        }
    }
}
