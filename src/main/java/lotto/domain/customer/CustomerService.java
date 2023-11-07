package lotto.domain.customer;

import lotto.domain.lotto.Lotto;

import java.util.List;

public class CustomerService {
    public void buyLotto(Customer customer, List<Lotto> lottos) {
        customer.setLottos(lottos);
    }
}
