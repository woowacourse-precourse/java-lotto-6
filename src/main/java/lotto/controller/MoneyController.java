package lotto.controller;

import lotto.domain.Money;
import lotto.dto.GameResult;
import lotto.view.InputView;
import lotto.view.OutputView;

public class MoneyController {

    public Money inputMoney() {
        return new Money(InputView.inputMoney());
    }

    public double calculateProfit(final GameResult gameResult, final Money money) {
        double reward = (double) gameResult.getReward();
        double investedMoney = (double) money.getMoney();

        return (reward / investedMoney) * 100.0;
    }

    public void printProfit(double profit) {
        OutputView.printProfit(profit);
    }
}
