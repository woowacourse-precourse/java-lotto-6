package lotto.domain.wrapper;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.handler.ConstantsHandler.*;
import static lotto.handler.ErrorHandler.INCONVERTIBLE_TYPE;
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

    public static Lotto from(String inputValues) {
        List<Integer> numbers = validateType(inputValues);

        return new Lotto(numbers);
    }

    private static List<Integer> validateType(String inputValues) {
        try {
            return Arrays.stream(inputValues.split(COMMA_DELIMITER))
                    .map(Integer::valueOf)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw INCONVERTIBLE_TYPE.getException();
        }
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw INVALID_SIZE.getException();
        }
    }
}
