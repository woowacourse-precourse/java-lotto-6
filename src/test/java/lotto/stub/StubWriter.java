package lotto.stub;

import lotto.io.writer.Writer;

public class StubWriter implements Writer {
    private final StringBuilder output = new StringBuilder();

    @Override
    public void writeLine(String message) {
        output.append(message).append(System.lineSeparator());
    }

    public String getOutput() {
        return output.toString();
    }
}