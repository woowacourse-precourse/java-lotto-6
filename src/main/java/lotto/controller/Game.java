package lotto.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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

        addAllRandomNumbers();
        calculateNumber();

    }

    private void addAllRandomNumbers() {
        for (int i = 0; i < ticket.getTicket(); i++) {
            List<Integer> randomNumbers = randomNumber.randomNumbers();
            AllRandomNumbers.add(randomNumbers);
            randomNumberView.printRandomNumber(randomNumbers);
        }

    }

    private void calculateNumber() {
        List<Integer> numbers = lottoView.numbers();
        int bonusNumber = bonusNumberView.bonusNumber();
        List<ComPareNumber> compareNumbers = generateCompareNumbers(numbers, bonusNumber);
        List<Integer> totalWinCount = calculateTotalWinCounts(compareNumbers);
        printTotalResults(totalWinCount);
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

}



