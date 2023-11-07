package lotto.domain;

import static lotto.config.LottoConfig.MAX_NUMBER;
import static lotto.config.LottoConfig.MIN_NUMBER;
import static lotto.config.LottoConfig.NUMBER_OF_NUMBERS;
import static lotto.view.message.ErrorMessage.DUPLICATED_NUMBER;
import static lotto.view.message.ErrorMessage.NOT_DEFAULT_LOTTO_SIZE;
import static lotto.view.message.ErrorMessage.NOT_NUMBER_FORM_ONE_TO_FORTY_FIVE;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.view.OutputView;

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
            if (number < MIN_NUMBER.getNumber() || number > MAX_NUMBER.getNumber()) {
                throw new IllegalArgumentException(NOT_NUMBER_FORM_ONE_TO_FORTY_FIVE.getErrorMessage());
            }
        }
    }

    public void printNaturalOrder() {
        List<Integer> naturalOrderNumbers = new ArrayList<>(numbers);
        naturalOrderNumbers.sort(Comparator.naturalOrder());
        OutputView.printMessage(naturalOrderNumbers.toString());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
