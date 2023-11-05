package lotto.controller;

import lotto.domain.LottoStore;
import lotto.view.UI;

public class LottoController {

    public void start() {
        String lottoPurchaseRequest = lottoOrderRequest();
        LottoStore LottoPurchaseReceipt = buyLottoTicketRequest(lottoPurchaseRequest);
    }

    public String lottoOrderRequest() {

        String lottoPurchaseRequest = UI.sendLottoPurchaseRequest();
        return lottoPurchaseRequest;
    }

    public LottoStore buyLottoTicketRequest(String lottoPurchaseRequest) {

        LottoStore lottoStore = new LottoStore();
        lottoStore.buyLottoTickets(lottoPurchaseRequest);
        return lottoStore;
    }

}
