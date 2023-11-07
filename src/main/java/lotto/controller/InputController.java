package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.PurchaseAmountCalculator;
import lotto.domain.WinningNumbers;
import lotto.utils.Converter;
import lotto.utils.WinningNumbersValidator;
import lotto.view.InputView;

public class InputController {

    public int settingTicketQuantity() {
        int ticketQuantity = 0;
        while (ticketQuantity == 0) {
            ticketQuantity = tryInputTicketQuantity(ticketQuantity);
        }
        return ticketQuantity;
    }

    private int tryInputTicketQuantity(int ticketQuantity) {
        PurchaseAmountCalculator purchaseAmountCalculator = new PurchaseAmountCalculator();
        try {
            String inputPurchaseAmount = InputView.getPurchaseAmount();
            ticketQuantity = purchaseAmountCalculator.getTicketQuantity(inputPurchaseAmount);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
        return ticketQuantity;
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
            WinningNumbersValidator.validateMainNumbers(inputWinningNumbers);
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
            WinningNumbersValidator.validateBonusNumber(inputValue);

            int inputBonusNumber = Integer.parseInt(inputValue);
            bonusNumber = new BonusNumber(inputBonusNumber, mainNumbers);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
        return bonusNumber;
    }

}
