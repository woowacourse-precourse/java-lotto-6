package lotto.io;

public class ConsoleWriter implements Writer {
    @Override
    public void writeLine(String sentence) {
        System.out.println(sentence);
    }
}
