package lotto.model;

import static lotto.validation.Validation.validateDuplicateNumbers;
import static lotto.validation.Validation.validateNumberRange;
import static lotto.validation.Validation.validateNumberSize;

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

    public int countContain(List<Integer> winningNumbers) {
        int count = 0;
        for (int number : numbers) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    public boolean containNumber(int bounsNumber) {
        return numbers.contains(bounsNumber);
    }


    @Override
    public String toString() {
        return numbers.toString();
    }
}
