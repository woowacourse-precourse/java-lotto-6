package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoPurchaseReceipt;
import lotto.domain.Money;
import lotto.domain.winning.WinningResult;
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
        LottoPurchaseReceipt receipt = ExceptionRetryHandler.retryUntilValid(this::handlePurchaseLottos);
        ExceptionRetryHandler.retryUntilValid(this::handleWinningStatistics, receipt);
    }

    private LottoPurchaseReceipt handlePurchaseLottos() {
        int purchaseMoney = inputView.readPurchaseMoney();
        LottoPurchaseReceipt receipt = gameService.purchaseLottos(purchaseMoney);
        outputView.printLineSeparator();

        outputView.printLottos(receipt.purchasedLottos().getSortedLottos());
        outputView.printLineSeparator();
        return receipt;
    }

    private void handleWinningStatistics(LottoPurchaseReceipt receipt) {
        Lotto winningLotto = ExceptionRetryHandler.retryUntilValid(this::inputWinningLotto);
        outputView.printLineSeparator();
        LottoNumber bonusNumber = ExceptionRetryHandler.retryUntilValid(this::inputBonusNumber);

        WinningStatistics statistics =
                gameService.getWinningStatistics(winningLotto, bonusNumber, receipt.purchasedLottos());

        outputView.printLineSeparator();

        printWinningStatistics(statistics.sortedByWinningMoney());
        printRateOfReturn(statistics.getTotalWinningMoney(), receipt.purchaseMoney());
    }

    private Lotto inputWinningLotto() {
        List<Integer> winningNumbers = inputView.readWinningNumbers();
        return new Lotto(winningNumbers);
    }

    private LottoNumber inputBonusNumber() {
        int bonusNumber = inputView.readBonusNumber();
        return LottoNumber.valueOf(bonusNumber);
    }

    private void printWinningStatistics(Map<WinningResult, Integer> statistics) {
        outputView.printStatisticsHeader();
        statistics.forEach(outputView::printStatistics);
    }

    private void printRateOfReturn(Money totalWinningMoney, Money purchaseMoney) {
        double rateOfReturn = totalWinningMoney.getRatio(purchaseMoney);
        outputView.printRateOfReturn(rateOfReturn);
    }
}
