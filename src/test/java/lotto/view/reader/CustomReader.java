package lotto.view.reader;

public class CustomReader implements Reader {

    private String input;

    public void initInput(final String input) {
        this.input = input;
    }

    @Override
    public String readLine() {
        return this.input;
    }
}
