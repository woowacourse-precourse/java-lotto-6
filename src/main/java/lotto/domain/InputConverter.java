package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputConverter {
    public List<Integer> convertToWinningNumbers(String input) {
        List<String> splitInput = splitByComma(input);
        hasOnlyNumbers(splitInput);
        List<Integer> numbers = new ArrayList<>();
        for (String number : splitInput) {
            numbers.add(Integer.parseInt(number));
        }
        return numbers;
    }

    private List<String> splitByComma(String input) {
        return Arrays.asList(input.split(","));
    }

    private void hasOnlyNumbers(List<String> numbers) {
        for (String number : numbers) {
            if (!number.matches("^[0-9]*$")) {
                throw new IllegalArgumentException();
            }
        }
    }

    public int convertToMoneyOrBonusNumber(String input) {
        isOnlyNumber(input);
        return Integer.parseInt(input);
    }

    private void isOnlyNumber(String bonusNumber) {
        if (!bonusNumber.matches("^[0-9]*$")) {
            throw new IllegalArgumentException();
        }
    }
}
