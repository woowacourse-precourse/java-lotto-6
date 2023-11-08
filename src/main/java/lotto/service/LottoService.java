package lotto.service;

import lotto.domain.LottoMachine;
import lotto.domain.LottoTicket;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    private final LottoMachine lottoMachine;

    public LottoService(LottoMachine lottoMachine) {
        this.lottoMachine = lottoMachine;
    }

    public List<LottoTicket> purchaseLottoTickets(int purchaseAmount) {
        int numberOfTickets = purchaseAmount / LottoTicket.PRICE;
        List<LottoTicket> tickets = new ArrayList<>();

        for (int i = 0; i < numberOfTickets; i++) {
            tickets.add(lottoMachine.generateTicket());
        }

        return tickets;
    }
}
