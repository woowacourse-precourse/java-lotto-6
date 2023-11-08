package lotto.Controller;

import lotto.Domain.Buyer;
import lotto.Domain.Calculator;
import lotto.Domain.WinningNumbers;
import lotto.Lotto;
import lotto.Utils.InputSystem;
import lotto.Utils.Rank;
import lotto.Utils.SystemConstants;

public class Controller {
    private final Buyer buyer;
    private final WinningNumbers numbers;
    private final Calculator calculator;
    private Lotto winningNumbers;

    public Controller() {
        buyer = new Buyer();
        numbers = new WinningNumbers();
        calculator = new Calculator();
        Rank.initRankCount();
    }

    public void startPurchase() {
        buyer.buyLotto(InputSystem.inputPurchaseMoney());
    }

    public void decideWinningLotto(String[] winningNumberTexts) {
        winningNumbers = numbers.setWinningNumbers(winningNumberTexts);
        numbers.setBonusNumber();
    }

    public void calculateWinning() {
        var purchasedLotteries = buyer.getPurchasedLotteries();
        for (Lotto lotto : purchasedLotteries) {
            var rank = Rank.calculate(calculator.matchCount(lotto, winningNumbers),
                    calculator.containBonus(lotto, numbers.getBonusNumber()));
            Rank.addRankCount(rank);
            calculator.addPrize(rank);
        }

        Rank.calculateRankCount();
    }

    public void printResult() {
        var yieldText = calculator.calculateYield(buyer.getPurchaseAmount());
        System.out.printf((SystemConstants.TOTAL_YIELD_MESSAGE) + "%n", yieldText);
    }
}
