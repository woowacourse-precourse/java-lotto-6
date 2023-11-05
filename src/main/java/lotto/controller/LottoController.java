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
        Money money = new Money(getUserAmount());
        LottoQuantity lottoQuantity = new LottoQuantity(money.getQuantity());
        output.printPurchaseQuantity(lottoQuantity.getQuantity());

        List<Lotto> myLottos = buyLottos(lottoQuantity);
        WinningNumbers winningNumbers = new WinningNumbers(generateWinningNumbers());
        int bonusNumber = generateBonusNumber(winningNumbers);

        List<Integer> winningLottoCounts = getWinningLottosCount(myLottos, winningNumbers, bonusNumber);
        double profit = getLottoProfit(winningLottoCounts, money);
        output.printResult(winningLottoCounts, profit);
    }

    private int getUserAmount() {
        int money;
        try {
            output.printInputPurchaseAmountMessage();
            money = input.getUserAmount();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            money = getUserAmount();
        }
        return money;
    }

    private List<Lotto> buyLottos(LottoQuantity lottoQuantity) {
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

    private int generateBonusNumber(WinningNumbers winningNumbers) {
        int bonusNumber;
        System.out.println();
        try {
            output.printInputBonusNumberMessage();
            bonusNumber = input.getBonusNumber();
            winningNumbers.validateDuplication(bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            bonusNumber = generateBonusNumber(winningNumbers);
        }
        return bonusNumber;
    }

    private List<Integer> getWinningLottosCount(List<Lotto> myLottos, WinningNumbers winningNumbers, int bonusNumber) {
        WinningChecker winningChecker = new WinningChecker(myLottos, winningNumbers, bonusNumber);
        return winningChecker.countWinningLottos();
    }

    private double getLottoProfit(List<Integer> winningLottoCounts, Money money) {
        ProfitCalculator profitCalculator = new ProfitCalculator(winningLottoCounts);
        double profit = profitCalculator.calculateProfit(money);
        return profit;
    }
}