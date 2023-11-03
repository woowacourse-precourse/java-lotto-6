package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInput implements Input {

    @Override
    public String getInput() {
        return readLine();
    }

    @Override
    public void close() {
        Console.close();
    }
}
