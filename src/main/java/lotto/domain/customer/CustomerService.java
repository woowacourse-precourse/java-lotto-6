package lotto.domain.customer;

import lotto.domain.lotto.Lotto;

import java.util.List;

public class CustomerService {
    private Customer customer;

    public CustomerService(Customer customer) {
        this.customer = customer;
    }

    public void buyLotto(List<Lotto> lottos) {
        customer.setLottos(lottos);
    }
}
