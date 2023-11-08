package lotto.controller;

import java.util.List;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.LottoPlayer;
import lotto.model.LottoPlayerNumbers;
import lotto.model.ProfitCalculator;
import lotto.model.Statistics;
import lotto.model.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {

    public void run() {
        String purchaseMoney = InputView.inputPurchaseMoney();
        LottoPlayer lottoPlayer = createLottoPlayer(purchaseMoney);
        int numberOfLottoTickets = lottoPlayer.getNumberOfLottoTickets();
        OutputView.outputNumberOfLottoTicks(numberOfLottoTickets);

        LottoPlayerNumbers lottoPlayerNumbers = generateLottoPlayerNumbers(numberOfLottoTickets);
        OutputView.outputLottoPlayerNumbers(lottoPlayerNumbers);

        WinningLotto winningLotto = createWinningLotto();
        Statistics statistics = calculateStatistics(lottoPlayerNumbers, winningLotto);
        OutputView.outputStatistics(statistics);

        ProfitCalculator profitCalculator = calculateProfit(lottoPlayer.getPurchaseMoney(), statistics);
        OutputView.outputProfitRatio(profitCalculator);
    }

    private LottoPlayer createLottoPlayer(String purchaseMoney) {
        return new LottoPlayer(purchaseMoney);
    }

    private LottoPlayerNumbers generateLottoPlayerNumbers(int numberOfLottoTickets) {
        return new LottoPlayerNumbers(numberOfLottoTickets);
    }

    private WinningLotto createWinningLotto() {
        Lotto lotto = getLotto();
        BonusNumber bonusNumber = getBonusNumber();

        return new WinningLotto(lotto, bonusNumber);
    }

    private Lotto getLotto() {
        List<Integer> winningLotto = InputView.inputWinningLottoNumber();
        return new Lotto(winningLotto);
    }

    private BonusNumber getBonusNumber() {
        String bonusNumber = InputView.inputBonusNumber();
        return new BonusNumber(bonusNumber);
    }

    private Statistics calculateStatistics(LottoPlayerNumbers lottoPlayerNumbers, WinningLotto winningLotto) {
        return new Statistics(lottoPlayerNumbers, winningLotto);
    }

    private ProfitCalculator calculateProfit(int purchaseMoney, Statistics statistics) {
        return new ProfitCalculator(purchaseMoney, statistics);
    }
}
