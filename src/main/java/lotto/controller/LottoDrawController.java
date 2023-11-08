package lotto.controller;

import static lotto.utils.LottoProfitCalculator.findLottoProfitPercentage;
import static lotto.utils.UsersPrizeLottoCounter.countPrizeLotto;

import java.util.List;
import java.util.Map;
import lotto.factory.LottoFactory;
import lotto.factory.UserLotteriesFactory;
import lotto.model.Lotto;
import lotto.model.LottoNumbersGenerator;
import lotto.model.LottoPrize;
import lotto.model.UserLotteries;
import lotto.model.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoDrawController {

    private final InputView inputView;
    private final OutputView outputView;
    private final UserLotteriesFactory userLotteriesFactory;

    private UserLotteries userLotteries;
    private WinningLotto winningLotto;
    private Lotto winningLottoNumbers;

    public LottoDrawController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        LottoFactory lottoFactory = new LottoFactory(new LottoNumbersGenerator());
        this.userLotteriesFactory = new UserLotteriesFactory(lottoFactory);
    }

    public void startDraw() {
        purchaseLotto();
        showPurchasedLotto();
        issueWinningLotto();

        Map<LottoPrize, Long> winningCountPerLottoPrize = countPrizeLotto(winningLotto, userLotteries);
        Double lottoProfitPercentage =
                findLottoProfitPercentage(winningCountPerLottoPrize, userLotteries.lotteriesCount());

        showResult(winningCountPerLottoPrize, lottoProfitPercentage);
    }

    private void purchaseLotto() {
        while (true) {
            try {
                Integer purchaseAmount = inputView.getPurchaseAmount();
                userLotteries = userLotteriesFactory.createFromPurchaseAmount(purchaseAmount);
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private void showPurchasedLotto() {
        outputView.printPurchasedCountMessage(userLotteries.lotteriesCount());
        outputView.printUserLotteries(userLotteries);
    }

    private void issueWinningLotto() {
        createWinningLottoNumbers();
        createWinningLotto();
    }

    private void createWinningLottoNumbers() {
        while (true) {
            try {
                List<Integer> drawnNumbers = inputView.getDrawnNumbers();
                winningLottoNumbers = new Lotto(drawnNumbers);
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private void createWinningLotto() {
        while (true) {
            try {
                Integer bonusNumber = inputView.getBonusNumber();
                winningLotto = new WinningLotto(winningLottoNumbers, bonusNumber);
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private void showResult(Map<LottoPrize, Long> winningCountPerLottoPrize, Double lottoProfitPercentage) {
        outputView.printLottoResultMessage();
        outputView.printLottoResult(winningCountPerLottoPrize);
        outputView.printLottoTotalProfit(lottoProfitPercentage);
    }
}