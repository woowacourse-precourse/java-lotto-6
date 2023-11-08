package lotto.view;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;

public class InputParser {
    public int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> parsingNumbers(String input) {
        if (input.endsWith(",")) {
            throw new IllegalArgumentException();
        }
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(this::parseInt)
                .collect(toList());
    }



}
