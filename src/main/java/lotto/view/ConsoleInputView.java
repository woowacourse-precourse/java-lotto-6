package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.io.PrintStream;

public class ConsoleInputView extends InputView {
    private final PrintStream standardOut;

    public ConsoleInputView() {
        this.standardOut = System.out;
    }

    @Override
    protected String read() {
        return Console.readLine();
    }

    @Override
    protected void println(final String text) {
        standardOut.println(text);
    }
}
