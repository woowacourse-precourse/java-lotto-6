package lotto.service;

import lotto.model.Lotto;
import lotto.model.Ticket;

import java.util.ArrayList;
import java.util.List;

public class TicketService {

    public static Ticket createTicket(int price) {
        int purchaseNum = price / 1000;
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i < purchaseNum; i++) {
            lottos.add(LottoService.createLotto());
        }
        return new Ticket(lottos, purchaseNum);
    }

}
