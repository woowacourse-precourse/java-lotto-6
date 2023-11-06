package lotto.controller;

import lotto.model.*;
import lotto.model.prize.Prize;
import lotto.model.prize.PrizeEvaluator;
import lotto.model.winning.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoGameConsole {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    private Purchase<Lotto> purchase;
    private WinningNumbers winningNumbers;

    public void start() {
        purchaseLotto();

        int purchaseMoney = purchase.getMoney();
        int purchaseCount = purchaseMoney / Purchase.PURCHASE_MONEY_UNIT;

        outputView.printLottoCount(purchaseCount);
        purchase.purchaseItems(generateLotto(purchaseCount));
        outputView.printLotto(purchase.toString());

        inputWinningNumbers();
        inputBonusNumber();

        PrizeEvaluator prizeEvaluator = new PrizeEvaluator();
        Prize prize = prizeEvaluator.evaluate(winningNumbers, purchase.getItems());

        outputView.printPrizeResult(prize);
        outputView.printPrizeRate(calculatePrizeRate(prize.prizeMoney()));
    }

    private void purchaseLotto() {
        try {
            String inputMoney = inputView.inputMoney();
            purchase = new Purchase<>(inputMoney);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            purchaseLotto();
        }
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

    private List<Lotto> generateLotto(int purchaseCount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < purchaseCount; i++) {
            Lotto lotto = new Lotto(LotteryBallMachine.generateNumbers());
            lottos.add(lotto);
        }

        return lottos;
    }

    private double calculatePrizeRate(int prizeMoney) {
        return prizeMoney / (double) purchase.getMoney() * 100;
    }
}
