package lotto.view.input;

import lotto.view.input.reader.Reader;

public abstract class ReaderView {
    protected final Reader reader;

    public ReaderView(final Reader reader) {
        this.reader = reader;
    }
}
