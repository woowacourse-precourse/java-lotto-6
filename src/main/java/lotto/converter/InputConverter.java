package lotto.converter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.constants.messages.Error;

public class InputConverter {
    public long convertToMoney(String input) {
        exceptEmpty(input);
        isOnlyNumber(input);
        return Long.parseLong(input);
    }

    public int convertToBonusNumber(String input) {
        exceptEmpty(input);
        isOnlyNumber(input);
        return Integer.parseInt(input);
    }

    private void exceptEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(Error.NO_EMPTY);
        }
    }

    private void isOnlyNumber(String input) {
        if (!input.matches("^[0-9]*$")) {
            throw new IllegalArgumentException(Error.NOT_NUMBER);
        }
    }

    public List<Integer> convertToWinningNumbers(String input) {
        exceptEmpty(input);
        List<String> splitInput = splitByComma(input);
        exceptEmptyBetweenNumbers(splitInput);
        hasOnlyNumbers(splitInput);
        return parseSplitInput(splitInput);
    }

    private List<String> splitByComma(String input) {
        return Arrays.asList(input.split(","));
    }

    private void exceptEmptyBetweenNumbers(List<String> splitInput) {
        for (String element : splitInput) {
            if (element.isEmpty()) {
                throw new IllegalArgumentException(Error.NO_EMPTY_BETWEEN_NUMBERS);
            }
        }
    }

    private void hasOnlyNumbers(List<String> numbers) {
        for (String number : numbers) {
            if (!number.matches("^[0-9]*$")) {
                throw new IllegalArgumentException(Error.NOT_JUST_NUMBERS);
            }
        }
    }

    private  List<Integer> parseSplitInput(List<String> splitInput) {
        List<Integer> numbers = new ArrayList<>();
        for (String number : splitInput) {
            numbers.add(Integer.parseInt(number));
        }
        return numbers;
    }
}
