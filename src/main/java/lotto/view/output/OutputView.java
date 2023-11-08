package lotto.view.output;

import lotto.view.output.writer.Writer;

public abstract class OutputView {
    protected Writer writer;

    protected OutputView(Writer writer) {
        this.writer = writer;
    }

    public void printNewLine() {
        writer.println("");
    }
}
