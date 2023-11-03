package lotto.model;

import static lotto.util.Constant.LOTTO_NUMBER_COUNT;

import java.util.Collections;
import java.util.List;
import lotto.exception.lotto.ExistDuplicatedNumberException;
import lotto.exception.lotto.InvalidLottoNumberException;
import lotto.util.NumbersGenerator;

public class Lotto {
    private final List<Integer> numbers;

    private Lotto(final List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Lotto createWith(final NumbersGenerator numbersGenerator) {
        List<Integer> generate = numbersGenerator.generate();
        validateSixNumbers(generate);
        validateDuplicateNumbers(generate);
        return new Lotto(generate);
    }

    private static void validateSixNumbers(final List<Integer> numbers) {
        if (!hasSixNumbers(numbers)) {
            throw new InvalidLottoNumberException(numbers);
        }
    }

    private static boolean hasSixNumbers(final List<Integer> numbers) {
        return numbers.size() != LOTTO_NUMBER_COUNT.getValue();
    }

    private static void validateDuplicateNumbers(final List<Integer> numbers) {
        if (hasDuplicate(numbers)) {
            throw new ExistDuplicatedNumberException(numbers);
        }
    }

    private static boolean hasDuplicate(final List<Integer> numbers) {
        int distinctCount = (int) numbers.stream()
                .distinct()
                .count();
        return distinctCount != numbers.size();
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
