package lotto.view;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.Validator;

public class InputView {
    public InputInfo inputPurchaseAmount() {
        String userInput = Console.readLine();
        return new InputInfo(Validator.VALIDATOR.getInputValidator().inputPurchaseAmountValidation(userInput),
                userInput);
    }

    public InputInfo inputWinningNumbers() {
        String userInput = Console.readLine();
        return new InputInfo(null, userInput);
    }

    public List<String> splitUserInput(String userInput) {
        return null;
    }
}
