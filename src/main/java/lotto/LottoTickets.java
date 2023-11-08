package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTickets {
    private final List<Lotto> lottoTickets = new ArrayList<>();
    private final LottoMachine lottoMachine = new LottoMachine();

    public LottoTickets(Money money) {
        int count = money.getPurchasingQuantity();
        while (count-- > 0) {
            buyLottoTicket();
        }
    }

    private void buyLottoTicket() {
        Lotto lotto = lottoMachine.excute();
        lottoTickets.add(lotto);
    }

    public List<Lotto> getLottoTickets() {
        return Collections.unmodifiableList(lottoTickets);
    }
}
