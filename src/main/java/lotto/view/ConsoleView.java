package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public sealed class ConsoleView permits InputView, OutputView {

    protected void print(final String message) {
        System.out.print(message);
    }

    protected void println(final String message) {
        System.out.println(message);
    }

    protected void lineBreak() {
        System.out.println();
    }

    protected String read() {
        return Console.readLine();
    }
}
