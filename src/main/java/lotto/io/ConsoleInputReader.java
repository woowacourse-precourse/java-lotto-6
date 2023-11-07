package lotto.io;

import camp.nextstep.edu.missionutils.Console;

final class ConsoleInputReader implements InputReader{
    @Override
    public String readLine() {
        return Console.readLine();
    }
}
