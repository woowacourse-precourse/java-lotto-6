package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.util.ErrorMessage;

public class InputView {

    public int readInteger() {
        String input = Console.readLine().strip();

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INTEGER_FORMAT.getMessage());
        }
    }

    public List<Integer> readIntegerList() {
        String input = Console.readLine().strip();

        try {
            List<String> tokens = Arrays.stream(input.split(","))
                    .map(String::strip)
                    .toList();

            return tokens.stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INTEGER_FORMAT.getMessage());
        }
    }
}
