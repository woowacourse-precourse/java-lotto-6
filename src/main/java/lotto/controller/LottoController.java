package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoStore;
import lotto.view.UI;

public class LottoController {

    public void start() {
        String lottoPurchaseRequest = lottoOrderRequest();
        LottoStore lottoStore = buyLottoTicketRequest(lottoPurchaseRequest);
        respondLottoTicketsHistory(lottoStore.getUserLottoTickets());
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

    public void respondLottoTicketsHistory(List<Lotto> LottoTickets) {
        UI.displayLottoTicketsHistory(LottoTickets);
    }
}
