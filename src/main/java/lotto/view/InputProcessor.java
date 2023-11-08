package lotto.view;

import lotto.error.ErrorMessage;
import java.util.Arrays;
import java.util.List;

public class InputProcessor {

    private static final String COMMA = ",";

    public Integer toPaidAmount(String input) {
        input = input.trim();
        validateNotNull(input);
        return toNumber(input.trim());
    }

    public List<Integer> toWinningNumbers(String input) {
        input = input.trim();
        validateNotNull(input);
        return parseWith(input, COMMA);
    }

    public Integer toBonusNumber(String input) {
        input = input.trim();
        validateNotNull(input);
        return toNumber(input.trim());
    }

    private void validateNotNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException(ErrorMessage.NULL_ERROR.getMessage());
        }
    }

    private Integer toNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMERIC.getMessage());
        }
    }

    private List<Integer> parseWith(String input, String mark) {
        return Arrays.stream(input.split(mark))
                .map(String::trim)
                .map(this::toNumber)
                .toList();
    }

}
