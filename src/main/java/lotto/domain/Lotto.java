package lotto.domain;

import static lotto.config.LottoConfig.NUMBER_OF_NUMBERS;
import static lotto.view.message.ErrorMessage.DUPLICATED_NUMBER;
import static lotto.view.message.ErrorMessage.NOT_DEFAULT_LOTTO_SIZE;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.validator.InputValidator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateDefaultSize(numbers);
        validateDuplicatedNumber(numbers);
        validateNumberOnlyFromOneToFortyFive(numbers);
    }

    private void validateDefaultSize(List<Integer> numbers) {
        if (numbers.size() != NUMBER_OF_NUMBERS.getNumber()) {
            throw new IllegalArgumentException(NOT_DEFAULT_LOTTO_SIZE.getErrorMessage());
        }
    }

    private void validateDuplicatedNumber(List<Integer> numbers) {
        Set<Integer> numbersSet = new HashSet<>(numbers);
        if (numbersSet.size() != NUMBER_OF_NUMBERS.getNumber()) {
            throw new IllegalArgumentException(DUPLICATED_NUMBER.getErrorMessage());
        }
    }

    private void validateNumberOnlyFromOneToFortyFive(List<Integer> numbers) {
        for (int number : numbers) {
            InputValidator.validateNumberOnlyFromOneToFortyFive(number);
        }
    }

    public String getNumbersNaturalOrder() {
        List<Integer> naturalOrderNumbers = new ArrayList<>(numbers);
        naturalOrderNumbers.sort(Comparator.naturalOrder());
        return naturalOrderNumbers.toString();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
