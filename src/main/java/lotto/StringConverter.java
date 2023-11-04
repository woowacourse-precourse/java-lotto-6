package lotto;

import java.util.List;
import lotto.exception.InvalidInput;

public class StringConverter {

    public List<Integer> convertToIntegerList(List<String> numbers) {
        validateList(numbers);
        return numbers.stream()
                .map(Integer::parseInt)
                .toList();
    }

    private void validateList(List<String> numbers) {
        numbers.forEach(this::validateNumber);
    }

    private void validateNumber(String number){
        InvalidInput invalidInput = new InvalidInput();
        invalidInput.notIntegerValueException(number);
    }
}
