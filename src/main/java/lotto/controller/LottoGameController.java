package lotto.controller;

import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.LottoPlayer;
import lotto.model.PlayerLottos;
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

        PlayerLottos playerLottos = generateLottoPlayerNumbers(numberOfLottoTickets);
        OutputView.outputLottoPlayerNumbers(playerLottos);

        Lotto lotto = getLotto();

        WinningLotto winningLotto = createWinningLotto(lotto);
        Statistics statistics = calculateStatistics(playerLottos, winningLotto);
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

    private PlayerLottos generateLottoPlayerNumbers(int numberOfLottoTickets) {
        return new PlayerLottos(numberOfLottoTickets);
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

    private Statistics calculateStatistics(PlayerLottos playerLottos, WinningLotto winningLotto) {
        return new Statistics(playerLottos, winningLotto);
    }

    private ProfitCalculator calculateProfit(int purchaseMoney, Statistics statistics) {
        return new ProfitCalculator(purchaseMoney, statistics);
    }
}
