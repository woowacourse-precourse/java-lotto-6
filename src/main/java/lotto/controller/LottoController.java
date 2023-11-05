package lotto.controller;

import lotto.domain.LottoStore;
import lotto.view.UI;

public class LottoController {

    public void start() {
        String lottoPurchaseRequest = lottoOrderRequest();

    }

    public String lottoOrderRequest() {

        String lottoPurchaseRequest = UI.sendLottoPurchaseRequest();
        return lottoPurchaseRequest;
    }

}
