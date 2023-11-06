package lotto.io;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleAdapter {
    private String input;

    public String readLine() {
        return Console.readLine();
    }
    public void close() {
        Console.close();
    }

    public void setInput(String input) {
        this.input = input;
    }
}