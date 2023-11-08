package lotto.view.output.writer;

import java.io.PrintStream;

public final class ConsoleWriter implements Writer {
    private final PrintStream standardOut;

    public ConsoleWriter() {
        standardOut = System.out;
    }

    @Override
    public void print(final String text) {
        standardOut.print(text);
    }

    @Override
    public void println(final String text) {
        standardOut.println(text);
    }

}
