package lotto.controller;

import java.util.List;
import lotto.constant.LottoConstant;
import lotto.model.BonusNumber;
import lotto.model.GameNumbers;
import lotto.model.LottoMachine;
import lotto.model.Lottos;
import lotto.model.Result;
import lotto.model.StatisticsResult;
import lotto.model.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void init() {
        int purchaseAmount = createPurchaseAmount();
        StatisticsResult statisticsResult = new StatisticsResult(purchaseAmount, LottoConstant.LOTTO_PRICE.getValue());
        int lottoCount = statisticsResult.caculateLottoCount();

        OutputView.printLottoCount(lottoCount);
        Lottos lottos = new Lottos(LottoMachine.createLotto(lottoCount));
        lottos.printLottos(OutputView::printEachLotto);

        GameNumbers gameNumbers = new GameNumbers(createWinningNumbers());
        tryCreateBonusNumbers(gameNumbers);

        showWinningStatistics(lottos, gameNumbers, statisticsResult);

        OutputView.printFinalReturnRate(statisticsResult.getFinalReturnRate());
    }

    private int createPurchaseAmount() {
        OutputView.printBuyAnnounce();
        try {
            return InputView.inputPurchaseAmount();
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception.getMessage());
            return createPurchaseAmount();
        }
    }

    private WinningNumbers createWinningNumbers() {
        OutputView.printWinningNumberInputAnnounce();
        try {
            List<Integer> inputNumbers = InputView.inputWinningNumber();
            return new WinningNumbers(inputNumbers);
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception.getMessage());
            return createWinningNumbers();
        }
    }

    private BonusNumber createBonusNumber() {
        OutputView.printBonusNumberInputAnnounce();
        int inputNumber = InputView.inputBonusNumber();
        return new BonusNumber(inputNumber);
    }

    private GameNumbers tryCreateBonusNumbers(final GameNumbers gameNumbers) {
        try {
            gameNumbers.addBonusNumber(createBonusNumber());
            return gameNumbers;
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception.getMessage());
            return tryCreateBonusNumbers(gameNumbers);
        }
    }

    private void showWinningStatistics(final Lottos lottos, final GameNumbers gameNumbers,
                                       final StatisticsResult statisticsResult) {
        OutputView.printStatisticsMessage();
        List<Result> results = lottos.getResults(gameNumbers);
        statisticsResult.addLottoResults(results);
        OutputView.printFinalResult(statisticsResult.getFinalResult());
    }
}
