package lotto.vo.request;

import static lotto.constants.ErrorMessage.NOT_INTEGER;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;

public class WinningNumberRequest {
    private static final String DELIMITER = ",";

    private final List<Integer> numbers;

    public WinningNumberRequest(String input) {
        List<String> parsedInput = parseInput(input);
        this.numbers = validateInteger(parsedInput);
    }

    private List<String> parseInput(String input) {
        String[] parsedInput = input.split(DELIMITER);
        return Arrays.stream(parsedInput)
            .map(String::trim)
            .collect(Collectors.toList());
    }

    private List<Integer> validateInteger(List<String> parsedInput) {
        try {
            return parsedInput.stream()
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INTEGER);
        }
    }

    public Lotto convertToValidLotto() {
        return new Lotto(numbers);
    }
}
