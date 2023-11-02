package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validation.InputValidator;

public class InputView {

    private InputView() {
    }

    public static String inputPurchasePrice() {
        String purchasePrice = Console.readLine();
        try {
            InputValidator.validatePurchasePrice(purchasePrice);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return inputPurchasePrice();
        }
        return purchasePrice;
    }

    public static String inputWinningNumbers() {
        String winningNumbers = Console.readLine();
        try {
            InputValidator.validateWinningNumber(winningNumbers);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return inputWinningNumbers();
        }
        return winningNumbers;
    }

    public static String inputBonusNumber() {
        String bonusNumber = Console.readLine();
        try {
            InputValidator.validateBonusNumber(bonusNumber);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return inputBonusNumber();
        }
        return bonusNumber;
    }
}
