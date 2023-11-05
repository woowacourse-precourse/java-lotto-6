package lotto.controller;

import lotto.model.Lotto;
import lotto.model.PlayLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    InputView inputView = new InputView();

    public int purchaseAmount;
    public int lottoCount;
    public int bonusNumber;
    public List<Lotto> lottos;
    public List<Integer> answerNumber;

    public void startLotto() {
        requestPurchaseAmount();
        OutputView.printNextLine();
        showLottoCount();
        OutputView.printNextLine();
        requestAnswerNumber();
        OutputView.printNextLine();
        requestBonusNumber();
    }

    public void requestPurchaseAmount() {
        OutputView.printPurchaseAmountRequest();
        try {
            purchaseAmount = inputView.inputPurchaseAmount();
            lottoCount = purchaseAmount / InputView.MIN_PURCHASE_AMOUNT;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            requestPurchaseAmount();
        }
    }

    public void showLottoCount() {
        OutputView.printLottoCount(lottoCount);
        lottos = PlayLotto.makeLottos(lottoCount);
        OutputView.printLottos(lottos);
    }

    public void requestAnswerNumber() {
        OutputView.printAnswerNumberRequest();
        try {
            answerNumber = inputView.inputAnswerNumber();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            requestAnswerNumber();
        }
    }

    public void requestBonusNumber() {
        OutputView.printBonusNumberRequest();
        try {
            bonusNumber = inputView.inputBonusNumber(answerNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            requestBonusNumber();
        }
    }
}