package lotto;

import java.util.List;
import java.util.Map;
import lotto.io.ConsoleManager;

public class LottoManager {

    private final ConsoleManager consoleManager;
    private final LottoBuyer lottoBuyer;
    private final LottoCalculator lottoCalculator;

    protected LottoManager() {
        this.consoleManager = new ConsoleManager();
        this.lottoBuyer = new LottoBuyer(consoleManager);
        this.lottoCalculator = new LottoCalculator();
    }

    protected void buyLotto() {
        int lottoPrice = lottoBuyer.payLotto();

        int lottoCount = lottoBuyer.getLottoCount(lottoPrice);
        consoleManager.printLottoCount(lottoCount);

        List<Lotto> lottos = lottoBuyer.purchaseLottos(lottoCount);
        consoleManager.printLotto(lottos);

        Lotto winningLotto = consoleManager.inputWinningLottoNumbers();

        BonusNumber bonusNumber = consoleManager.inputBonusNumber(winningLotto);

        Map<WinningType, Integer> statics = lottoCalculator.getMatchStatics(lottos, winningLotto, bonusNumber);

        consoleManager.printStatics(statics);

        int profit = lottoCalculator.getLottosProfit(statics);

        float profitRate = lottoCalculator.getProfitRate(profit, lottoPrice);

        consoleManager.printProfitRate(profitRate);
    }

}
