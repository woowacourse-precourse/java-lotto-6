package lotto.controller;

import lotto.model.LottoStore;
import lotto.model.Lottos;
import lotto.view.InputHandler;

public class LottoController {
    public void run() {
        String purchasePrice = InputHandler.purchasePrice();
        Lottos lottos = LottoStore.publishLotto(Integer.parseInt(purchasePrice));
    }
}
