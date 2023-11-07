package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final InputFormValidation validation = new InputFormValidation();

    private InputView() {
    }

    public static InputView getInstance() {
        return new InputView();
    }

    public Integer inputNumber() {
        String input = input();
        validation.isNumber(input);
        return Integer.parseInt(input);
    }

    private String input() {
        return Console.readLine();
    }
}
