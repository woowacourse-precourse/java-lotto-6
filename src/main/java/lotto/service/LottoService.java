package lotto.service;

import lotto.domain.*;

public class LottoService {

    private Customer customer;
    private Lucky lucky;
    private ResultRepository resultRepository = new ResultRepository();

    public LottoService(Customer customer, Lucky lucky) {
        this.customer = customer;
        this.lucky = lucky;
    }

    public void buyLotto() {
        customer.pay();
    }


}
