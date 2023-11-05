package lotto.input;

import camp.nextstep.edu.missionutils.Console;

//
public class ConsoleInputProvider implements InputProvider {
    @Override
    public String read() {
        return Console.readLine();
    }
}
