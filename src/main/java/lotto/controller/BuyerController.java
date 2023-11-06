package lotto.controller;

import static lotto.view.constants.ViewMessage.GET_PURCHASE_AMOUNT_MESSAGE;

import lotto.domain.Buyer;
import lotto.exception.LottoException;
import lotto.service.BuyerService;
import lotto.view.OutputView;

public class BuyerController {
    private final BuyerService buyerService = new BuyerService();
    public Buyer createBuyer() {
        while (true) {
            OutputView.printMessage(GET_PURCHASE_AMOUNT_MESSAGE);
            try {
                return buyerService.generateBuyer();
            } catch (LottoException e) {
                OutputView.printMessage(e.getMessage());
            }
        }
    }
}
