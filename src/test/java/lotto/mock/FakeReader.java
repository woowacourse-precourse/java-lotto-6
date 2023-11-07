package lotto.mock;

import lotto.view.reader.Reader;

public class FakeReader implements Reader {

    private final String message;

    public FakeReader(String message) {
        this.message = message;
    }

    @Override
    public String readLine() {
        return this.message;
    }

}
