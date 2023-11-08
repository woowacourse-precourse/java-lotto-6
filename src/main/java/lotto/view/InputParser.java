package lotto.view;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import lotto.exception.EndWithCommaException;
import lotto.exception.NotNumberInputException;

public class InputParser {
    public int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NotNumberInputException();
        }
    }

    public List<Integer> parsingNumbers(String input) {
        if (input.endsWith(",")) {
            throw new EndWithCommaException();
        }
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(this::parseInt)
                .collect(toList());
    }



}
