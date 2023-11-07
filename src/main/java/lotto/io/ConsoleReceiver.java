package lotto.io;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleReceiver implements InputReceiver {
    @Override
    public String readLine() {
        return Console.readLine();
    }

    @Override
    public void close() {
        Console.close();
    }
}
