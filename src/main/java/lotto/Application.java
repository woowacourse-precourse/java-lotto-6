package lotto;

import java.util.List;
import lotto.Domain.Customer;
import lotto.Domain.LottoStore;
import lotto.Domain.LottoSystem;
import lotto.View.InputView;
import lotto.View.OutView;

public class Application {
    public static void main(String[] args) {
        Customer customer = new Customer();
        LottoStore lottoStore = new LottoStore();
        String lottoPurchaseAmount = InputView.inputLottoPurchaseAmount();
        List<Lotto> purchasedLottos = customer.buyLotto(lottoStore, lottoPurchaseAmount);
        OutView.printPurchasedLottos(customer.getPurchasedLottoNumbers());
        String lottoWinningNumber = InputView.inputLottoWinningNumber();
        String lottoBonusNumber = InputView.inputLottoBonusNumber();
        LottoSystem lottoSystem = new LottoSystem(lottoWinningNumber, lottoBonusNumber);
    }
}
