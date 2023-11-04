package controller;

import domain.LottoTicket;

public class LottoController {
    public void start() {
        LottoTicket lottoTicket = new LottoTicket();
        lottoTicket.lottoTicketService();
    }
}
