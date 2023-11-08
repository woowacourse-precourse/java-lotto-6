package lotto.model.lotto;

import static lotto.util.message.ErrorMessages.LOTTO_DUPLICATION_EXCEPTION;
import static lotto.util.message.ErrorMessages.LOTTO_LENGTH_EXCEPTION;
import static lotto.util.message.ErrorMessages.LOTTO_RANGE_EXCEPTION;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import lotto.util.generator.NumberGenerator;
import lotto.util.validator.NumberRangeValidator;

public class Lotto {
    private static final Integer LOTTO_MIN_NUMBER = 1;
    private static final Integer LOTTO_MAX_NUMBER = 45;

    private List<Integer> numbers;

    public Lotto(NumberGenerator numberGenerator) {
        generateLotto(numberGenerator);
        sortAscending();
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public boolean isContain(Integer number) {
        return numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }

    private void generateLotto(NumberGenerator numberGenerator) {
        numbers = new ArrayList<>();
        while (numbers.size() < 6) {
            int randomNumber = generateNumber(numberGenerator);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
    }

    private void sortAscending() {
        numbers.sort(Comparator.naturalOrder());
    }

    private int generateNumber(NumberGenerator numberGenerator) {
        return numberGenerator.generate(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER);
    }

    private void validate(List<Integer> numbers) {
        validateLength(numbers);
        validateNumbersRange(numbers);
        validateDuplication(numbers);
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_LENGTH_EXCEPTION);
        }
    }

    private void validateNumbersRange(List<Integer> numbers) {
        numbers.forEach(this::validateNumberRange);
    }

    private void validateNumberRange(Integer number) {
        if (NumberRangeValidator.isInvalidRange(number)) {
            throw new IllegalArgumentException(LOTTO_RANGE_EXCEPTION);
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        if (isDuplicated(numbers)) {
            throw new IllegalArgumentException(LOTTO_DUPLICATION_EXCEPTION);
        }
    }

    private boolean isDuplicated(List<Integer> numbers) {
        return numbers.size() != findDistinctCount(numbers);
    }

    private long findDistinctCount(List<Integer> numbers) {
        return numbers.stream().distinct().count();
    }
}
