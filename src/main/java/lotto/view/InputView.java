package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.InputConstant;
import lotto.validation.InputValidator;

public class InputView {

    private final InputValidator inputValidator;

    public InputView(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public String inputPurchaseAmount() {
        System.out.println(InputConstant.PURCHASE_AMOUNT.getMessage());
        String purchaseAmount = getUserInput();
        inputValidator.validateUserInput(purchaseAmount);
        return purchaseAmount;
    }

    public String inputWinningNumber() {
        System.out.println(InputConstant.WINNING_NUMBER.getMessage());
        String winningNumber = getUserInput();
        inputValidator.validateUserInput(winningNumber.replaceAll(",", ""));
        return winningNumber;
    }

    public String inputBonusNumber() {
        System.out.println(InputConstant.BONUS_NUMBER.getMessage());
        String bonusNumber = getUserInput();
        inputValidator.validateUserInput(bonusNumber);
        return bonusNumber;
    }

    private String getUserInput() {
        return Console.readLine();
    }
}
