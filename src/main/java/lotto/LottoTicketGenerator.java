package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoTicketGenerator {

    public List<Lotto> buy(int purchaseQuantity) {
        List<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 0; i < purchaseQuantity; i++) {
            lottoTickets.add(Lotto.generate());
        }
        return lottoTickets;
    }
}
