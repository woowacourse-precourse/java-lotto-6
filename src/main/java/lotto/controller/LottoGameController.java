package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.domain.dto.LottoDto;
import lotto.domain.dto.LottoResultDto;
import lotto.utils.LottoPurchaser;
import lotto.utils.NumberGenerator;
import lotto.utils.ProfitRateCalculator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final ProfitRateCalculator profitRateCalculator;
    private final NumberGenerator numberGenerator;

    public LottoGameController(final InputView inputView,
                               final OutputView outputView,
                               final ProfitRateCalculator profitRateCalculator,
                               final NumberGenerator numberGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.profitRateCalculator = profitRateCalculator;
        this.numberGenerator = numberGenerator;
    }

    public void run() {
        Money money = getMoney();
        Lottos lottos = getLottos(money);
        WinningLotto winningLotto = getWinningLotto();
        LottoResult results = getResults(lottos, winningLotto);
        getProfitRate(money,results);
        inputView.close();
    }

    private void getProfitRate(Money money, LottoResult lottoResult) {
        double profitRate = profitRateCalculator.calculateProfitRate(
                lottoResult.getTotalProfit(), money.purchasedMoney());
        outputView.printProfitRate(profitRate);
    }

    private LottoResult getResults(Lottos lottos, WinningLotto winningLotto) {
        LottoResult lottoResult = new LottoResult();
        lottoResult.result(lottos, winningLotto);
        outputView.printWinningResults(LottoResultDto.from(lottoResult));
        return lottoResult;
    }

    private WinningLotto getWinningLotto() {
        List<Integer> winningNumbers = inputView.getWinningNumbers();
        Lotto lotto = new Lotto(winningNumbers);
        LottoNumber bonusNumber = inputView.getBonusNumber(lotto);
        return new WinningLotto(lotto, bonusNumber);
    }

    private Lottos getLottos(Money money) {
        int purchased = purchasedLotto(money);

        Lottos lottos = new Lottos();
        while (purchased > 0) {
            Lotto lotto = numberGenerator.generate();
            if (!lottos.contain(lotto)) {
                lottos.add(lotto);
                outputView.printPurchasedLottos(LottoDto.from(lotto));
                purchased--;
            }
        }
        return lottos;
    }

    private int purchasedLotto(Money money) {
        LottoPurchaser lottoPurchaser = new LottoPurchaser(money);
        int purchased = lottoPurchaser.purchase();
        outputView.printPurchasedLottoSize(purchased);
        return purchased;
    }

    public Money getMoney() {
        return inputView.getMoney();
    }

}
