package lotto.controller;

import lotto.domain.Lotto;
import lotto.service.LottoStoreCounter;
import lotto.service.LottoStoreMachine;
import lotto.view.PurchasedLottoesView;

import java.util.List;

public class LottoPurchaseController {
    // 로또 구매를 중계할 클래스입니다.
    public List<Lotto> purchaseLotto() {
        int numberOfIssues = numberOfIssues();
        PurchasedLottoesView purchasedLottoesView = new PurchasedLottoesView();
        purchasedLottoesView.printNumberOfIssues(numberOfIssues);

        List<Lotto> purchasedLotto = purchasedLotto(numberOfIssues);
        purchasedLottoesView.printPurchasedLottoes(purchasedLotto);

        return purchasedLotto;
    }

    private int numberOfIssues() {
        LottoStoreCounter lottoStoreCounter = new LottoStoreCounter();

        return lottoStoreCounter.counter();
    }

    private List<Lotto> purchasedLotto(int numberOfIssues) {
        LottoStoreMachine lottoStoreMachine = new LottoStoreMachine();

        return lottoStoreMachine.saleLotto(numberOfIssues);
    }
}

