package lotto.view;

import camp.nextstep.edu.missionutils.Console;
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
}
