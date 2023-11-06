package lotto.controller;

import java.util.Arrays;
import java.util.List;

public class PromptParser {
    private static final String REGEX = ",";
    private static final int NO_LIMIT = -1;
    public int integer(String input) {
        return Integer.parseInt(input);
    }

    public List<Integer> integerList(String input) {

        List<Integer> numbers = Arrays.stream(input.split(REGEX, NO_LIMIT))
                .map(String::strip)
                .map(Integer::parseInt)
                .toList();

        return numbers;
    }
}
