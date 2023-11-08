package lotto.controller;

import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Money;
import lotto.domain.winning.WinningStatistics;
import lotto.service.GameService;
import lotto.util.ExceptionRetryHandler;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final GameService gameService;

    public GameController(InputView inputView, OutputView outputView, GameService gameService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.gameService = gameService;
    }

    public void startGame() {
        handlePurchaseLottos();
        ExceptionRetryHandler.retryUntilValid(this::handleWinningStatistics);
    }

    private void handlePurchaseLottos() {
        List<List<Integer>> lottos = ExceptionRetryHandler.retryUntilValid(this::purchaseLottos);
        outputView.printLottos(lottos);
    }

    private List<List<Integer>> purchaseLottos() {
        int purchaseMoney = inputView.readPurchaseMoney();
        return gameService.purchaseLottos(purchaseMoney);
    }

    private void handleWinningStatistics() {
        Lotto winningLotto = ExceptionRetryHandler.retryUntilValid(this::createWinningLotto);
        LottoNumber bonusLottoNumber = ExceptionRetryHandler.retryUntilValid(this::createBonusLottoNumber);

        WinningStatistics statistics = gameService.determineWinningStatistics(winningLotto, bonusLottoNumber);
        outputView.printStatistics(statistics.getStatistics());
        printRateOfReturn(statistics.getTotalWinningMoney());
    }

    private Lotto createWinningLotto() {
        List<Integer> winningNumbers = inputView.readWinningNumbers();
        return new Lotto(winningNumbers);
    }

    private LottoNumber createBonusLottoNumber() {
        int bonusNumber = inputView.readBonusNumber();
        return LottoNumber.valueOf(bonusNumber);
    }

    private void printRateOfReturn(Money totalWinningMoney) {
        double rateOfReturn = gameService.getRateOfReturn(totalWinningMoney);
        outputView.printRateOfReturn(rateOfReturn);
    }
}
