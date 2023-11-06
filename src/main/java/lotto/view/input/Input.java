package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;

public abstract class Input {

    public String readLine() {
        String input;

        while (true) {
            try {
                input = Console.readLine();
                validate(input);
                break;
            } catch (IllegalArgumentException ignored) {

            }
        }

        return input;
    }

    protected abstract void validate(String input);
}
