package lotto.domain.wrapper;

import java.util.List;

import static lotto.handler.ConstantsHandler.LOTTO_SIZE;
import static lotto.handler.ErrorHandler.INVALID_SIZE;

public class Lotto {
    private final List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        validateSize(numbers);
        this.numbers = numbers;
    }

    public static Lotto create(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw INVALID_SIZE.getException();
        }
    }
}
