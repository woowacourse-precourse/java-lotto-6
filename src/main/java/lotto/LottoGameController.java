package lotto;

import java.util.List;
import lotto.config.AppConfig;
import lotto.utils.NumberGenerator;
import lotto.utils.ProfitRateCalculator;

public class LottoGameController {

    private final AppConfig appConfig;

    public LottoGameController(final AppConfig appConfig) {
        this.appConfig = appConfig;
    }

    public void run() {
        Money money = getMoney();
        LottoPurchaser lottoPurchaser = new LottoPurchaser(money);
        int purchased = lottoPurchaser.purchase();
        OutputView outputView = appConfig.outputView();
        outputView.printPurchasedLottoSize(purchased);

        NumberGenerator numberGenerator = appConfig.numberGenerator();
        Lottos lottos = new Lottos();
        while (purchased > 0) {
            Lotto lotto = numberGenerator.generate();
            if (!lottos.contain(lotto)) {
                lottos.add(lotto);
                outputView.printPurchasedLottos(LottoDto.from(lotto));
                purchased--;
            }
        }

        InputView inputView = appConfig.inputView();
        List<Integer> winningNumbers = inputView.getWinningNumbers();
        Lotto lotto = new Lotto(winningNumbers);
        LottoNumber bonusNumber = inputView.getBonusNumber(lotto);
        WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);

        LottoResult lottoResult = new LottoResult();
        lottoResult.result(lottos, winningLotto);
        outputView.printWinningResults(LottoResultDto.from(lottoResult));

        ProfitRateCalculator profitRateCalculator = appConfig.profitRateCalculator();
        double profitRate = profitRateCalculator.calculateProfitRate(
                lottoResult.getTotalProfit(),
                lottoPurchaser.purchaseMoney());
        outputView.printProfitRate(profitRate);
    }

    public Money getMoney() {
        InputView inputView = appConfig.inputView();
        return inputView.getMoney();
    }

}
