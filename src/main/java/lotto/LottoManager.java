package lotto;

import lotto.io.ConsoleManager;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.ProfitRate;
import lotto.model.PurchaseAmount;
import lotto.model.PurchasePrice;
import lotto.model.WinningLotto;
import lotto.model.WinningProfit;
import lotto.model.WinningStatics;

public class LottoManager {

    private final ConsoleManager consoleManager;
    private final LottoBuyer lottoBuyer;
    private final LottoCalculator lottoCalculator;

    protected LottoManager() {
        this.consoleManager = new ConsoleManager();
        this.lottoBuyer = new LottoBuyer();
        this.lottoCalculator = new LottoCalculator();
    }

    protected void buyLotto() {
        PurchasePrice purchasePrice = consoleManager.inputPurchasePrice();

        PurchaseAmount purchaseAmount = lottoBuyer.getPurchaseAmount(purchasePrice);
        consoleManager.printLottoCount(purchaseAmount.getAmount());

        Lottos lottos = lottoBuyer.purchaseLottos(purchaseAmount);
        consoleManager.printLottos(lottos.getLottos());

        Lotto winningNumbers = consoleManager.inputWinningLottoNumbers();
        BonusNumber bonusNumber = consoleManager.inputBonusNumber();
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        WinningStatics statics = lottoCalculator.getWinningStatic(lottos, winningLotto);

        consoleManager.printStatics(statics);

        WinningProfit winningProfit = new WinningProfit(statics);

        ProfitRate profitRate = new ProfitRate(winningProfit, purchasePrice);

        consoleManager.printProfitRate(profitRate);

        consoleManager.close();
    }

}
