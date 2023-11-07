package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputConverter {

    public int convertToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.PREFIX.message + ErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE.message);
        }
    }

    public List<Integer> convertToListOfInteger(String input) {
        String[] inputNumbers = sort(input);
        List<Integer> numbers = new ArrayList<>();
        for (String inputNumber : inputNumbers) {
            numbers = List.of(convertToInteger(inputNumber));
        }
        return numbers;
    }

    private String[] sort(String input) {
        return Arrays.stream(input.split(","))
                .sorted()
                .toArray(String[]::new);
    }
}
