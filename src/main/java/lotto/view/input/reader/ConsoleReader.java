package lotto.view.input.reader;

import camp.nextstep.edu.missionutils.Console;

public final class ConsoleReader implements Reader {
    @Override
    public String read() {
        return Console.readLine();
    }
}
