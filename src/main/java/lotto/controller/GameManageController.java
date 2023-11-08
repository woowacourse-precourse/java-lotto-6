package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class GameManageController {

    private final InputView inputView;
    private final OutputView outputView;
    private Lottos lottos;

    public GameManageController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void start() {
        Money purchaseAmount = getPurchaseMoney();
        Lottos lottos = getLottos(purchaseAmount);
        Lotto lotto = getInputNumbers();
        BonusNumber bonusNumber = getInputBonusNumber();
    }

    private Money getPurchaseMoney() {
        try {
            outputView.inputPurchaseMoneyMessage();
            int money = inputView.purchaseMoney();
            return new Money(money);
        } catch (IllegalArgumentException e) {
            outputView.errorMessage();
            return getPurchaseMoney();
        }
    }

    private Lottos getLottos(Money purchaseAmount) {
        int amount = purchaseAmount.divideMoney();
        outputView.noticePurchaseCountMessage(amount);

        List<List<Integer>> lotto = Lottos.createRandomLotto(amount);
        outputView.noticeRandomLottoMessage(amount, lotto);

        return new Lottos(lotto);
    }

    private Lotto getInputNumbers() {
        try {
            outputView.inputNumbersMessage();
            return new Lotto(inputView.numbers());
        } catch (IllegalArgumentException e) {
            outputView.errorMessage();
            return getInputNumbers();
        }
    }

    private BonusNumber getInputBonusNumber() {
        try {
            outputView.inputBonusNumberMessage();
            return new BonusNumber(inputView.bonusNumber());
        } catch (IllegalArgumentException e) {
            outputView.errorMessage();
            return getInputBonusNumber();
        }
    }
}