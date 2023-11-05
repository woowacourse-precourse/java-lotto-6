package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String returnInput() {
        return Console.readLine();
    }

    public void closeConsole() {
        Console.close();
    }
}
