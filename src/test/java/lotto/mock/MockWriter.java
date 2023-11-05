package lotto.mock;

import lotto.io.writer.Writer;

public class MockWriter implements Writer {
    private String output;

    @Override
    public void writeLine(String message) {
        output = message;
    }

    public String getOutput() {
        return output;
    }
}