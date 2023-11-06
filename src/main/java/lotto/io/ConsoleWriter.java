package lotto.io;

public class ConsoleWriter implements Writer {
    @Override
    public void write(String contextWithOutLine) {
        System.out.print(contextWithOutLine);
    }

    @Override
    public void writeLine(String sentence) {
        System.out.println(sentence);
    }

    public void writeFormat(String format, Object... args) {
        System.out.printf(format, args);
    }
}
