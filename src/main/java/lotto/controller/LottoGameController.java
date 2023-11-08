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
        // 로또 구입 금액 입력 및 출력
        LottoPlayer lottoPlayer = createLottoPlayer();
        OutputView.outputNumberOfLottoTicks(lottoPlayer.getNumberOfLottoTickets());

        // 참가자 로또 발행 및 출력
        PlayerLottos playerLottos = generatePlayerLottos(lottoPlayer.getNumberOfLottoTickets());
        OutputView.outputLottoPlayerNumbers(playerLottos);

        // 당첨 번호, 보너스 번호 입력
        Lotto lotto = readLotto();
        WinningLotto winningLotto = createWinningLotto(lotto);

        // 당첨 내역 출력
        Statistics statistics = calculateStatistics(playerLottos, winningLotto);
        OutputView.outputStatistics(statistics);

        // 수익률 출력
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

    private PlayerLottos generatePlayerLottos(int numberOfLottoTickets) {
        return new PlayerLottos(numberOfLottoTickets);
    }

    private WinningLotto createWinningLotto(Lotto lotto) {
        try {
            return new WinningLotto(lotto, readBonusNumber());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return createWinningLotto(lotto);
        }
    }

    private Lotto readLotto() {
        try {
            return new Lotto(InputView.inputWinningLottoNumber());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readLotto();
        }
    }

    private BonusNumber readBonusNumber() {
        try {
            return new BonusNumber(InputView.inputBonusNumber());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readBonusNumber();
        }
    }

    private Statistics calculateStatistics(PlayerLottos playerLottos, WinningLotto winningLotto) {
        return new Statistics(playerLottos, winningLotto);
    }

    private ProfitCalculator calculateProfit(int purchaseMoney, Statistics statistics) {
        return new ProfitCalculator(purchaseMoney, statistics);
    }
}
