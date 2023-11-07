package lotto.controller;


import static lotto.view.OutputView.printProfit;
import static lotto.view.OutputView.printReceipt;
import static lotto.view.OutputView.printStatistic;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.CalculateResult;
import lotto.domain.ComPareNumber;
import lotto.domain.Purchase;
import lotto.domain.RandomNumber;
import lotto.domain.Ticket;
import lotto.validator.CheckValidator;
import lotto.view.BonusNumberView;
import lotto.view.LottoView;
import lotto.view.OutputView;
import lotto.view.PurchaseView;
import lotto.view.RandomNumberView;


public class Game {

    private CheckValidator checkValidator;
    private PurchaseView purchaseView = new PurchaseView();
    private LottoView lottoView = new LottoView();
    private BonusNumberView bonusNumberView = new BonusNumberView();
    private Purchase purchase;
    private List<List<Integer>> allRandomNumbers = new ArrayList<>();
    private RandomNumber randomNumber = new RandomNumber();
    private RandomNumberView randomNumberView = new RandomNumberView();
    private List<Integer> numbers;
    private int bonusNumber;
    private Ticket ticket;


    public Game() {
        this.checkValidator = new CheckValidator(this.purchaseView, this.lottoView,
                this.bonusNumberView);
    }

    public void start() {
        purchaseMethod();
        lottoMethod();
        allCalculator();

    }

    private void allRandomNumbers() {
        allRandomNumbers = randomNumber.generateAllRandomNumbers(ticket.getTicket());
        randomNumberView.printAllRandomNumbers(allRandomNumbers);
    }


    private void purchaseMethod() {
        this.purchase = checkValidator.validatePurchase();
        ticket = new Ticket(purchase.getMoney());
        printReceipt(ticket.getTicket());
        OutputView.printSpace();

        allRandomNumbers();
    }

    private void lottoMethod() {
        this.numbers = checkValidator.validateLotto().getNumbers();
        this.bonusNumber = checkValidator.validateBonusNumber(numbers).getBonusNumber();
        OutputView.printSpace();
    }


    private void allCalculator() {
        List<ComPareNumber> compareNumbers = generateCompareNumbers(numbers, bonusNumber);
        long totalMoneySum = CalculateResult.calculateTotalMoneySum(compareNumbers);
        List<Integer> totalWinCount = CalculateResult.calculateTotalWinCounts(compareNumbers);

        printCalculationResults(totalWinCount, totalMoneySum);
    }

    private void printCalculationResults(List<Integer> totalWinCount, long totalMoneySum) {
        printStatistic();
        printTotalResults(totalWinCount);
        printProfit(totalMoneySum, purchase.getMoney());
    }

    private List<ComPareNumber> generateCompareNumbers(List<Integer> winningNumbers,
            int bonusNumber) {
        return ComPareNumber.generateCompareNumbers(winningNumbers, bonusNumber, allRandomNumbers);
    }


    private void printTotalResults(List<Integer> totalWinCount) {
        OutputView.printAllWinPrices(totalWinCount);
    }


}