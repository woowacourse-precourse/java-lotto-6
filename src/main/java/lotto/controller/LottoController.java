package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinningNumber;
import lotto.domain.calculator.MatchingCalculator;
import lotto.domain.calculator.ProfitCalculator;
import lotto.domain.generator.LottoGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

import static lotto.exception.ErrorCode.ILLEGAL_STATE_ERROR;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private MatchingCalculator calculatorMatching;
    private ProfitCalculator profitCalculator;
    private LottoGenerator lottoGenerator;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.calculatorMatching = new MatchingCalculator();
        this.profitCalculator = new ProfitCalculator();
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
        outputView.println();
        return lottos;
    }

    private long inputPurchaseAmount() {
        long purchaseAmount;
        while (true) {
            try {
                outputView.printPurchaseAmountMessage();
                purchaseAmount = inputView.getPurchaseAmount();
                outputView.println();
                return purchaseAmount;
            } catch (IllegalArgumentException e) {
                outputView.printErrorCode(e.getMessage());
                outputView.println();
            }
        }
    }

    private WinningNumber inputWinningNumbers() {
        List<Integer> winningNumbers;
        while (true) {
            try {
                outputView.printWinningNumberstMessage();
                winningNumbers = inputView.getWinningNumbers();
                outputView.println();
                return new WinningNumber(winningNumbers, 0);
            } catch (IllegalArgumentException e) {
                outputView.printErrorCode(e.getMessage());
                outputView.println();
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
                outputView.println();
            }
        }
    }

    private void calculateLottoResult(List<Lotto> tickets, WinningNumber winningNumber, int bonusNumber, long purchaseAmount) {
        List<Rank> ranks = calculatorMatching.calculateRanks(tickets, winningNumber, bonusNumber);
        outputView.println();
        outputView.printWinningResults(ranks);
        calculateLottoProfit(ranks, purchaseAmount);
    }

    private void calculateLottoProfit(List<Rank> ranks, long purchaseAmount) {
        int totalPrize = profitCalculator.calculateTotalPrize(ranks);
        double totalProfitRate = profitCalculator.calculateTotalProfitRate(totalPrize, purchaseAmount);
        outputView.printTotalProfit(totalProfitRate);
    }
}