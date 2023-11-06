package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public int readAmount() {
        String input = Console.readLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
