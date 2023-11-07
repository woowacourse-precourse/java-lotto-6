package lotto.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.input.validator.InputMoneyValidator;

public class InputMoney {
    private static final String MESSAGE_INPUT_PURCHASE_AMOUNT = "구입 금액을 입력해 주세요.";

    private static final InputMoneyValidator inputMoneyValidator = InputMoneyValidator.getInstance();

    private boolean isError = true;
    private String input = "";

    public String getUserInput() {
        System.out.println(MESSAGE_INPUT_PURCHASE_AMOUNT);
        do {
            input = Console.readLine();
            try {
                inputMoneyValidator.validate(input);
                isError = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (isError == true);
        return input;
    }
}
