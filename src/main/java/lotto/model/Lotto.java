package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.validator.Validator;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        sortedNumbers.sort(Integer::compareTo);
        this.numbers = sortedNumbers;
    }

    private void validate(List<Integer> numbers) {
        Validator.validateLotto(numbers);
    }

    @Override
    public String toString() {
        StringBuilder stringLotto = new StringBuilder();
        stringLotto.append('[');
        for (int number : numbers) {
            stringLotto.append(number);
            stringLotto.append(", ");
        }
        stringLotto.delete(stringLotto.length() - 2, stringLotto.length());
        stringLotto.append(']');
        return stringLotto.toString();
    }
}
