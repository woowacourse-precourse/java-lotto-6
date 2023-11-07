package lotto;

import java.io.Writer;

public class ConsoleWriter implements OutputWriter {
    @Override
    public void writeLine(String message) {
        System.out.println(message);
    }
}
