package lotto.input;

import camp.nextstep.edu.missionutils.Console;

//
public class ConsoleInputReader implements InputReader {
    @Override
    public String read() {
        return Console.readLine();
    }
}
