package lotto;

import lotto.Domain.Customer;
import lotto.Domain.LottoStore;

public class Application {
    public static void main(String[] args) {
        Customer customer = new Customer();
        LottoStore lottoStore = new LottoStore();
        customer.buyLotto(lottoStore);
    }
}
