package lotto;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputService implements InputService{
    @Override
    public String readLine() {
        return Console.readLine();
    }
}
