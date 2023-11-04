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
        output.printInputPurchaseAmountMessage();
        int money = input.getUserAmount();
        int lottoQuantity = money / Constants.LOTTO_PRICE;
        output.printPurchaseQuantity(lottoQuantity);

        Lottos lottos = new Lottos(lottoQuantity);
        List<Lotto> myLottos = lottos.getMyLottos();
        output.printMyLottos(myLottos);

        output.printInputWinningNumbersMessage();
        List<Integer> winningNumbers = input.getWinningNumbers();
        output.printInputBonusNumberMessage();
        int bonusNumber = input.getBonusNumber();

        WinningChecker winningChecker = new WinningChecker(myLottos, winningNumbers, bonusNumber);
        List<Integer> winningLottoCounts = winningChecker.countWinningLottos();
        ProfitCalculator profitCalculator = new ProfitCalculator(winningLottoCounts);
        double profit = profitCalculator.getLottoProfit(money);
        System.out.println(profit);
        output.printResult(winningLottoCounts, profit);
    }
}