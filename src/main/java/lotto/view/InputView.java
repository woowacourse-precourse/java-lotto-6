package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.ErrorMessage;

import java.util.List;

public class InputView {
    public long readLongLine() {
        String input = readLine();
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
        return List.of(0);
    }

    private String readLine() {
        return Console.readLine();
    }
}
