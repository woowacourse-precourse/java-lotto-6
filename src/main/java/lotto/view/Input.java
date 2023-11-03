package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public String readMoney() {
        return read();
    }

    private String read() {
        return Console.readLine();
    }
}
