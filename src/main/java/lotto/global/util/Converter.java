package lotto.global.util;

import lotto.global.common.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class Converter {
    public static int convertStringToInt(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(ErrorMessage.ONLY_NUMBER.getMessage());
        }
    }

    public static List<Integer> convertStringToIntList(String input) {
        List<Integer> numbers = new ArrayList<>();
        try {
            for (String s : input.split(",")) {
                numbers.add(Integer.parseInt(s.trim()));
            }
            return numbers;
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ErrorMessage.ONLY_NUMBER.getMessage());
        }
    }
}
