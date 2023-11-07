package lotto.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidatorForModel {
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
        return numbers.size() == 6;
    }

    private boolean checkInputBounds(List<Integer> numbers) {
        for (int number : numbers) {
            if (!(1 <= number && number <= 45)) {
                return false;
            }
        }
        return true;
    }
}