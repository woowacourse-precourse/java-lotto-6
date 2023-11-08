package lotto;


import java.util.Arrays;
import java.util.List;
import lotto.exception.InvalidInput;

public class StringConverter {
    private static final String COMMA = ",";

    public List<Integer> convertToIntegerList(String numbers) {
        List<String> splitedNumbers = convertToStringList(numbers);
        if (!validateList(splitedNumbers)) {
            throw new IllegalArgumentException();
        }

        return splitedNumbers.stream()
                .map(Integer::parseInt)
                .toList();
    }

    public int covertToInteger(String number) {
        if (!validateNumber(number)) {
            throw new IllegalArgumentException();
        }

        return Integer.parseInt(number);
    }

    private List<String> convertToStringList(String numbers) {
        if (!validateCommaSeparatedFormat(numbers)) {
            throw new IllegalArgumentException();
        }

        String[] inputNumbers =  numbers.split(COMMA);
        return Arrays.stream(inputNumbers).toList();
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

    private boolean validateCommaSeparatedFormat(String numbers) {
        InvalidInput invalidInput = new InvalidInput();
        return !invalidInput.commaSeparatedFormatException(numbers);
    }

    private boolean validateNumber(String numbers) {
        InvalidInput invalidInput = new InvalidInput();
        return !invalidInput.notIntegerValueException(numbers);
    }

}
