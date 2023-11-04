package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;
import lotto.validation.InputValidation;

public class InputValue {
    PrintUtil printUtil = new PrintUtil();
    InputValidation inputValidation = new InputValidation();

    public String getPurchaseAmountInput() {
        try {
            String userInput = Console.readLine();
            inputValidation.validateInputIsNull(userInput);
            return userInput;
        } catch (NullPointerException nullPointerException) {
            System.out.println(nullPointerException.getMessage());
            printUtil.printPurchaseAmountInput();
            return getPurchaseAmountInput();
        }
    }
}
