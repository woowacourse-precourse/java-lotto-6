package lotto;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
        Map<String, Integer> lottoWinningStatistics = lottoSystem.compareLottoNumbers(customer.getPurchasedLottoNumbers());

        OutView.printLottoWinningStatistics(lottoWinningStatistics);
        double result = customer.calculateRateOfReturn(lottoWinningStatistics);
    }
}
