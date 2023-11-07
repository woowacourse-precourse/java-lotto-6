package lotto.controller;

import lotto.domain.Lotto;
import lotto.service.LottoStoreCounter;
import lotto.service.LottoStoreMachine;
import lotto.view.PurchasedLottoesView;

import java.util.ArrayList;
import java.util.List;

public class LottoPurchaseController {
    // 로또 구매를 중계할 클래스입니다.
    public List<Lotto> purchaseLotto() {
        LottoStoreCounter lottoStoreCounter = new LottoStoreCounter();
        int numberOfIssues = lottoStoreCounter.counter();
        PurchasedLottoesView purchasedLottoesView = new PurchasedLottoesView();
        purchasedLottoesView.printNumberOfIssues(numberOfIssues);

        LottoStoreMachine lottoStoreMachine = new LottoStoreMachine();
        List<Lotto> purchasedLotto = new ArrayList<>();
        purchasedLotto.addAll(lottoStoreMachine.saleLotto(numberOfIssues));
        purchasedLottoesView.printPurchasedLottoes(purchasedLotto);

        return purchasedLotto;
    }
}

