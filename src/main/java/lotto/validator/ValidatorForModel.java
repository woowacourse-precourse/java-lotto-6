package lotto.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidatorForModel {
    public static final int LOTTO_NUMBER_MIN = 1;
    public static final int LOTTO_NUMBER_MAX = 45;
    public static final int LOTTO_NUMBER_COUNT = 6;

    public ValidatorForModel() {
    }

    public void validate(List<Integer> numbers) {
        if (!isNumbersValid(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isNumbersValid(List<Integer> numbers) {
        boolean duplicatesValid = checkForDuplicates(numbers);
        boolean sizeValid = checkInputSizeIs6(numbers);
        boolean boundsValid = checkInputBounds(numbers);
        return duplicatesValid && sizeValid && boundsValid;
    }

    private boolean checkForDuplicates(List<Integer> numbers) {
        Set<Integer> compareNumbers = new HashSet<>(numbers);
        return compareNumbers.size() == numbers.size();
    }

    private boolean checkInputSizeIs6(List<Integer> numbers) {
        return numbers.size() == LOTTO_NUMBER_COUNT;
    }

    private boolean checkInputBounds(List<Integer> numbers) {
        for (int number : numbers) {
            if (!(LOTTO_NUMBER_MIN <= number && number <= LOTTO_NUMBER_MAX)) {
                return false;
            }
        }
        return true;
    }
}