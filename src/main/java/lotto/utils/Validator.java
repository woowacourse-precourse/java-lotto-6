package lotto.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static constant.MessageList.ERROR_INPUT_IS_NOT_NUMBER;
import static constant.MessageList.ERROR_INVALID_INPUT;

public class Validator {
    public int validateNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ERROR_INPUT_IS_NOT_NUMBER);
        }
    }

    public List<Integer> validateInput(String winningNumberFromPlayer) {
        try {
            List<String> temporary = Arrays.asList(winningNumberFromPlayer.split(","));
            List<Integer> winningNumber = temporary.stream()
                    .map(Integer::valueOf)
                    .collect(Collectors.toList());
            return winningNumber;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ERROR_INVALID_INPUT);
        }
    }
}
