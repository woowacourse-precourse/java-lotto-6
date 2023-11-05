package lotto.mock;


import lotto.io.reader.Reader;

public class MockReader implements Reader {
    private String input;

    @Override
    public String readLine() {
        return input;
    }

    @Override
    public void close() {
    }

    public void setInput(String input) {
        this.input = input;
    }
}