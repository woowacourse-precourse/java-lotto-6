package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public abstract class Input {

    public String readLine() {
        String input = Console.readLine();
        validate(input);
        return input;
    }

    protected abstract void validate(String input);
}
