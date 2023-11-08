package io.input;

import camp.nextstep.edu.missionutils.Console;
import io.exception.BlankInputException;
import io.exception.NullInputException;

/**
 * FD 0번 STDIN으로부터 바이트 열을 읽어옵니다.
 */
public final class ConsoleReader implements Reader {
    @Override
    public String readLine() {
        final String input = Console.readLine();
        if (input == null) {
            throw new NullInputException();
        }
        if (input.isBlank()) {
            throw new BlankInputException();
        }
        return input;
    }
}
