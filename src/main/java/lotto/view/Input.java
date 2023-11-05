package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public abstract class Input {

    protected boolean isInvalidInput = true;

    public String readLine() {
        String input = "";
        while (isInvalidInput) {
            try {
                input = Console.readLine();
                validate(input);
                isInvalidInput = false;
            } catch (IllegalArgumentException ignored) {

            }
        }
        return input;
    }

    protected abstract void validate(String input);
}
