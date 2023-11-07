package lotto.domain;

import java.util.List;
import java.util.Set;
import lotto.util.ErrorMessage;
import lotto.util.LottoConstants;

public class Lotto implements LottoConstants {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
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
        int first = numbers.get(0);
        int last = numbers.get(LOTTO_SIZE - 1);
        if ((first < MIN_NUMBER) || (last > MAX_NUMBER)) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_RANGE.getMessage(MIN_NUMBER, MAX_NUMBER));
        }
    }
}
