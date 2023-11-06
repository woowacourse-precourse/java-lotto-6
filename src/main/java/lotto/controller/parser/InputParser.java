package lotto.controller.parser;

import java.util.Arrays;
import java.util.List;
import lotto.configurations.ErrorMessage;

public class InputParser {
    private static final String SEPARATOR = ",";

    public Integer parseMoney(String rawInput) {
        return convertToInteger(rawInput);
    }

    public List<Integer> parseLottoNumbers(String rawInput) {
        List<String> splitNumbers = Arrays.stream(rawInput.split(SEPARATOR))
                .toList();

        return splitNumbers.stream()
                .map(this::convertToInteger)
                .toList();
    }

    public Integer parseBonusNumber(String rawInput) {
        return convertToInteger(rawInput);
    }

    private int convertToInteger(String rawInput) {
        try {
            return Integer.parseInt(rawInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NOT_NUMBER);
        }
    }
}
