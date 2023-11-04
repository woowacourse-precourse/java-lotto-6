package lotto.ui;

import lotto.ui.reader.InputReader;

public class TestInputReader implements InputReader {
    private String input;
    public TestInputReader(){
    }

    public void setInput(String input) {
        this.input = input;
    }

    @Override
    public String readInput() {
        return input;
    }
}
