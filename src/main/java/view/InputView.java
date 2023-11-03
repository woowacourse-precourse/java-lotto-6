package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String read() {
        return Console.readLine();
    }

    public void close() {
        Console.close();
    }
}
