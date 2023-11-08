package lotto.view.reader;

import camp.nextstep.edu.missionutils.Console;

public class CustomReader implements Reader {

    private String input;

    public void initInput(final String input) {
        this.input = input;
    }

    @Override
    public String readLine() {
        return Console.readLine();
//        return this.input;
    }
}
