package lotto.controller;

import lotto.domain.Buy;
import lotto.domain.LottoTicket;
import lotto.view.View;

public class LottoController {
    View view = new View();

    public void startLotto() {
        buyLotto();
    }

    private void buyLotto() {
        Buy buy = new Buy(view.buyPriceMessage());
        System.out.println();
        buyLottoPrice(buy);
        lottoTicket(buy);
    }

    private void buyLottoPrice(Buy buy) {
        view.buyTicketCountMessage(buy.getBuyTicketCount());
    }

    private void lottoTicket(Buy buy) {
        LottoTicket lottoTicketCount = new LottoTicket(buy.getBuyTicketCount());
        lottoTicketNumbers(lottoTicketCount);
    }

    private void lottoTicketNumbers(LottoTicket lottoTicketCount) {
        view.lottoTicketInformation(lottoTicketCount.getLottoTicket());
    }
}
