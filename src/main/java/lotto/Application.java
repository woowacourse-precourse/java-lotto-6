package lotto;

import java.util.List;
import lotto.Domain.Customer;
import lotto.Domain.LottoStore;
import lotto.View.OutView;

public class Application {
    public static void main(String[] args) {
        Customer customer = new Customer();
        LottoStore lottoStore = new LottoStore();
        List<Lotto> purchasedLottos = customer.buyLotto(lottoStore);
        OutView.printPurchasedLottos(customer.getPurchasedLottoNumbers(), customer.getLottoQuantity());
    }
}
