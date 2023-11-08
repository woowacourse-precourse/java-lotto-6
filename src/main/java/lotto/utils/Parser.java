package lotto.utils;

import java.util.Arrays;
import java.util.List;

public class Parser {

    public static int parseToInt(String userInput) {
        try {
            return Integer.parseInt(userInput.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닙니다");
        }
    }

    public static List<Integer> parseToIntegers(String userInput) {
        String[] inputs = userInput.split(",");
        return Arrays.stream(inputs)
                .map(string -> parseToInt(string.trim()))
                .toList();
    }
}
