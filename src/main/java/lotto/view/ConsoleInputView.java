package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.exception.NumberTypeFormatException;

public class ConsoleInputView implements InputView {
    @Override
    public Integer readNumber() {
        String input = Console.readLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberTypeFormatException();
        }
    }

    @Override
    public List<Integer> readNumbers() {
        String input = Console.readLine();

        try {
            return Arrays.stream(input.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new NumberTypeFormatException();
        }
    }
}
