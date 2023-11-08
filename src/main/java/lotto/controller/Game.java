package lotto.controller;


import static lotto.view.OutputView.printProfit;
import static lotto.view.OutputView.printReceipt;
import static lotto.view.OutputView.printStatistic;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.CalculateResult;
import lotto.domain.LottoResultCalculator;
import lotto.domain.LottoPurchase;
import lotto.domain.RandomNumberGenerator;
import lotto.domain.TicketPurchase;
import lotto.validator.InputValidator;
import lotto.view.BonusNumberView;
import lotto.view.LottoView;
import lotto.view.OutputView;
import lotto.view.PurchaseView;
import lotto.view.RandomNumberView;


public class Game {

    private InputValidator inputValidator;
    private PurchaseView purchaseView = new PurchaseView();
    private LottoView lottoView = new LottoView();
    private BonusNumberView bonusNumberView = new BonusNumberView();
    private LottoPurchase purchase;
    private List<List<Integer>> allRandomNumbers = new ArrayList<>();
    private RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
    private RandomNumberView randomNumberView = new RandomNumberView();
    private List<Integer> numbers;
    private int bonusNumber;
    private TicketPurchase ticketCount;


    public Game() {
        this.inputValidator = new InputValidator(this.purchaseView, this.lottoView,
                this.bonusNumberView);
    }

    public void start() {
        processPurchase();
        processLottoSelection();
        calculateAndPrintResults();

    }

    private void generateAllRandomNumbers() {
        allRandomNumbers = randomNumberGenerator.generateMultipleLottoSets(ticketCount.getTicket());
        randomNumberView.printAllRandomNumbers(allRandomNumbers);
    }


    private void processPurchase() {
        this.purchase = inputValidator.validatePurchase();
        this.ticketCount = new TicketPurchase(purchase.getPayment());
        printReceipt(ticketCount.getTicket());
        OutputView.printSpace();

        generateAllRandomNumbers();
    }

    private void processLottoSelection() {
        this.numbers = inputValidator.validateLotto().getNumbers();
        this.bonusNumber = inputValidator.validateBonusNumber(numbers).getBonusNumber();
        OutputView.printSpace();
    }


    private void calculateAndPrintResults() {
        List<LottoResultCalculator> compareNumbers = generateResultCalculators(numbers, bonusNumber);
        long totalMoneySum = CalculateResult.calculateTotalMoneySum(compareNumbers);
        List<Integer> totalWinCount = CalculateResult.calculateTotalWinCounts(compareNumbers);

        printCalculationResults(totalWinCount, totalMoneySum);

    }

    private void printCalculationResults(List<Integer> totalWinCount, long totalMoneySum) {
        printStatistic();
        printTotalResults(totalWinCount);
        printProfit(totalMoneySum, purchase.getPayment());
    }

    private List<LottoResultCalculator> generateResultCalculators(List<Integer> numbers,
            int bonusNumber) {
        return LottoResultCalculator.generateResultCalculators(numbers, bonusNumber,
                allRandomNumbers);
    }


    private void printTotalResults(List<Integer> totalWinCount) {
        OutputView.printWinningCountsByPrize(totalWinCount);
    }


}