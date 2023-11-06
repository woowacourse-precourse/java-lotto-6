package lotto.model;

import java.util.List;
import java.util.function.Consumer;

public class LottoValidator {

    public static final String ERRORHEAD = "[ERROR]";

    public void validateLotto(List<Integer> numbers) {
        ((Consumer<List<Integer>>) this::validateSize)
                .andThen(this::validateDuplicate)
                .andThen(this::validateRange)
                .accept(numbers);
    }
    public void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) throw new IllegalArgumentException(ERRORHEAD);
    }

    public  void validateDuplicate(List<Integer> numbers) {
        long distinctCount = numbers.stream().distinct().count();
        if (numbers.size() != distinctCount) {
            throw new IllegalArgumentException(ERRORHEAD);
        }
    }

    public  void validateRange(List<Integer> numbers) {
        numbers.stream()
                .filter(number -> number < 1 || number > 45)
                .findAny()
                .ifPresent(number -> {
                    throw new IllegalArgumentException(ERRORHEAD);
                });
    }
}
