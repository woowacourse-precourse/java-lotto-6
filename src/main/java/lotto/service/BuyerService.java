package lotto.service;

import static lotto.view.constants.ViewMessage.GET_PURCHASE_AMOUNT_MESSAGE;

import lotto.domain.Buyer;
import lotto.exception.LottoException;
import lotto.view.InputView;
import lotto.view.OutputView;

public class BuyerService {

    public Buyer generateBuyer() {
        while (true) {
            try {
                OutputView.printMessage(GET_PURCHASE_AMOUNT_MESSAGE);
                String inputAmount = InputView.readLine();
                return Buyer.of(inputAmount);
            } catch (LottoException e) {
                OutputView.printMessage(e.getMessage());
            }
        }
    }
}
