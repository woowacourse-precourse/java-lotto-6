package lotto.io.processor;

import camp.nextstep.edu.missionutils.Console;

public class InputProcessor {

    public void closeConsole() {
        Console.close();
    }

    public String inputValue() {
        return Console.readLine();
    }
}
