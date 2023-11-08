package lotto.utils;

import java.util.List;

import static lotto.utils.Constants.NOT_INTEGER_ERROR;
import static lotto.utils.Constants.NOT_POSITIVE_NUMBER_ERROR;

public class Validator {

    public static void checkInteger(String text) {
        try {
            Integer.parseInt(text);
        } catch (IllegalArgumentException e) {
            System.out.println(NOT_INTEGER_ERROR);
        }
    }

    public static void validatePositiveNumbers(List<Integer> numbers) {
        numbers.forEach(number -> {
            if (number < 0) {
                System.out.println(NOT_POSITIVE_NUMBER_ERROR);
                throw new IllegalArgumentException();
            }
        });
    }
}
