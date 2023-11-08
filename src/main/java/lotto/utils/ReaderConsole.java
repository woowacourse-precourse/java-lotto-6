package lotto.utils;

import camp.nextstep.edu.missionutils.Console;

public class ReaderConsole implements Reader {
    @Override
    public String getInput() {
        return Console.readLine();
    }
}
