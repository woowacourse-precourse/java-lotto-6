package lotto.validate;

import java.util.ArrayList;
import java.util.List;

public class InputValidate {

    private final static String ERROR_MESSAGE_NOT_NUMBER = "숫자가 아님: ";

    public int inputSingleNumberValidate(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_NUMBER + input);
        }
    }

    public List<Integer> inputNumbersIntegerValidate(List<String> givenNumbers) {
        List<Integer> checkedNumbers = new ArrayList<>();
        for (String number : givenNumbers) {
            try {
                int num = Integer.parseInt(number);
                checkedNumbers.add(num);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ERROR_MESSAGE_NOT_NUMBER + number);
            }
        }
        return checkedNumbers;
    }
}
