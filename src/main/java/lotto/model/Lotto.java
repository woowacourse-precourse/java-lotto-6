package lotto.model;

import static lotto.validation.validation.validateDuplicateNumbers;
import static lotto.validation.validation.validateNumberRange;
import static lotto.validation.validation.validateNumberSize;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumberSize(numbers);
        validateDuplicateNumbers(numbers);
        validateNumberRange(numbers);
        this.numbers = sortNumbers(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }


    private List<Integer> sortNumbers(List<Integer> numbers) {
        List<Integer> sortedList = new ArrayList<>(numbers);
        Collections.sort(sortedList);
        return sortedList;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
