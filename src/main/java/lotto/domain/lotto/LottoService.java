package lotto.domain.lotto;

import lotto.domain.customer.Customer;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    public List<Lotto> drawLots(Customer customer) {
        List<Lotto> lottos = new ArrayList<>();
        int quantity = customer.getQuantity();
        for (int count = 0; count < quantity; count++) {
            List<Integer> numbers = NumberGenerator.CreateRandomNumbers();
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
        return lottos;
    }
}
