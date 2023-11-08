package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.regex.Pattern;
import lotto.enums.ErrorMessages;

public class NumberGenerator {
    public static List<Integer> formatNumbers(String input) {
        String[] numbers = input.split(",", -1);
        List<Integer> result = new ArrayList<>();

        for (String number : numbers) {
            result.add(formatNumber(number));
        }
        return result;
    }

    public static Integer formatNumber(String input) {
        validate(input);
        return Integer.valueOf(input);
    }


    private static void validate(String input) {
        if (input == null) {
            System.out.println(ErrorMessages.NOT_EMPTY.getErrorMessage());
            throw new IllegalArgumentException(ErrorMessages.NOT_EMPTY.getErrorMessage());
        }
        if (!Pattern.matches("^[0-9]*$", input)) {
            System.out.println(ErrorMessages.ONLY_NUMBER.getErrorMessage());
            throw new NoSuchElementException(ErrorMessages.ONLY_NUMBER.getErrorMessage());
        }
    }
}
