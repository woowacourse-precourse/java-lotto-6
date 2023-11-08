package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LotteryBallMachine;
import lotto.model.Purchase;
import lotto.model.prize.Prize;
import lotto.model.prize.PrizeEvaluator;
import lotto.model.winning.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.stream.Stream;

public class LottoGameConsole {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    private Purchase<Lotto> purchase;
    private WinningNumbers winningNumbers;

    public void start() {
        inputPurchaseMoney();
        purchaseLotto();

        inputWinningNumbers();
        inputBonusNumber();

        Prize prize = evaluatePrize();
        printResult(prize);
    }

    private void inputPurchaseMoney() {
        try {
            String inputMoney = inputView.inputMoney();
            purchase = new Purchase<>(inputMoney);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            inputPurchaseMoney();
        }
    }

    private void purchaseLotto() {
        int purchaseMoney = purchase.getMoney();
        int purchaseCount = purchaseMoney / Purchase.PURCHASE_MONEY_UNIT;

        outputView.printLottoCount(purchaseCount);
        purchase.purchaseItems(generateLotto(purchaseCount));
        outputView.printLotto(purchase.toString());
    }

    private List<Lotto> generateLotto(int purchaseCount) {
        return Stream.generate(() -> new Lotto(LotteryBallMachine.generateNumbers()))
                .limit(purchaseCount)
                .toList();
    }

    private void inputWinningNumbers() {
        try {
            String inputWinningNumbers = inputView.inputWinningNumbers();
            winningNumbers = new WinningNumbers(inputWinningNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            inputWinningNumbers();
        }
    }

    private void inputBonusNumber() {
        try {
            String inputBonusNumber = inputView.inputBonusNumber();
            winningNumbers.addBonusNumber(inputBonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            inputBonusNumber();
        }
    }

    private Prize evaluatePrize() {
        PrizeEvaluator prizeEvaluator = new PrizeEvaluator();
        return prizeEvaluator.evaluate(winningNumbers, purchase.getItems());
    }

    private void printResult(Prize prize) {
        outputView.printPrizeResult(prize);
        outputView.printPrizeRate(calculatePrizeRate(prize.prizeMoney()));
    }

    private double calculatePrizeRate(int prizeMoney) {
        return prizeMoney / (double) purchase.getMoney() * 100;
    }
}
