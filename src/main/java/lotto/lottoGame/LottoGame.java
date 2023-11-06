package lotto.lottoGame;

import lotto.customer.Customer;

public class LottoGame {
    private Customer initCustomer() {
        Customer initCustomer = new Customer();
        return initCustomer;
    }

    public void run() {

        Customer customer = initCustomer();
    }
}
