package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static InputView inputView;

    private InputView() {
    }

    public static InputView getInstance() {
        if (inputView == null) {
            inputView = new InputView();
        }
        return inputView;
    }

    private String readInput() {
        return Console.readLine();
    }

    public int readAmount() {
        try {
            String input = readInput();
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
