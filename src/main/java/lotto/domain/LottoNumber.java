package lotto.domain;

import lotto.service.InputValue;
import lotto.service.PrintUtil;
import lotto.validation.InputValidation;

import java.util.List;

public class LottoNumber {

    InputValue inputValue = new InputValue();

    PrintUtil printUtil = new PrintUtil();

    InputValidation inputValidation = new InputValidation();

    public int inputPurchaseAmount() {
        printUtil.printPurchaseAmountInput();
        try {
            int userInputNumber = inputValidation.validatePurchaseAmount(inputValue.getPurchaseAmountInput());
            return userInputNumber;
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return inputPurchaseAmount();
        }
    }

    public Lotto inputWinnerNumbers() {
        printUtil.printWinnerNumbersInput();
        try {
            List<Integer> winnerNumbers = inputValidation.validateWinnerNumbers(inputValue.getWinnerNumbersInput());
            Lotto lotto = new Lotto(winnerNumbers);
            return lotto;
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return inputWinnerNumbers();
        }
    }


}
