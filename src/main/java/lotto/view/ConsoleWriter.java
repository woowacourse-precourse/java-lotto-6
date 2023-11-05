package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleWriter implements Writer {

    @Override
    public String getInput() {
        return readLine();
    }

    @Override
    public void close() {
        Console.close();
    }
}
