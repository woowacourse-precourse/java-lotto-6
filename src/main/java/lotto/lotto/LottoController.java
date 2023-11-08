package lotto.lotto;

import java.util.List;
import lotto.bonus.BonusNumber;
import lotto.money.LottoMoney;
import lotto.ranking.Ranking;
import lotto.statistics.Statistics;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.common.ErrorMessageView;
import lotto.view.statistics.LottoProfitOutputView;
import lotto.view.statistics.LottoStaticsOutputView;

public class LottoController {

    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void start() {
        LottoMoney lottoMoney = receiveMoney();
        LottoPaper lottoPaper = buyLottoPaper(lottoMoney);
        processLottoGame(lottoPaper, lottoMoney);
    }

    private LottoPaper buyLottoPaper(LottoMoney lottoMoney) {
        LottoPaper lottoPaper = new LottoPaper(makeLottoPaper(lottoMoney));
        OutputView.buyLottoPaper(lottoMoney, lottoPaper);
        return lottoPaper;
    }

    private List<Lotto> makeLottoPaper(LottoMoney lottoMoney) {
        return lottoService.makeLottoPaper(lottoMoney);
    }

    private LottoMoney receiveMoney() {
        try {
            OutputView.inputMoney();
            return InputView.getMoney();
        } catch (IllegalArgumentException e) {
            ErrorMessageView.printError(e);
            return receiveMoney();
        }
    }

    private WinningLotto receiveWinningLotto() {
        try {
            OutputView.inputWinningLotto();
            return InputView.getWinnerLotto();
        } catch (IllegalArgumentException e) {
            ErrorMessageView.printError(e);
            return receiveWinningLotto();
        }
    }

    private BonusNumber receiveBonusNumber(WinningLotto winningLotto) {
        try {
            OutputView.inputBonusNumber();
            return InputView.getBonusNumber(winningLotto);
        } catch (IllegalArgumentException e) {
            ErrorMessageView.printError(e);
            return receiveBonusNumber(winningLotto);
        }
    }

    private void processLottoGame(LottoPaper lottoPaper, LottoMoney lottoMoney) {
        WinningLotto winningLotto = receiveWinningLotto();
        BonusNumber bonusNumber = receiveBonusNumber(winningLotto);
        Statistics results = calculateStatistics(lottoPaper, winningLotto, bonusNumber);
        showStatistics(lottoMoney, results);
    }

    private Statistics calculateStatistics(LottoPaper lottoPaper, WinningLotto winningLotto, BonusNumber bonusNumber) {
        List<Ranking> rankings = lottoPaper.calculateRankings(winningLotto, bonusNumber);
        return new Statistics(rankings);
    }

    private void showStatistics(LottoMoney lottoMoney, Statistics statistics) {
        LottoStaticsOutputView.showStatists(statistics);
        LottoProfitOutputView.showProfit(statistics, lottoMoney);
    }
}
