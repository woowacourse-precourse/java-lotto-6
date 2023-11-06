package lotto.controller.util.parser;

import java.util.Arrays;
import java.util.List;
import lotto.configuration.ErrorMessage;

public class InputParser {
    private static final String COMMA_SEPARATOR = ",";

    public Integer parseMoney(String rawInput) {
        return convertToInteger(rawInput);
    }

    public List<Integer> parseLottoNumbers(String rawInput) {
        return Arrays.stream(rawInput.split(COMMA_SEPARATOR))
                .map(this::convertToInteger)
                .toList();
    }

    public Integer parseBonusNumber(String rawInput) {
        return convertToInteger(rawInput);
    }

    private Integer convertToInteger(String rawInput) {
        try {
            return Integer.parseInt(rawInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NOT_NUMBER);
        }
    }
}
