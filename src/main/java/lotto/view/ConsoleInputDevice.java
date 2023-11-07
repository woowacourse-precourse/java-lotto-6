package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputDevice implements InputDevice {
    @Override
    public String getInput() {
        return Console.readLine();
    }
}
