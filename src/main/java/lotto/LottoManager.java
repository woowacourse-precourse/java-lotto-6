package lotto;

import java.util.List;
import java.util.Map;
import lotto.io.ConsoleManager;
import lotto.vo.PurchaseAmount;
import lotto.vo.PurchasePrice;

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

        List<Lotto> lottos = lottoBuyer.purchaseLottos(purchaseAmount.getAmount());
        consoleManager.printLottos(lottos);

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
