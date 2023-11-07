package lotto.validator.input;

import lotto.exception.input.EmptyInputException;

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
            throw new EmptyInputException("입력이 비었습니다.");
        }
    }

    public static List<Integer> validateAndSeparateIntegers(String userInput) {
        try {
            return Arrays.stream(userInput.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new NumberFormatException("정수 형태의 입력이 쉼표로 구분 되어야 합니다.");
        }
    }
}
