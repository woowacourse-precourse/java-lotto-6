package lotto.controller;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;


public class LottoRound {
    private LottoBatch lottoBatch;
    private PrizeNumbers prizeNumbers;
    private LottoBatchResult lottoBatchResult;

    public void start() {
        OutputView.printPurchaseAmountInputMessage();
        Integer lottoCount = generateLottoCount();
        OutputView.printLottoCountMessage(lottoCount);

        generateLottoBatch(lottoCount);
        OutputView.printLottoBatch(lottoBatch.toStrings());

        OutputView.printWinningNumbersInputMessage();
        generateWinningNumbers();

        OutputView.printBonusNumberInputMessage();
        generateBonusNumber();

        calculatePrize();

        OutputView.printLottoResult(lottoBatchResult.getValue());
        OutputView.printLottoProfitRate(lottoBatchResult.calculateLottoProfitRate(lottoCount * 1000));

    }

    public Integer generateLottoCount() {
        try {
            LottoCount lottoCount = new LottoCount(InputView.inputPurchaseAmount());
            return lottoCount.getValue();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return generateLottoCount();
        }
    }

    public void generateLottoBatch(Integer lottoCount) {
        lottoBatch = new LottoBatch(lottoCount);
    }

    public void generateWinningNumbers() {
        try {
            prizeNumbers = new PrizeNumbers(InputView.inputWinningNumbers());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            generateWinningNumbers();
        }
    }

    public void generateBonusNumber() {
        try {
            prizeNumbers.setBonusNumber(InputView.inputBonusNumber());

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            generateBonusNumber();
        }
    }

    public void calculatePrize() {
        lottoBatchResult = new LottoBatchResult(lottoBatch, prizeNumbers);
        lottoBatchResult.calculateLottoResults();
    }
}