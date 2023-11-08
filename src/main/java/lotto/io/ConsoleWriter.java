package lotto.io;

public class ConsoleWriter implements Writer {
    @Override
    public void writeLine(String sentence) {
        System.out.println(sentence);
    }
    @Override
    public void writeFormat(String format, Object... args) {
        System.out.printf(format, args);
    }
}
