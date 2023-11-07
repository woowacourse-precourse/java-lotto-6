package lotto;

import java.util.List;
import lotto.exception.InvalidInput;

public class StringConverter {

    public List<Integer> convertToIntegerList(List<String> numbers) {
        if (!validateList(numbers)) {
            throw new IllegalArgumentException();
        }
        return numbers.stream()
                .map(Integer::parseInt)
                .toList();
    }

    public int covertToInteger(String number) {
        if (!validateNumber(number)) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(number);
    }

    private boolean validateList(List<String> numbers) {
        for (String number : numbers) {
            if (validateNumber(number)) {
                continue;
            }
            return false;
        }
        return true;
    }

    private boolean validateNumber(String number) {
        InvalidInput invalidInput = new InvalidInput();
        return !invalidInput.notIntegerValueException(number);
    }
}
