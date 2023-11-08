package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinningNumber;
import lotto.domain.calculator.CalculatorMatching;
import lotto.domain.calculator.CalculatorProfit;
import lotto.domain.generator.LottoGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

import static lotto.util.exception.ErrorCode.ILLEGAL_STATE_ERROR;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private CalculatorMatching calculatorMatching;
    private CalculatorProfit calculatorProfit;
    private LottoGenerator lottoGenerator;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.calculatorMatching = new CalculatorMatching();
        this.calculatorProfit = new CalculatorProfit();
        this.lottoGenerator = new LottoGenerator();
    }

    public void start() {
        try {
            play();
        } catch (IllegalStateException e) {
            outputView.printErrorCode(ILLEGAL_STATE_ERROR.getMessage());
        }
    }

    public void play() {
        long purchaseAmount = inputPurchaseAmount();

        List<Lotto> lottos = generateLottos(purchaseAmount);

        WinningNumber winningNumber = inputWinningNumbers();

        int bonusNumber = inputBonusNumber(winningNumber);

        calculateLottoResult(lottos, winningNumber, bonusNumber, purchaseAmount);
    }

    private List<Lotto> generateLottos(long purchaseAmount) {
        List<Lotto> lottos = lottoGenerator.generateLottos(purchaseAmount);
        outputView.printPurchasedLottoTickets(lottos);
        return lottos;
    }

    private long inputPurchaseAmount() {
        long purchaseAmount;
        while (true) {
            try {
                outputView.printPurchaseAmountMessage();
                purchaseAmount = inputView.getPurchaseAmount();
                return purchaseAmount;
            } catch (IllegalArgumentException e) {
                outputView.printErrorCode(e.getMessage());
            }
        }
    }

    private WinningNumber inputWinningNumbers() {
        List<Integer> winningNumbers;
        while (true) {
            try {
                outputView.printWinningNumberstMessage();
                winningNumbers = inputView.getWinningNumbers();
                return new WinningNumber(winningNumbers, 0);
            } catch (IllegalArgumentException e) {
                outputView.printErrorCode(e.getMessage());
            }
        }
    }

    private int inputBonusNumber(WinningNumber winningNumber) {
        while (true) {
            try {
                outputView.printBonusNumberMessage();
                return inputView.getBonusNumber(winningNumber.getNumbers());
            } catch (IllegalArgumentException e) {
                outputView.printErrorCode(e.getMessage());
            }
        }
    }

    private void calculateLottoResult(List<Lotto> tickets, WinningNumber winningNumber, int bonusNumber, long purchaseAmount) {
        List<Rank> ranks = calculatorMatching.calculateRanks(tickets, winningNumber, bonusNumber);
        outputView.printWinningResults(ranks);
        calculateLottoProfit(ranks, purchaseAmount);
    }

    private void calculateLottoProfit(List<Rank> ranks, long purchaseAmount) {
        int totalPrize = calculatorProfit.calculateTotalPrize(ranks);
        double totalProfitRate = calculatorProfit.calculateTotalProfitRate(totalPrize, purchaseAmount);
        outputView.printTotalProfit(totalProfitRate);
    }
}