package lotto;

import java.util.List;
import lotto.controller.LotteryStore;
import lotto.domain.Money;
import lotto.domain.RateOfReturn;
import lotto.domain.WinningLotto;
import lotto.domain.WinningStatistics;
import lotto.dto.PurchasedLottosDto;
import lotto.view.ConsoleMessageView;
import lotto.view.LottoStaticsOutputView;
import lotto.view.MoneyInputView;
import lotto.view.PurchasedLottoOutputView;
import lotto.view.RateOfReturnOutputView;
import lotto.view.WinningLottoInputView;

public class LottoApplication {

    private static final long CURRENCY = 1000;

    Money money;
    LotteryStore lottoStore = new LotteryStore();

    public void run() {
        String money = getMoneyFromUserInput();
        storeMoneyOf(money);

        lottoStore.getLottoOrderUpTo((int) this.money.showCountConvertTo(CURRENCY));

        PurchasedLottosDto purchasedLottos = fetchPurchasedLottos();
        printFrom(purchasedLottos);

        List<String> winningLottoNumbers = WinningLottoInputView.inputWinningLottoNumbers();
        String bonusNumber = WinningLottoInputView.inputBonusNumber();
        WinningLotto winningLotto = createWinningLottoFrom(winningLottoNumbers, bonusNumber);

        WinningStatistics statistics = lottoStore.calculateStatisticsWith(winningLotto);
        printFrom(statistics);

        RateOfReturn rateOfReturn = RateOfReturn.from(this.money.showMoney(), statistics.showRevenue());
        printFrom(rateOfReturn);
    }

    private String getMoneyFromUserInput() {
        ConsoleMessageView.printMoneyInputMessage();
        return MoneyInputView.input();
    }

    private void storeMoneyOf(String money) {
        this.money = Money.of(money);
    }

    private PurchasedLottosDto fetchPurchasedLottos() {
        return lottoStore.showPurchasedLottos();
    }

    private void printFrom(PurchasedLottosDto purchasedLottosDto) {
        int count = purchasedLottosDto.show()
                                      .size();
        PurchasedLottoOutputView.outputPurchasedCount(count);
        PurchasedLottoOutputView.outputPurchasedLottos(purchasedLottosDto.show());
    }

    public WinningLotto createWinningLottoFrom(List<String> winningLottoNumbers, String BonusNumber) {
        return new WinningLotto(winningLottoNumbers, BonusNumber);

    }

    private void printFrom(WinningStatistics winningStatistics) {
        LottoStaticsOutputView.outputFrom(winningStatistics);
    }

    private void printFrom(RateOfReturn rateOfReturn) {
        RateOfReturnOutputView.outputRateOfReturn(rateOfReturn);
    }

}
