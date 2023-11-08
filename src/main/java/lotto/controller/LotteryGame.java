package lotto.controller;

import static lotto.view.input.Input.inputNumber;
import static lotto.view.input.Input.inputNumbers;
import static lotto.view.output.Output.printErrorMessage;
import static lotto.view.output.Output.printMessage;
import static lotto.view.output.Output.printPurchasedLottery;
import static lotto.view.output.Output.printResultMessage;
import static lotto.view.output.Output.printTotalRateMessage;
import static lotto.view.output.Output.println;

import java.util.List;
import java.util.Map;
import lotto.domain.LotteryShop;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Money;
import lotto.domain.Result;
import lotto.view.input.error.InputIllegalArgumentException;
import lotto.view.output.OutputMessage;

public class LotteryGame {

    private Money money;
    private LotteryShop lotteryShop;
    private Lotto winningLotto;
    private Map<Result, Integer> resultCalculator;
    private LottoResult lottoResult;

    private int bonusNumber;

    public void lotteryRun() {
        readyMoney();
        buyLotteries(money);
        lotteryDraw();
        checkLotteries();
    }

    private void readyMoney() {
        boolean canBuy;
        do {
            canBuy = isCanBuyMoney();

        } while (!canBuy);
    }

    private boolean isCanBuyMoney() {
        printMessage(OutputMessage.INPUT_PURCHASE_AMOUNT);

        try {
            long amount = inputNumber();

            money = Money.getInstance(amount);
            return true;

        } catch (IllegalArgumentException e) {
            printErrorMessage(e);
            return false;
        }
    }

    private void buyLotteries(Money money) {
        lotteryShop = LotteryShop.buyLotteryFrom(money);

        List<List<Integer>> lotteryPapers = lotteryShop.getLotteryPapers();
        showLottery(lotteryPapers);
    }

    private void showLottery(List<List<Integer>> lotteryPapers) {
        println();
        printMessage(OutputMessage.PURCHASED_LOTTERY, lotteryPapers.size());
        printPurchasedLottery(lotteryPapers);
    }

    private void lotteryDraw() {
        winningLottoDraw();
        winningBonusDraw();
    }

    private void winningLottoDraw() {
        println();
        printMessage(OutputMessage.INPUT_WINNING_LOTTERY_NUMBERS);

        try {
            winningLotto = new Lotto(inputNumbers());

        } catch (IllegalArgumentException e) {
            printErrorMessage(e);
            lotteryDraw();
        }
    }

    private void winningBonusDraw() {
        println();
        printMessage(OutputMessage.INPUT_BONUS_LOTTERY_NUMBER);

        try {
            bonusNumber = inputNumber();
            winningLotto.validateContainsNumber(bonusNumber);

        } catch (InputIllegalArgumentException e) {
            printErrorMessage(e);
            winningBonusDraw();
        }
    }

    private void checkLotteries() {
        lottoResult = new LottoResult();

        println();
        printMessage(OutputMessage.LOTTERY_WINNING_STATISTICS);

        resultCalculator = lottoResult.calculateResult(winningLotto, lotteryShop.getLotteryPapers(), bonusNumber);
        checkResult();
    }

    private void checkResult() {
        checkTotalResult();
        checkTotalRate();
    }

    private void checkTotalResult() {
        for (Result result : Result.values()) {
            if (result == Result.NO_SAME) {
                continue;
            }

            int count = resultCalculator.get(result);
            printResultMessage(result, count);
        }

    }

    private void checkTotalRate() {
        printTotalRateMessage(OutputMessage.TOTAL_RETURN_RATE, lottoResult.getTotalRate());
    }
    
}
