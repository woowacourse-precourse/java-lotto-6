package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public sealed class ConsoleView permits InputView {

    protected void print(final String message) {
        System.out.print(message);
    }

    protected void println(final String meesage) {
        System.out.println(meesage);
    }

    protected void lineBreak() {
        System.out.println();
    }

    protected String read() {
        return Console.readLine();
    }
}
