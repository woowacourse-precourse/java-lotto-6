package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.InputValidator;

public class PurchaseCostInputView implements InputView {
    InputValidator inputValidator = new InputValidator();

    @Override
    public String getUserInput() {
        String input = Console.readLine();
        inputValidator.validatePurchaseCostInputView(input);
        return input;
    }
}
