package lotto.ui.reader;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class ConsoleInputReader implements InputReader{
    @Override
    public String readInput() {
        return readLine();
    }
}
