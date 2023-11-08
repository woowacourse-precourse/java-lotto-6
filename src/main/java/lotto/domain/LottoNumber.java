package lotto.domain;

import lotto.service.InputValue;
import lotto.service.PrintUtil;
import lotto.validation.BonusNumberValidation;
import lotto.validation.PurchaseAmountValidation;
import lotto.validation.WinningNumbersValidation;

import java.util.List;

public class LottoNumber {

    InputValue inputValue = new InputValue();

    PrintUtil printUtil = new PrintUtil();

    PurchaseAmountValidation purchaseAmountValidation = new PurchaseAmountValidation();
    WinningNumbersValidation winningNumbersValidation = new WinningNumbersValidation();
    BonusNumberValidation bonusNumberValidation = new BonusNumberValidation();

    public int inputPurchaseAmount() {
        printUtil.printPurchaseAmountInput();
        try {
            int userInputNumber = purchaseAmountValidation.validatePurchaseAmount(inputValue.getPurchaseAmountInput());
            return userInputNumber;
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return inputPurchaseAmount();
        }
    }

    public Lotto inputWinnerNumbers() {
        printUtil.printWinnerNumbersInput();
        try {
            List<Integer> winnerNumbers = winningNumbersValidation.validateWinnerNumbers(inputValue.getWinnerNumbersInput());
            Lotto lotto = new Lotto(winnerNumbers);
            return lotto;
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return inputWinnerNumbers();
        }
    }

    public int inputBonusNumber(Lotto lotto) {
        printUtil.printBonusNumberInput();
        try {
            int bonusNumber = bonusNumberValidation.validateBonusNumber(inputValue.getBonusNumberInput());
            bonusNumberValidation.validateDuplicateBonusNumber(lotto, bonusNumber);
            return bonusNumber;
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return inputBonusNumber(lotto);
        }
    }
}
//커밋, 기능목록 정리