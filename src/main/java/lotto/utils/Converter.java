package lotto.utils;

import lotto.model.ErrorMessages;

import java.util.Arrays;
import java.util.List;

public class Converter {

    public static Integer stringToInt(String purchaseAmount) throws IllegalArgumentException {
        try {
            return Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.NOT_NUMBER.value());
        }
    }

    public static List<Integer> stringToIntList(String numbers, String delimiter) throws IllegalArgumentException {
        try {
            return Arrays.stream(numbers.split(delimiter))
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.NOT_NUMBER.value());
        }
    }
}
