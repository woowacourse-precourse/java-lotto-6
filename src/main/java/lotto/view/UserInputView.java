package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.validator.InputValidator;

public class UserInputView implements InputView {
    InputValidator inputValidator = new InputValidator();

    @Override
    public String getPurchaseMoneyInput() {
        String input = Console.readLine();
        inputValidator.validatePurchaseCostInputView(input);
        return input;
    }

    @Override
    public String getWinningNumbersInput() {
        String input = Console.readLine();
        inputValidator.validateWinningNumberInputView(input);
        return input;
    }

    @Override
    public String getBonusNumberInput() {
        String input = Console.readLine();
        inputValidator.validateBonusNumberInputView(input);
        return input;
    }

    public void close() {
        Console.close();
    }
}
