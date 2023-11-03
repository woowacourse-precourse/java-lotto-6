package lotto;

import java.util.List;
import lotto.exception.InvalidInput;

public class StringConverter {
    private final InvalidInput invalidInput = new InvalidInput();

    public List<Integer> convertToIntegerList(List<String> numbers) {
        validateList(numbers);
        return numbers.stream()
                .map(Integer::parseInt)
                .toList();
    }

    public int parseInt(String number) {
        invalidInput.notIntegerValueException(number);

        return Integer.parseInt(number);
    }

    private void validateList(List<String> numbers) {
        for (String number : numbers) {
            invalidInput.notIntegerValueException(number);
        }
    }
}
