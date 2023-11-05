package lotto.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserNumbersUtils {
    private static final String DELIMITER = ",";
    private static final String EMPTY = "";
    private static final String SPACE = " ";
    private static List<Integer> result;

    public static List<Integer> convert(String userInput) {
        result = new ArrayList<>();
        userInput = removeSpace(userInput);
        String[] numbers = split(userInput);
        add(numbers);

        return result;
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

    public static List<Integer> sort(List<Integer> numbers) {
        result = new ArrayList<Integer>(numbers);
        Collections.sort(result);
        return result;
    }
}
