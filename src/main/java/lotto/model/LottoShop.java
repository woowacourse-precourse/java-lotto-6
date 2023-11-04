package lotto.model;

import java.util.List;

public class LottoShop {
    private final LottoGenerator lottoMachine;

    public LottoShop(LottoGenerator lottoMachine) {
        this.lottoMachine = lottoMachine;
    }

    public List<Lotto> createLottoTickets(int budget) {
        int quantity = budget / LottoMachine.LOTTO_TICKET_PRICE;
        return lottoMachine.generateLottoTickets(quantity);
    }

    public int getLottoPrice() {
        return lottoMachine.LOTTO_TICKET_PRICE;
    }
}