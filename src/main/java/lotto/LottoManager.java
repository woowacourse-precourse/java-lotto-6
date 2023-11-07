package lotto;

import lotto.domain.Lotto;
import lotto.domain.profit.ProfitRate;
import lotto.domain.profit.WinningProfit;
import lotto.domain.purchase.PurchaseAmount;
import lotto.domain.purchase.PurchaseInfo;
import lotto.domain.purchase.PurchaseLottos;
import lotto.domain.purchase.PurchasePrice;
import lotto.domain.statics.WinningStatics;
import lotto.domain.winning.BonusNumber;
import lotto.domain.winning.WinningLotto;
import lotto.io.ConsoleManager;
import lotto.service.LottoBuyer;
import lotto.service.LottoCalculator;

public class LottoManager {

    private final ConsoleManager consoleManager;
    private final LottoBuyer lottoBuyer;
    private final LottoCalculator lottoCalculator;

    protected LottoManager() {
        this.consoleManager = new ConsoleManager();
        this.lottoBuyer = new LottoBuyer();
        this.lottoCalculator = new LottoCalculator();
    }

    protected void run() {
        final PurchaseInfo purchaseInfo = processPurchaseInfo();
        final WinningLotto winningLotto = processWinningLotto();

        final WinningStatics statics = processWinningStaticsTask(purchaseInfo, winningLotto);

        processProfitTask(statics, purchaseInfo);

        consoleManager.close();
    }

    private PurchaseInfo processPurchaseInfo() {
        final PurchasePrice purchasePrice = consoleManager.inputPurchasePrice();
        final PurchaseAmount purchaseAmount = lottoBuyer.getPurchaseAmount(purchasePrice);
        consoleManager.printLottoCount(purchaseAmount.getAmount());

        final PurchaseLottos purchaseLottos = lottoBuyer.purchaseLottos(purchaseAmount);
        consoleManager.printLottos(purchaseLottos.lottos());

        return new PurchaseInfo(purchasePrice, purchaseAmount, purchaseLottos);
    }

    private WinningLotto processWinningLotto() {
        final Lotto winningNumbers = consoleManager.inputWinningLottoNumbers();
        final BonusNumber bonusNumber = consoleManager.inputBonusNumber();
        return new WinningLotto(winningNumbers, bonusNumber);
    }

    private WinningStatics processWinningStaticsTask(
            final PurchaseInfo purchaseInfo,
            final WinningLotto winningLotto
    ) {
        final PurchaseLottos purchaseLottos = purchaseInfo.purchaseLottos();
        final WinningStatics statics = lottoCalculator.getWinningStatic(purchaseLottos, winningLotto);
        consoleManager.printStatics(statics);
        return statics;
    }

    private void processProfitTask(
            final WinningStatics statics,
            final PurchaseInfo purchaseInfo
    ) {
        final PurchasePrice purchasePrice = purchaseInfo.purchasePrice();
        final WinningProfit winningProfit = new WinningProfit(statics);
        final ProfitRate profitRate = new ProfitRate(winningProfit, purchasePrice);
        consoleManager.printProfitRate(profitRate);
    }

}
