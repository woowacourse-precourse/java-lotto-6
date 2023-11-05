package lotto.controller;

import lotto.constant.ErrorMessages;
import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static lotto.constant.NumberConstants.NUMBER_RANGE_MAX;
import static lotto.constant.NumberConstants.NUMBER_RANGE_MIN;


public class LottoController {
    public void run() {
        PurchaseLotto purchaseLottoAmount = null;
        WinningNumber winningNumber = null;
        BonusNumber bonusNumber = null;

        while (purchaseLottoAmount == null) {
            try {
                purchaseLottoAmount = purchaseLottoAmount();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        LottoMachine lottoPapers = buyLotto(purchaseLottoAmount);
        OutputView.displayLottoPapers(lottoPapers);

        while (winningNumber == null) {
            try {
                winningNumber = createWinningNumber();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        while (bonusNumber == null) {
            try {
                bonusNumber = createBonusNumber(winningNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }



        LottoResult lottoResult = createLottoResult(lottoPapers, winningNumber, bonusNumber);
        double profitMargin = totalProfitMargin(lottoResult, purchaseLottoAmount);
        OutputView.displayResults(lottoResult);
        OutputView.displayProfitMargin(profitMargin);
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
        return new BonusNumber(winningNumber.getWinningNumber(), InputView.BonusNumber());
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
                        ErrorMessages.INVALID_TYPE.getMessage() +
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
