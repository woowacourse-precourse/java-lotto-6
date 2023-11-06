package lotto.controller;

import static lotto.constant.Constant.ZERO;

import lotto.domain.LottoTicketManager;
import lotto.domain.LottoTickets;
import lotto.domain.number.AutoNumberGenerator;
import lotto.domain.number.LottoNumberGenerator;

public class LottoController {

    private final LottoTicketManager lottoTicketManager;
    private final LottoNumberGenerator lottoNumberGenerator;
    private final LottoTickets lottoTickets;

    public LottoController(){
        lottoTicketManager = new LottoTicketManager();
        lottoNumberGenerator = new AutoNumberGenerator();
        lottoTickets = new LottoTickets();
    }

    public void buyTicket(String price) {
        Integer numberOfTickets = lottoTicketManager.countTickets(price);
        while (numberOfTickets-- > ZERO ){
            lottoTickets.setTicket(lottoNumberGenerator.getLottoNumbers());
        }
    }

}
