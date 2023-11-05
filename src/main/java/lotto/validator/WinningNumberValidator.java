package lotto.validator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumberValidator {
    public List<Integer> validateAndParse(String userInput) {
        validateNotEmpty(userInput);
        return validateAndSeparateIntegers(userInput);
    }

    private void validateNotEmpty(String userInput) {
        if (userInput.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public static List<Integer> validateAndSeparateIntegers(String userInput) {
        try {
            return Arrays.stream(userInput.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
