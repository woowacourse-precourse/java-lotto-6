package lotto.view;

import java.io.PrintStream;

public class ConsoleResultView extends ResultView {
    private final PrintStream standardOut;

    public ConsoleResultView() {
        this.standardOut = System.out;
    }

    @Override
    public void println(final String text) {
        standardOut.println(text);
    }
}
