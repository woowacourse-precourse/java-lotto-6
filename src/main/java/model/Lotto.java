package model;

import Constant.ErrorMessage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    protected final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        for (Integer number : numbers) {
            validateNumberRange(number);
        }
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.INCORRECT_NUMBER_OF_NUMBERS.getMessage());
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.indexOf(numbers.get(i)) != i) {
                throw new IllegalArgumentException(ErrorMessage.DUPLICATION_OF_NUMBERS.getMessage());
            }
        }
    }

    protected void validateNumberRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_OF_RANGE.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(this.numbers);
    }

    public List<Integer> getSortedNumbers() {
        List<Integer> sortedNumbers = new ArrayList<>(this.numbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers;
    }
}