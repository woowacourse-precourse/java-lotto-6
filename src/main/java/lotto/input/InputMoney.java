package lotto.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.input.validator.InputMoneyValidator;

public class InputMoney {
    private static final String MESSAGE_INPUT_PURCHASE_AMOUNT = "구입 금액을 입력해 주세요.";

    private static final InputMoneyValidator inputMoneyValidator = InputMoneyValidator.getInstance();

    private String input = "";

    public String getUserInput() {
        System.out.println(MESSAGE_INPUT_PURCHASE_AMOUNT);
        input = Console.readLine();
        validate(input);
        return input;
    }

    private void validate(String input) {
        inputMoneyValidator.validate(input);
    }
}
