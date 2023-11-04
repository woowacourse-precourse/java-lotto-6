package lotto.reader;

import camp.nextstep.edu.missionutils.Console;

public class NextStepConsoleReader implements InputReader{
    @Override
    public String readLine() {
        return Console.readLine();
    }

    @Override
    public void close() {
        Console.close();
    }
}
