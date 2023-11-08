package console;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private Input() {
    }

    public static Input create() {
        return new Input();
    }

    public String read() {
        return Console.readLine();
    }

    public void close() {
        Console.close();
    }
}
