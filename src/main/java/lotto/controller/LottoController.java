package lotto.controller;

import lotto.validation.InputValidation;
import lotto.view.InputView;

public class LottoController {

    InputView inputView = new InputView();
    InputValidation inputValidation = new InputValidation();

    private static final int LOTTO_TICKET_PRIZE = 1000;

    public void lottoService() {
        String purchaseAmount = getPurchaseAmount();
        int numberOfLottoTickets = calculateNumberOfLottoTickets(purchaseAmount);

    }

    public String getPurchaseAmount() {
        String purchaseAmount = inputView.purchaseAmountInput();
        inputValidation.validatePurchaseAmountInput(purchaseAmount);
        return purchaseAmount;
    }

    public int calculateNumberOfLottoTickets(String purchaseAmount) {
        int parsedPurchaseAmount = Integer.parseInt(purchaseAmount);
        return parsedPurchaseAmount / LOTTO_TICKET_PRIZE;
    }

}
