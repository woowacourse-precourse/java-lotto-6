package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.validation.NumericInputValidation;

public class InputValue {
    PrintUtil printUtil = new PrintUtil();
    NumericInputValidation numericInputValidation = new NumericInputValidation();

    public String getPurchaseAmountInput() {
        try {
            String userInput = Console.readLine();
            numericInputValidation.validateInputIsNull(userInput);
            return userInput;
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            printUtil.printPurchaseAmountInput();
            return getPurchaseAmountInput();
        }
    }

    public String getWinnerNumbersInput() {
        try {
            String userInput = Console.readLine();
            numericInputValidation.validateInputIsNull(userInput);
            return userInput;
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            printUtil.printWinnerNumbersInput();
            return getWinnerNumbersInput();
        }
    }

    public String getBonusNumberInput() {
        try {
            String userInput = Console.readLine();
            numericInputValidation.validateInputIsNull(userInput);
            return userInput;
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            printUtil.printBonusNumberInput();
            return getBonusNumberInput();
        }
    }
}
