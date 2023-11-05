package lotto.util.io.input;

import camp.nextstep.edu.missionutils.Console;

public class Keyboard implements Input {
    @Override
    public String GetData() {
        return Console.readLine();
    }

    public void close() {
        Console.close();
    }
}
