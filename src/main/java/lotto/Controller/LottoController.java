package lotto.Controller;

import static lotto.View.InputView.inputLottoBonusNumber;
import static lotto.View.InputView.inputLottoWinningNumber;
import static lotto.View.OutView.printLottoWinningStatistics;
import static lotto.View.OutView.printPurchasedLottos;
import static lotto.View.OutView.printRateOfReturn;

import java.util.List;
import java.util.Map;
import lotto.Domain.Customer;
import lotto.Domain.LottoStore;
import lotto.Domain.LottoSystem;
import lotto.Domain.Lotto;
import lotto.View.InputView;

public class LottoController {
    private Customer customer;
    private LottoStore lottoStore;
    private LottoSystem lottoSystem;

    public void run() {
        customer = new Customer();
        lottoStore = new LottoStore();
        lottoTicketOrder();

        lottoSystem = new LottoSystem();
        initLottoWinningNumber();
        initLottoBonusNumber();

        Map<String, Integer> lottoWinningStatistics = handleLottoWinngingStatistics();

        handleLottoRateOfReturn(lottoWinningStatistics);
    }

    private Map<String, Integer> handleLottoWinngingStatistics() {
        Map<String, Integer> lottoWinningStatistics = lottoSystem.compareLottoNumbers(
                customer.getPurchasedLottoNumbers());

        printLottoWinningStatistics(lottoWinningStatistics);
        return lottoWinningStatistics;
    }

    private void handleLottoRateOfReturn(Map<String, Integer> lottoWinningStatistics) {
        double totalLottoReward = lottoStore.caculateTotalLottoReward(lottoWinningStatistics);
        double rateOfReturn = customer.calculateRateOfReturn(totalLottoReward);

        printRateOfReturn(rateOfReturn);
    }

    private void lottoTicketOrder() {
        try {
            String lottoPurchaseAmount = InputView.inputLottoPurchaseAmount();
            customer.buyLotto(lottoStore, lottoPurchaseAmount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            lottoTicketOrder();
        }
        printPurchasedLottos(customer.getPurchasedLottoNumbers());
    }

    private void initLottoWinningNumber() {
        try {
            lottoSystem.storeLottoWinningNumber(inputLottoWinningNumber());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            initLottoWinningNumber();
        }
    }

    private void initLottoBonusNumber() {
        // 보너스 번호 입력
        try {
            lottoSystem.storeLottoBonusNumber(inputLottoBonusNumber());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            initLottoBonusNumber();
        }
    }
}
