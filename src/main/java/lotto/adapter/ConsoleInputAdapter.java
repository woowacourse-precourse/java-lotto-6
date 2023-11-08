package lotto.adapter;

import lotto.port.InputPort;
import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputAdapter implements InputPort {

    @Override
    public String readLine() {
        return Console.readLine();
    }
}