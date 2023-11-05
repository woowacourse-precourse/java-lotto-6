package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.ExceptionMessage;

public class InputReader implements Reader {
    private String readLine() {
        String inputValue = Console.readLine().trim();
        validateBlank(inputValue);
        return inputValue;
    }

    @Override
    public String readString() {
        return readLine();
    }

    @Override
    public int readInt() {
        try {
            return Integer.parseInt(readLine());
        } catch (NumberFormatException e) {
            throw ExceptionMessage.INPUT_NUMBER_FORMAT.getException();
        }
    }

    private void validateBlank(String inputValue) {
        if (inputValue == null || inputValue.isBlank()) {
            throw ExceptionMessage.INPUT_BLANK.getException();
        }
    }
}
