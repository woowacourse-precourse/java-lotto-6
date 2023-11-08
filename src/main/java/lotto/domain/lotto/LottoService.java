package lotto.domain.lotto;

import lotto.domain.customer.Customer;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    public Customer customer;

    public LottoService(Customer customer) {
        this.customer = customer;
    }

    public List<Lotto> drawLots() {
        List<Lotto> lottos = new ArrayList<>();
        int quantity = customer.getQuantity();
        for (int count = 0; count < quantity; count++) {
            List<Integer> numbers = NumberGenerator.createRandomNumbers();
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
        return lottos;
    }
}
