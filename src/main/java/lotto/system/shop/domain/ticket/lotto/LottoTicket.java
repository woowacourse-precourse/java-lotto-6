package lotto.system.shop.domain.ticket.lotto;

import java.util.List;
import lotto.system.shop.domain.ticket.Ticket;

public class LottoTicket extends Ticket<Lotto> {

    public LottoTicket(Lotto source) {
        super(source);
    }

    public List<Integer> getNumbers() {
        return super.getSource().getNumbers();
    }
}
