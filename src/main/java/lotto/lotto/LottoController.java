package lotto.lotto;

import java.util.List;
import lotto.bonus.BonusNumber;
import lotto.money.Money;
import lotto.statistics.RankingResults;
import lotto.statistics.Statistics;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void run() {
        List<Lotto> lottos = buyLottos(receiveMoney());
        aggregateResult(lottos);
    }

    private List<Lotto> buyLottos(Money money) {
        List<Lotto> lottos = lottoService.makeLottos(money);
        OutputView.buyLottos(money, lottos);
        return lottos;
    }

    private Money receiveMoney() {
        try {
            OutputView.inputMoney();
            return InputView.getMoney();
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
            return receiveMoney();
        }
    }

    private WinningLotto receiveWinningLotto() {
        try {
            OutputView.inputWinningLotto();
            return InputView.getWinnerLotto();
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
            return receiveWinningLotto();
        }
    }

    private BonusNumber receiveBonusNumber() {
        try {
            OutputView.inputBonusNumber();
            return InputView.getBonusNumber();
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
            return receiveBonusNumber();
        }
    }

    private void aggregateResult(List<Lotto> lottos) {
        WinningLotto winningLotto = receiveWinningLotto();
        BonusNumber bonusNumber = receiveBonusNumber();
        RankingResults results = RankingResults.of(lottos, winningLotto, bonusNumber);
        Statistics statistics = new Statistics(results.getRankings());
    }
}
