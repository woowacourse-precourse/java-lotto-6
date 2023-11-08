package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningNumbers;
import lotto.dto.ConsumerDto;
import lotto.dto.WinningLottoDto;
import lotto.utils.Converter;
import lotto.utils.InputValidator;
import lotto.view.InputView;

public class InputController {

    InputValidator inputValidator;
    InputView inputView;

    public InputController() {
        this.inputValidator = new InputValidator();
        this.inputView = new InputView();
    }

    public void settingPurchaseAmount(ConsumerDto consumerDto) {
        PurchaseAmount purchaseAmount = null;
        while (purchaseAmount == null) {
            purchaseAmount = tryGetPurchaseAmount();
        }

        consumerDto.setPurchaseAmount(purchaseAmount);

    }

    private PurchaseAmount tryGetPurchaseAmount() {
        PurchaseAmount purchaseAmount = null;
        try {
            String inputPurchaseAmount = inputView.getPurchaseAmount();
            inputPurchaseAmount = Converter.deleteSpace(inputPurchaseAmount);
            inputValidator.validatePurchaseAmount(inputPurchaseAmount);

            int amount = Converter.stringToInt(inputPurchaseAmount);
            purchaseAmount = new PurchaseAmount(amount);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
        return purchaseAmount;
    }

    public void settingWinningNumbers(WinningLottoDto winningLottoDto) {
        Lotto mainNumbers = settingMainNumbers();
        BonusNumber bonusNumber = settingBonusNumber(mainNumbers);

        WinningNumbers winningNumbers = new WinningNumbers(mainNumbers, bonusNumber);
        winningLottoDto.setWinningNumbers(winningNumbers);

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
            String inputWinningNumbers = inputView.getWinningNumbers();
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
            String inputValue = inputView.getBonusNumber();
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
