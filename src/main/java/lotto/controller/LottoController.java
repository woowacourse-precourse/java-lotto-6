package lotto.controller;

import lotto.domain.*;
import lotto.io.Input;
import lotto.io.Output;

import java.util.List;

public class LottoController {

    final Input input;
    final Output output;

    public LottoController(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public void start() {
        int money = getUserAmount();
        int lottoQuantity = getLottoQuantity(money);

        List<Lotto> myLottos = buyLottos(lottoQuantity);
        List<Integer> winningNumbers = generateWinningNumbers();
        int bonusNumber = generateBonusNumber();

        List<Integer> winningLottoCounts = getWinningLottosCount(myLottos, winningNumbers, bonusNumber);
        double profit = getLottoProfit(winningLottoCounts, money);

        output.printResult(winningLottoCounts, profit);
    }

    private int getUserAmount() {
        int money = 0;
        try {
            output.printInputPurchaseAmountMessage();
            money = input.getUserAmount();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            money = getUserAmount();
        }
        return money;
    }

    private int getLottoQuantity(int money) {
        int lottoQuantity = money / Constants.LOTTO_PRICE;
        output.printPurchaseQuantity(lottoQuantity);
        return lottoQuantity;
    }

    private List<Lotto> buyLottos(int lottoQuantity) {
        Lottos lottos = new Lottos(lottoQuantity);
        List<Lotto> myLottos = lottos.getMyLottos();
        output.printMyLottos(myLottos);
        return myLottos;
    }

    private List<Integer> generateWinningNumbers() {
        List<Integer> winningNumbers;
        try {
            output.printInputWinningNumbersMessage();
            winningNumbers = input.getWinningNumbers();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            winningNumbers = generateWinningNumbers();
        }
        return winningNumbers;
    }

    private int generateBonusNumber() {
        int bonusNumber;
        System.out.println();
        try {
            output.printInputBonusNumberMessage();
            bonusNumber = input.getBonusNumber();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            bonusNumber = generateBonusNumber();
        }
        return bonusNumber;
    }

    private List<Integer> getWinningLottosCount(List<Lotto> myLottos, List<Integer> winningNumbers, int bonusNumber) {
        WinningChecker winningChecker = new WinningChecker(myLottos, winningNumbers, bonusNumber);
        return winningChecker.countWinningLottos();
    }

    private double getLottoProfit(List<Integer> winningLottoCounts, int money) {
        ProfitCalculator profitCalculator = new ProfitCalculator(winningLottoCounts);
        double profit = profitCalculator.calculateProfit(money);
        System.out.println(profit);
        return profit;
    }
}