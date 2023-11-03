package lotto.input;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInput implements Input {

    @Override
    public String read() {
        return Console.readLine();
    }
}
