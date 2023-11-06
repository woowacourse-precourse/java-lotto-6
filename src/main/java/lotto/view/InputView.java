package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.ErrorMessage;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class InputView {
    public long readLongLine() {
        String input = readLine().trim();
        try {
            return Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LONG_FORMAT.getMessage());
        }
    }

    public int readIntLine() {
        return 0;
    }

    public List<Integer> readMultipleIntLine() {
        String input = readLine();
        List<String> parsedInput = splitAndTrim(input);
        try {
            return parsedInput.stream().map(Integer::parseInt).collect(Collectors.toList());
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MULTIPLE_INTEGER_FORMAT.getMessage());
        }
    }

    private List<String> splitAndTrim(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .toList();
    }

    private String readLine() {
        try {
            String input = Console.readLine();
            validateInput(input);
            return input;
        }
        catch (NoSuchElementException e) {
            throw new IllegalArgumentException(ErrorMessage.BLANK_INPUT.getMessage());
        }
    }

    private void validateInput(String input) {
        if(input == null || input.isBlank()) {
            throw new NoSuchElementException();
        }
    }
}
