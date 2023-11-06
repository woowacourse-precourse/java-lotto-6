package lotto.util.parser;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.constant.ErrorMessage;

public class WinningNumbersParser implements InputParser<List<Integer>> {

    @Override
    public List<Integer> parse(String input) {
        validateIsNotBlank(input);
        return convertToNumbers(input);
    }

    private void validateIsNotBlank(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.IS_BLANK);
        }
    }

    private List<Integer> convertToNumbers(String input) {
        try {
            return Arrays.stream(input.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_A_NUMBER);
        }
    }
}
