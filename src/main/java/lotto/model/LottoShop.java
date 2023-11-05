package lotto.model;

import java.util.List;

public class LottoShop {
    private final LottoMachine lottoMachine;

    public LottoShop(LottoMachine lottoMachine) {
        this.lottoMachine = lottoMachine;
    }

    public List<Lotto> createLottoTickets(int budget) {
        int quantity = budget / lottoMachine.getLottoTicketPrice();
        return lottoMachine.generateLottoTickets(quantity);
    }

    public int getLottoTicketPrice() {
        return lottoMachine.getLottoTicketPrice();
    }
}