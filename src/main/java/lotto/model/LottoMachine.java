package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private final LottoGenerator lottoGenerator;

    public LottoMachine(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public Lotto generate() {
        return lottoGenerator.generate();
    }

    public List<Lotto> generateLottoTickets(int quantity) {
        List<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            lottoTickets.add(generate());
        }
        return lottoTickets;
    }

    public int getLottoTicketPrice() {
        return lottoGenerator.LOTTO_TICKET_PRICE;
    }
}