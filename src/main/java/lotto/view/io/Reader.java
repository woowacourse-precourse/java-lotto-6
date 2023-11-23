package lotto.view.io;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.exception.LottoException;

public class Reader {
    public int getInteger() {
        String input = Console.readLine();
        return parseInt(input);
    }

    public List<Integer> getIntegers(String delimiter) {
        String input = Console.readLine();
        validateNotEndDelimiter(input, delimiter);
        return Arrays.stream(input.split(delimiter))
                .map(this::parseInt)
                .toList();
    }

    private void validateNotEndDelimiter(String input, String delimiter) {
        if (input.substring(input.length() - 1).equals(delimiter)) {
            throw LottoException.INPUT_INVALID_FORMAT.makeException();
        }
    }

    private int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw LottoException.INPUT_NUMBER_FORMAT.makeException();
        }
    }

}
