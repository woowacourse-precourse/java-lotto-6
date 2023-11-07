package lotto.io;

public class ConsoleWriter implements OutputWriter {
    @Override
    public void writeLine(final String message) {
        System.out.println(message);
    }

    public void writeLineWithoutNewLine(final String message) {
        System.out.print(message);
    }
}
