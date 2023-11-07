package lotto;

public class ConsoleWriter implements OutputWriter {
    @Override
    public void writeLine(String message) {
        System.out.println(message);
    }

    public void writeLineWithoutNewLine(String message) {
        System.out.print(message);
    }
}
