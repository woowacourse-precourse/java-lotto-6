package lotto.lottoGame;

import lotto.customer.Customer;
import lotto.view.InputView;

public class LottoGame {
    private Customer initCustomer() {
        String inputPurchaseValue = InputView.inputPrice();
        return new Customer(inputPurchaseValue);
    }

    public void run() {
        Customer customer = initCustomer();
    }
}
