package lotto.controller;

import static lotto.constant.OutputMessage.DIVIDING_LINE;
import static lotto.constant.OutputMessage.PROFIT;
import static lotto.constant.OutputMessage.WIN_STATISTICS;
import static lotto.constant.PurchaseMessage.BUY_RECEIPT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.constant.OutputMessage;
import lotto.constant.PurchaseMessage;
import lotto.constant.WinPriceMessage;
import lotto.domain.BonusNumber;
import lotto.domain.ComPareNumber;
import lotto.domain.Lotto;
import lotto.domain.RandomNumber;
import lotto.domain.Ticket;
import lotto.view.BonusNumberView;
import lotto.view.LottoView;
import lotto.view.PurchaseView;
import lotto.view.RandomNumberView;
import lotto.view.WinPriceView;

public class Game {

    private PurchaseView purchaseView = new PurchaseView();
    private RandomNumber randomNumber = new RandomNumber();
    private RandomNumberView randomNumberView = new RandomNumberView();
    private LottoView lottoView = new LottoView();
    private BonusNumberView bonusNumberView = new BonusNumberView();
    private BonusNumber bonusNumber;
    private ComPareNumber comPareNumber;
    private Lotto lotto;
    private Ticket ticket;
    private WinPriceView winPriceView = new WinPriceView();
    private WinPriceMessage winPriceMessage;
    private List<List<Integer>> AllRandomNumbers = new ArrayList<>();


    public void start() {
        int money = purchaseView.requestMoney();
        ticket = new Ticket(money);
        printReceipt(ticket.getTicket());

        addAllRandomNumbers();

        List<ComPareNumber> compareNumbers = calculateCompareNumbers();
        long totalMoneySum = calculateTotalMoneySum(compareNumbers);
        List<Integer> totalWinCount = calculateTotalWinCounts(compareNumbers);

        printStatistic();
        printTotalResults(totalWinCount);
        printProfit(totalMoneySum, money);
    }

    private void addAllRandomNumbers() {
        for (int i = 0; i < ticket.getTicket(); i++) {
            List<Integer> randomNumbers = randomNumber.randomNumbers();
            AllRandomNumbers.add(randomNumbers);
            randomNumberView.printRandomNumber(randomNumbers);
        }
        randomNumberView.printSpace();

    }

    private List<ComPareNumber> calculateCompareNumbers() {
        List<Integer> numbers = lottoView.numbers();
        int bonusNumber = bonusNumberView.bonusNumber();
        return generateCompareNumbers(numbers, bonusNumber);
    }

    private long calculateTotalMoneySum(List<ComPareNumber> compareNumbers) {
        return compareNumbers.stream()
                .mapToLong(ComPareNumber::getMoneySum)
                .sum();
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
        winPriceView.printAllWinPrices(totalWinCount);
    }

    private double calculateProfit(long moneySum, int money) {
        double profit = (double) moneySum / money;
        return Math.round(profit * 1000.0) / 1000.0;
    }

    private void printProfit(long moneySum, int money) {
        double profitRate = calculateProfit(moneySum, money) * 100;
        String profitMessage = String.format(OutputMessage.PROFIT.getOutputMessage(),
                String.format("%.1f", profitRate));
        System.out.println(profitMessage);
    }

    private void printReceipt(int ticket) {
        String printReceiptMessage = String.format(BUY_RECEIPT.getMessage(),
                String.format("%s", ticket));
        System.out.println();
        System.out.println(printReceiptMessage);
    }

    private void printStatistic() {
        System.out.println(WIN_STATISTICS.getOutputMessage());
        System.out.println(DIVIDING_LINE.getOutputMessage());
    }


}



