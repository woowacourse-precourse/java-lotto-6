package lotto.ui;

import lotto.view.InputReader;

public class TestInputReader implements InputReader {
    private String input;
    public TestInputReader(){
    }

    public void setInput(String input) {
        this.input = input;
    }

    @Override
    public String readInput(String message) {
        return input;
    }
}
