package lotto.controller;

import java.util.List;
import lotto.domain.LottoPurchaseAmount;
import lotto.domain.LottoSeller;
import lotto.domain.LottoTickets;
import lotto.domain.LottoWinningNumbers;
import lotto.domain.prize.LottoPrizeCalculator;
import lotto.domain.profit.LottoProfitRate;
import lotto.domain.profit.LottoProfitRateCalculator;
import lotto.domain.randomnumber.RandomNumberPicker;
import lotto.domain.result.LottoPrizeResult;
import lotto.view.InputView;
import lotto.view.result.ResultView;

public class LottoGameController {

    private final InputView inputView;
    private final ResultView resultView;
    private final RandomNumberPicker randomNumberPicker;

    public LottoGameController(InputView inputView, ResultView resultView, RandomNumberPicker randomNumberPicker) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.randomNumberPicker = randomNumberPicker;
    }

    public void run() {
        LottoPurchaseAmount purchaseAmount = inputLottoPurchaseAmount();
        LottoTickets tickets = purchaseLotto(purchaseAmount);

        LottoWinningNumbers winningNumbers = inputWinningNumbers();

        showGameResult(calculatePrizeResult(winningNumbers, tickets), purchaseAmount);
    }

    private LottoPrizeResult calculatePrizeResult(LottoWinningNumbers winningNumbers, LottoTickets tickets) {
        return new LottoPrizeCalculator().calculatePrize(winningNumbers, tickets);
    }

    private void showGameResult(LottoPrizeResult prizeResult, LottoPurchaseAmount purchaseAmount) {
        resultView.showPrizeResult(prizeResult);
        showProfitRate(prizeResult, purchaseAmount);
    }

    private void showProfitRate(LottoPrizeResult prizeResult, LottoPurchaseAmount purchaseAmount) {
        LottoProfitRateCalculator profitRateCalculator = new LottoProfitRateCalculator();
        LottoProfitRate profitRate = profitRateCalculator.calculate(
                purchaseAmount,
                prizeResult.calculateTotalPrizeAmount()
        );
        resultView.showProfitRate(profitRate);
    }

    private LottoWinningNumbers inputWinningNumbers() {
        try {
            List<Integer> winningNumbers = tryInputWinningNumbers();
            int bonusNumber = tryInputBonusNumber();
            return LottoWinningNumbers.of(winningNumbers, bonusNumber);
        } catch (IllegalArgumentException e) {
            showErrorMessage(e);
            return inputWinningNumbers();
        }
    }

    private List<Integer> tryInputWinningNumbers() {
        try {
            return inputView.inputWinningNumbers();
        } catch (IllegalArgumentException e) {
            showErrorMessage(e);
            return tryInputWinningNumbers();
        }
    }

    private int tryInputBonusNumber() {
        try {
            return inputView.inputBonusNumber();
        } catch (IllegalArgumentException e) {
            showErrorMessage(e);
            return tryInputBonusNumber();
        }
    }

    private LottoTickets purchaseLotto(LottoPurchaseAmount purchaseAmount) {
        LottoSeller seller = new LottoSeller(this.randomNumberPicker);
        LottoTickets tickets = seller.purchase(purchaseAmount);

        resultView.showPurchasedLottoTickets(tickets);

        return tickets;
    }

    private LottoPurchaseAmount inputLottoPurchaseAmount() {
        try {
            return inputView.inputLottoPurchaseAmount();
        } catch (IllegalArgumentException e) {
            showErrorMessage(e);
            return inputLottoPurchaseAmount();
        }
    }

    private void showErrorMessage(IllegalArgumentException e) {
        resultView.showErrorMessage(e.getMessage());
    }

}
