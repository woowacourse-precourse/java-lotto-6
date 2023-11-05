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
    public List<Lotto> lottos;
    public List<Integer> answerNumber;

    public void startLotto() {
        requestPurchaseAmount();
        OutputView.printNextLine();
        showLottoCount();
        OutputView.printNextLine();
        requestAnswerNumber();
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
        answerNumber = inputView.inputAnswerNumber();
    }
}