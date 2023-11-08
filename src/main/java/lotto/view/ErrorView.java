package lotto.view;

import lotto.io.Writer;

public class ErrorView {
    private final Writer writer;

    public ErrorView(Writer writer) {
        this.writer = writer;
    }

    public void showErrorMessage(String message) {
        writer.writeLine(message);
    }
}
