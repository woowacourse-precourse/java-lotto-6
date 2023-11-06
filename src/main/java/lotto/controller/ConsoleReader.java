package lotto.controller;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleReader implements Reader {

    @Override
    public String readLine() {
        return Console.readLine();
    }

    @Override
    public void close() {
        Console.close();
    }
}
