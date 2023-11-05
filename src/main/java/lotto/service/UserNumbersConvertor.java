package lotto.service;

import java.util.ArrayList;
import java.util.List;

public class UserNumbersConvertor {
    private static final String DELIMITER = ",";
    private static final String EMPTY = "";
    private static final String SPACE = " ";
    private static List<Integer> result = new ArrayList<>();

    public static List<Integer> convert(String userInput) {
        userInput = removeSpace(userInput);
        String[] numbers = split(userInput);
        add(numbers);

        return copyList();
    }

    private static String removeSpace(String userInput) {
        return userInput.replaceAll(SPACE, EMPTY);
    }

    private static String[] split(String userInput) {
        return userInput.split(DELIMITER);
    }

    private static void add(String[] numbers) {
        for (String number : numbers) {
            result.add(Integer.parseInt(number));
        }
    }

    private static List<Integer> copyList() {
        List<Integer> copy = result;
        result = new ArrayList<>();
        return copy;
    }
}
