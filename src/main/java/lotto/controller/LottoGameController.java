package lotto.controller;

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

        LottoPlayer lottoPlayer = createLottoPlayer();

        int numberOfLottoTickets = lottoPlayer.getNumberOfLottoTickets();
        OutputView.outputNumberOfLottoTicks(numberOfLottoTickets);

        LottoPlayerNumbers lottoPlayerNumbers = generateLottoPlayerNumbers(numberOfLottoTickets);
        OutputView.outputLottoPlayerNumbers(lottoPlayerNumbers);

        Lotto lotto = getLotto();

        WinningLotto winningLotto = createWinningLotto(lotto);
        Statistics statistics = calculateStatistics(lottoPlayerNumbers, winningLotto);
        OutputView.outputStatistics(statistics);

        ProfitCalculator profitCalculator = calculateProfit(lottoPlayer.getPurchaseMoney(), statistics);
        OutputView.outputProfitRatio(profitCalculator);
    }

    private LottoPlayer createLottoPlayer() {
        try {
            return new LottoPlayer(InputView.inputPurchaseMoney());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return createLottoPlayer();
        }
    }

    private LottoPlayerNumbers generateLottoPlayerNumbers(int numberOfLottoTickets) {
        return new LottoPlayerNumbers(numberOfLottoTickets);
    }

    private WinningLotto createWinningLotto(Lotto lotto) {
        try {
            return new WinningLotto(lotto, getBonusNumber());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return createWinningLotto(lotto);
        }
    }

    private Lotto getLotto() {
        try {
            return new Lotto(InputView.inputWinningLottoNumber());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getLotto();
        }
    }

    private BonusNumber getBonusNumber() {
        try {
            return new BonusNumber(InputView.inputBonusNumber());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getBonusNumber();
        }
    }

    private Statistics calculateStatistics(LottoPlayerNumbers lottoPlayerNumbers, WinningLotto winningLotto) {
        return new Statistics(lottoPlayerNumbers, winningLotto);
    }

    private ProfitCalculator calculateProfit(int purchaseMoney, Statistics statistics) {
        return new ProfitCalculator(purchaseMoney, statistics);
    }
}
