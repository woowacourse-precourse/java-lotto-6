package lotto.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WinningNumbersConverter {
    private static final String NOT_INTEGER_EXCEPTION_MESSAGE = "로또 번호는 정수여야 합니다.";

    public static List<Integer> convertToIntegerList(String numbers) {
        List<String> numbersSplit = Arrays.asList(numbers.split(","));
        List<Integer> numbersConverted = new ArrayList<>();

        for (String number : numbersSplit) {
            try {
                numbersConverted.add(Integer.parseInt(number.strip()));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(NOT_INTEGER_EXCEPTION_MESSAGE);
            }
        }
        return numbersConverted;
    }
}
