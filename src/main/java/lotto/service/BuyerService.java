package lotto.service;

import lotto.domain.Buyer;
import lotto.view.InputView;

public class BuyerService {

    public Buyer generateBuyer() {
        String inputAmount = InputView.readLine();
        return Buyer.of(inputAmount);
    }
}
