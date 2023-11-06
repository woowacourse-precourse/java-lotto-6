package lotto.view;

import java.io.PrintStream;

public class ConsoleResultView extends ResultView {
    private static final PrintStream standardOut = System.out;

    @Override
    public void println(final String text) {
        standardOut.println(text);
    }
}
