package lotto.controller;

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
        Lotto winningLotto = settingMainNumbers();

        WinningNumbers winningNumbers = getBonusNumber(winningLotto);

        return winningNumbers;
    }

    private Lotto settingMainNumbers() {
        Lotto winningLotto = null;
        while (winningLotto == null) {
            winningLotto = tryGetMainNumbers(winningLotto);
        }
        return winningLotto;
    }

    private Lotto tryGetMainNumbers(Lotto winningLotto) {
        try {
            String inputWinningNumbers = InputView.getWinningNumbers();
            inputWinningNumbers = Converter.deleteSpace(inputWinningNumbers);
            WinningNumbersValidator.validateMainNumbers(inputWinningNumbers);
            winningLotto = Converter.stringToLotto(inputWinningNumbers);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
        return winningLotto;
    }

    private WinningNumbers getBonusNumber(Lotto winningLotto) {
        WinningNumbers winningNumbers = null;
        while (winningNumbers == null) {
            winningNumbers = tryGetBonusNumber(winningLotto, winningNumbers);
        }
        return winningNumbers;
    }

    private WinningNumbers tryGetBonusNumber(Lotto winningLotto, WinningNumbers winningNumbers) {
        try {
            String inputBonusNumber = InputView.getBonusNumber();
            inputBonusNumber = Converter.deleteSpace(inputBonusNumber);
            WinningNumbersValidator.validateBonusNumber(inputBonusNumber);
            int bonusNumber = Integer.parseInt(inputBonusNumber);
            winningNumbers = new WinningNumbers(winningLotto, bonusNumber);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
        return winningNumbers;
    }

}
