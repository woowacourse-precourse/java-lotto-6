package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.PrintMessages;
import lotto.validators.InputValidator;

import java.util.List;

public class InputHandler {
    public static String purchasePrice() {
        String priceInput;

        while (true) {
            try {
                priceInput = Console.readLine();
                InputValidator.validatePriceInput(priceInput);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return priceInput;
    }

    public static String winningNumber() {
        String winnigNumberInput;

        while (true) {
            try {
                winnigNumberInput = Console.readLine();
                InputValidator.validateWinnigNumberInput(winnigNumberInput);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return winnigNumberInput;
    }

    public static String bonusNumber(List<String> winningNumbers) {
        String bonusNumberInput;

        while (true) {
            try {
                bonusNumberInput = Console.readLine();
                InputValidator.validateBonusNumberInput(bonusNumberInput, winningNumbers);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return bonusNumberInput;
    }
}
