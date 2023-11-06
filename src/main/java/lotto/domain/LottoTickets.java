package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {

    private final List<Lotto> lottoTickets = new ArrayList<>();
    private final int numberOfLottoTickets;

    public LottoTickets(Payment payment) {
        numberOfLottoTickets = payment.numberLottoTicketsCanBuy();
        for (int i = 0; i < numberOfLottoTickets; i++) {
            buyLottoTickets();
        }
    }

    private void buyLottoTickets() {
        lottoTickets.add(LottoGenerator.generate());
    }
}
