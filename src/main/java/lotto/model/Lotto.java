package lotto.model;

import lotto.view.ExceptionMessage;

import java.util.*;

public class Lotto {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSixDigits(numbers);
        validateDuplicatedNumber(numbers);
        validateRange(numbers);
        List<Integer> tempNumbers = new ArrayList<>(numbers);
        Collections.sort(tempNumbers);
        this.numbers = tempNumbers;
    }

    private void validateSixDigits(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicatedNumber(List<Integer> numbers) {
        Set<Integer> duplicatedCheck = new HashSet<>(numbers);
        if (duplicatedCheck.size() != 6) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_NUMBER_DUPLICATED_ERROR);
        }
    }

    private void validateRange(List<Integer> numbers) {
        for(Integer number : numbers) {
            if(number < MIN_NUMBER || number > MAX_NUMBER) {
                throw new IllegalArgumentException(ExceptionMessage.NOT_NUMBER_RANGE_ERROR);
            }
        }
    }

    public List<Integer> getLottoNumbers() {
        return numbers;
    }

    public int countMatch(Lotto winningLotto) {
        return (int) numbers.stream().
                filter(winningLotto::containNumber).
                count();
    }

    public boolean containNumber(int number) {
        return numbers.contains(number);
    }

}
