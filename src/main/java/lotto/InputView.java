package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String getPurchaseAmountInput() {
        String input = Console.readLine();
        Validator.validateIsBlank(input);
        Validator.validateIsInteger(input);
        return input;
    }
}