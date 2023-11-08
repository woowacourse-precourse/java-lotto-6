package lotto.controller.utils;

import static lotto.controller.constants.ErrorMessage.INVALID_INPUT;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputParser {
    public int parseToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT.getMessage());
        }
    }

    public List<Integer> parseLottoNumbers(String input) {
        String[] numberStrings = input.split(",");
        return Arrays.stream(numberStrings)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

}
