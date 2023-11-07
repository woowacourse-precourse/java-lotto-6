package lotto;

import java.util.Map;
import lotto.io.ConsoleManager;
import lotto.model.Lottos;
import lotto.model.PurchaseAmount;
import lotto.model.PurchasePrice;

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

        Lotto winningLotto = consoleManager.inputWinningLottoNumbers();

        BonusNumber bonusNumber = consoleManager.inputBonusNumber(winningLotto);

        Map<WinningType, Integer> statics = lottoCalculator.getMatchStatics(lottos, winningLotto, bonusNumber);

        consoleManager.printStatics(statics);

        int profit = lottoCalculator.getLottosProfit(statics);

        float profitRate = lottoCalculator.getProfitRate(profit, purchasePrice.getPrice());

        consoleManager.printProfitRate(profitRate);

        consoleManager.close();
    }

}
