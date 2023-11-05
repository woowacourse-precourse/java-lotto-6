package lotto.controller;

import lotto.constant.ErrorMessages;
import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;


public class LottoController {
    public void run() {
        PurchaseLotto purchaseLottoAmount = purchaseLottoAmount();

        LottoMachine lottoPapers = buyLotto(purchaseLottoAmount);
        OutputView.displayPurchaseNumbers(lottoPapers.getLottoPapers());

        WinningNumber winningNumber = createWinningNumber();
        BonusNumber bonusNumber = createBonusNumber(winningNumber);

        LottoResult lottoResult = createLottoResult(lottoPapers, winningNumber, bonusNumber);
        double profitMargin = totalProfitMargin(lottoResult, purchaseLottoAmount);
    }

    private double totalProfitMargin(LottoResult lottoResult, PurchaseLotto purchaseLottoAmount) {
        ProfitCalculator profitCalculator = new ProfitCalculator();
        int profit = profitCalculator.calculateProfit(lottoResult);
        return profitCalculator.calculateProfitMargin(profit, purchaseLottoAmount.getPurchaseAmount());
    }

    private LottoResult createLottoResult(LottoMachine lottoPapers, WinningNumber winningNumber, BonusNumber bonusNumber) {
        LotteryChecker lotteryChecker = new LotteryChecker(lottoPapers);
        return lotteryChecker.calculateRank(winningNumber, bonusNumber);
    }

    private LotteryChecker lottoPrizeCheck(LottoMachine lottoPapers) {
        return new LotteryChecker(lottoPapers);
    }

    private BonusNumber createBonusNumber(WinningNumber winningNumber) {
        return new BonusNumber(winningNumber.getWinningNumber(), Integer.parseInt(InputView.BonusNumber()));
    }

    private WinningNumber createWinningNumber() {
        String winningNumber = InputView.WinningNumber();
        String[] splitWinningNumber = winningNumber.split(",");
        List<Integer> winningNumbers = new ArrayList<>();
        validateNumberType(splitWinningNumber, winningNumbers);
        return new WinningNumber(winningNumbers);
    }

    private static void validateNumberType(String[] splitWinningNumber, List<Integer> winningNumbers) {
        for (String number : splitWinningNumber) {
            try {
                int num = Integer.parseInt(number);
                winningNumbers.add(num);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ErrorMessages.PREFIX.getMessage() +
                        ErrorMessages.INVALID_TYPE +
                        ErrorMessages.SUFFIX.getMessage());
            }
        }
    }

    private PurchaseLotto purchaseLottoAmount() {
        return new PurchaseLotto(InputView.PurchaseAmount());
    }

    private LottoMachine buyLotto(PurchaseLotto purchaseLottoAmount) {
        int lottoPaperAmount = purchaseLottoAmount.calculateLottoCount();
        OutputView.purchaseCount(lottoPaperAmount);
        return new LottoMachine(lottoPaperAmount);
    }
}
