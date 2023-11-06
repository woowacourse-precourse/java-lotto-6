package lotto.domain;

import java.util.List;
import lotto.util.SortedRandomNumberGenerator;

public class Lotto {
    public static final String INVALID_NUMBER_COUNT_MESSAGE = String.format("로또 번호는 %d개여야 합니다.", SortedRandomNumberGenerator.COUNT);
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(INVALID_NUMBER_COUNT_MESSAGE);
        }
        WinningLotto.validateWinningNumber(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }
}
