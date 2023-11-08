package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class LottoConsoleService implements ConsoleService {
    @Override
    public String readLine() {
        return Console.readLine();
    }

    @Override
    public void close() {
        Console.close();
    }
}
