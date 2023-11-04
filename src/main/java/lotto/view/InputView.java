package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.Validator;

public class InputView {
    public InputInfo inputPurchaseAmount() {
        String userInput = Console.readLine();
        return new InputInfo(Validator.VALIDATOR.getInputValidator().inputPurchaseAmountValidation(userInput),
                userInput);
    }
}
