package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.LottoPrize;
import lotto.factory.LottoFactory;
import lotto.factory.UserLotteriesFactory;
import lotto.model.LottoNumbersGenerator;
import lotto.utils.LottoProfitCalculator;
import lotto.model.UserLotteries;
import lotto.model.WinningLotto;
import lotto.utils.UsersPrizeLottoCounter;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoDrawController {

    private final InputView inputView;
    private final OutputView outputView;
    private final UserLotteriesFactory userLotteriesFactory;
    private final LottoFactory lottoFactory;

    public LottoDrawController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoFactory = new LottoFactory(new LottoNumbersGenerator());
        this.userLotteriesFactory = new UserLotteriesFactory(lottoFactory);
    }

    public void startDraw() {
        Integer purchaseAmount = inputView.getPurchaseAmount();
        UserLotteries userLotteries = userLotteriesFactory.createFromPurchaseAmount(purchaseAmount);

        int countOfPurchasedLotto = userLotteries.getPurchasedLottoCount();
        showUserLottoDetails(countOfPurchasedLotto, userLotteries);
        WinningLotto winningLotto = createWinningLotto();

        Map<LottoPrize, Long> winningCountPerLottoPrize = UsersPrizeLottoCounter.countPrizeLotto(winningLotto, userLotteries);
        Double lottoProfitPercentage =
                LottoProfitCalculator.findLottoProfitPercentage(winningCountPerLottoPrize, purchaseAmount);

        showDrawResult(winningCountPerLottoPrize, lottoProfitPercentage);
    }

    private void showUserLottoDetails(Integer countOfPurchasedLotto, UserLotteries userLotteries) {
        outputView.printPurchasedCountMessage(countOfPurchasedLotto);
        outputView.printUserLotteries(userLotteries);
    }

    private WinningLotto createWinningLotto() {
        List<Integer> drawnNumbers = inputView.getDrawnNumbers();
        Integer bonusNumber = inputView.getBonusNumber();
        return new WinningLotto(new Lotto(drawnNumbers), bonusNumber);
    }

    public void showDrawResult(Map<LottoPrize, Long> winningCountPerLottoPrize, Double lottoProfitPercentage) {
        outputView.printLottoResultMessage();
        outputView.printLottoResult(winningCountPerLottoPrize);
        outputView.printLottoTotalProfit(lottoProfitPercentage);
    }

}