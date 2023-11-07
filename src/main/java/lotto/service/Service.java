package lotto.service;

import lotto.domain.Buyer;
import lotto.view.Input;
import lotto.view.Output;

public class Service {

    public void purchaseLotto() {
        Buyer buyer = new Buyer(Input.inputAmount());
    }
}
