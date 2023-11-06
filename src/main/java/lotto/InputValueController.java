package lotto;

import view.InputView;

public class InputValueController {
    InputView inputView = new InputView();
    InputValidate inputValidate = new InputValidate();

    public void inputPurchaseAmount() {
        boolean isValidInput = false;

        while (!isValidInput) {
            String enteredPurchaseAmount = inputView.purchaseAmount();
            try {
                inputValidate.validatePurchaseAmount(enteredPurchaseAmount);
                isValidInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void inputPrizeNumber() {
        boolean isValidInput = false;

        while (!isValidInput) {
            String inputStr = inputView.prizeNumber();
            try {
                inputValidate.validatePrizeNumber(inputStr);
                isValidInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void inputBonusNumber() {
        boolean isValidInput = false;

        while (!isValidInput) {
            String bonusNumberTemp = inputView.bonusNumber();
            try {
                inputValidate.validateBonusNumber(bonusNumberTemp);
                isValidInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
