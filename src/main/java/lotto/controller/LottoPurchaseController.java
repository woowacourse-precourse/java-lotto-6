package lotto.controller;

import lotto.service.LottoStoreCounter;
import lotto.service.LottoStoreMachine;
import lotto.view.PurchasedLottoesView;

import java.util.List;

public class LottoPurchaseController {
    // 로또 구매를 중계할 클래스입니다.
    public void purchaseLotto() {
        LottoStoreCounter lottoStoreCounter = new LottoStoreCounter();
        int numberOfIssues = lottoStoreCounter.counter();
        PurchasedLottoesView purchasedLottoesView = new PurchasedLottoesView();
        purchasedLottoesView.printNumberOfIssues(numberOfIssues);

        LottoStoreMachine lottoStoreMachine = new LottoStoreMachine();
        List<List<Integer>> purchasedLotto = lottoStoreMachine.saleLotto(numberOfIssues);
        purchasedLottoesView.printPurchasedLottoes(purchasedLotto);
    }
}

