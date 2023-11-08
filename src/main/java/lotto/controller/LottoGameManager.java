package lotto.controller;

import lotto.domain.Consumer;
import lotto.service.LottoStore;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameManager {
    private InputView inputView;
    private OutputView outputView;
    private LottoStore lottoStore;

    private Consumer consumer = new Consumer();

    public LottoGameManager(InputView inputView, OutputView outputView, LottoStore lottoStore) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoStore = lottoStore;
    }

    public void play(){
        enterPurchaseAmount();
    }

    private void enterPurchaseAmount(){
        while(true){
            try {
                int purchaseAmount = inputView.enterPurchaseAmount();
                consumer.setPurchaseAmount(purchaseAmount);
                break;
            } catch (IllegalArgumentException e){
                System.err.println(e.getMessage());
            }
        }
    }
}
