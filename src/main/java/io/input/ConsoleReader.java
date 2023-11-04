package io.input;

import camp.nextstep.edu.missionutils.Console;

public final class ConsoleReader implements Reader {
    @Override
    public String readLine() {
        return Console.readLine().trim();
    }
}
