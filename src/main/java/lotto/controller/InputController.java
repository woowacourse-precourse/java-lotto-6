package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningNumbers;
import lotto.utils.Converter;
import lotto.utils.InputValidator;
import lotto.view.InputView;

public class InputController {

    InputValidator inputValidator;

    public InputController() {
        this.inputValidator = new InputValidator();
    }

    public PurchaseAmount settingPurchaseAmount() {
        PurchaseAmount purchaseAmount = null;
        while (purchaseAmount == null) {
            purchaseAmount = tryGetPurchaseAmount();
        }

        return purchaseAmount;
    }

    private PurchaseAmount tryGetPurchaseAmount() {
        PurchaseAmount purchaseAmount = null;
        try {
            String inputPurchaseAmount = InputView.getPurchaseAmount();
            inputValidator.validatePurchaseAmount(inputPurchaseAmount);
            int amount = Converter.stringToInt(inputPurchaseAmount);
            purchaseAmount = new PurchaseAmount(amount);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
        return purchaseAmount;
    }

    public WinningNumbers settingWinningNumbers() {
        Lotto mainNumbers = settingMainNumbers();
        BonusNumber bonusNumber = settingBonusNumber(mainNumbers);

        WinningNumbers winningNumbers = new WinningNumbers(mainNumbers, bonusNumber);
        return winningNumbers;
    }

    private Lotto settingMainNumbers() {
        Lotto mainNumbers = null;
        while (mainNumbers == null) {
            mainNumbers = tryGetMainNumbers(mainNumbers);
        }
        return mainNumbers;
    }

    private Lotto tryGetMainNumbers(Lotto mainNumbers) {
        try {
            String inputWinningNumbers = InputView.getWinningNumbers();
            inputWinningNumbers = Converter.deleteSpace(inputWinningNumbers);
            inputValidator.validateMainNumbers(inputWinningNumbers);
            mainNumbers = Converter.stringToLotto(inputWinningNumbers);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
        return mainNumbers;
    }

    private BonusNumber settingBonusNumber(Lotto mainNumbers) {
        BonusNumber bonusNumber = null;
        while (bonusNumber == null) {
            bonusNumber = tryGetBonusNumber(mainNumbers);
        }
        return bonusNumber;
    }

    private BonusNumber tryGetBonusNumber(Lotto mainNumbers) {
        BonusNumber bonusNumber = null;
        try {
            String inputValue = InputView.getBonusNumber();
            inputValue = Converter.deleteSpace(inputValue);
            inputValidator.validateBonusNumber(inputValue);

            int inputBonusNumber = Integer.parseInt(inputValue);
            bonusNumber = new BonusNumber(inputBonusNumber, mainNumbers);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
        return bonusNumber;
    }

}
