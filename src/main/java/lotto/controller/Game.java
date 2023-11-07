package lotto.controller;


import static lotto.view.OutputView.printProfit;
import static lotto.view.OutputView.printReceipt;
import static lotto.view.OutputView.printStatistic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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
    private List<List<Integer>> AllRandomNumbers = new ArrayList<>();
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
        AllCalculator();

    }


    private void purchaseMethod() {
        this.purchase = checkValidator.validatePurchase();
        ticket = new Ticket(purchase.getMoney());
        printReceipt(ticket.getTicket());
        OutputView.printSpace();

        addAllRandomNumbers();
    }
    private void addAllRandomNumbers() {
        List<List<Integer>> allRandomNumbers = randomNumber.generateAllRandomNumbers(ticket.getTicket());
        randomNumberView.printAllRandomNumbers(allRandomNumbers);
    }

    private void lottoMethod() {
        this.numbers = checkValidator.validateLotto().getNumbers();
        this.bonusNumber = checkValidator.validateBonusNumber(numbers).getBonusNumber();
        OutputView.printSpace();
    }

    private void AllCalculator() {
        List<ComPareNumber> compareNumbers = generateCompareNumbers(numbers, bonusNumber);
        long totalMoneySum = calculateTotalMoneySum(compareNumbers);
        List<Integer> totalWinCount = calculateTotalWinCounts(compareNumbers);

        printCalculationResults(totalWinCount, totalMoneySum);
    }

    private void printCalculationResults(List<Integer> totalWinCount, long totalMoneySum) {
        printStatistic();
        printTotalResults(totalWinCount);
        printProfit(totalMoneySum, purchase.getMoney());
    }


    private List<ComPareNumber> generateCompareNumbers(List<Integer> numbers, int bonusNumber) {
        return AllRandomNumbers.stream()
                .map(randomNumbers -> createAndCalculateCompareNumber(numbers, randomNumbers,
                        bonusNumber))
                .collect(Collectors.toList());
    }


    private ComPareNumber createAndCalculateCompareNumber(List<Integer> numbers,
            List<Integer> randomNumbers, int bonusNumber) {
        ComPareNumber compareNumber = new ComPareNumber(numbers, randomNumbers, bonusNumber);
        compareNumber.calculateResults();
        return compareNumber;
    }


    private long calculateTotalMoneySum(List<ComPareNumber> compareNumbers) {
        return compareNumbers.stream()
                .mapToLong(ComPareNumber::getMoneySum)
                .sum();
    }


    private List<Integer> calculateTotalWinCounts(List<ComPareNumber> compareNumbers) {
        List<Integer> totalWinCount = Arrays.asList(0, 0, 0, 0, 0);
        compareNumbers.forEach(compareNumber ->
                addWinCounts(totalWinCount, compareNumber.getWinCount())
        );
        return totalWinCount;
    }

    private void addWinCounts(List<Integer> totalWinCount, List<Integer> winCount) {
        IntStream.range(0, winCount.size())
                .forEach(i -> totalWinCount.set(i, totalWinCount.get(i) + winCount.get(i)));
    }

    private void printTotalResults(List<Integer> totalWinCount) {
        OutputView.printAllWinPrices(totalWinCount);
    }


}