package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.strategy.LottoNumberGenerator;
import lotto.vo.TicketCount;
import lotto.vo.TotalAmount;

public class LottoPurchase {
    private final TotalAmount totalAmount;
    private final TicketCount ticketCount;
    private final LottoNumberGenerator numberGenerator;

    private LottoPurchase(TotalAmount totalAmount, TicketCount ticketCount, LottoNumberGenerator numberGenerator) {
        this.totalAmount = totalAmount;
        this.ticketCount = ticketCount;
        this.numberGenerator = numberGenerator;
    }

    public static LottoPurchase from(TotalAmount totalAmount, LottoNumberGenerator numberGenerator) {
        TicketCount ticketCount = totalAmount.calculateTicketCount();
        return new LottoPurchase(totalAmount, ticketCount, numberGenerator);
    }

    public LottoTickets generateTickets() {
        List<Lotto> tickets = new ArrayList<>();
        ticketCount.forEach(() -> tickets.add(new Lotto(numberGenerator.generate())));
        return LottoTickets.from(tickets);
    }

    public int getTicketCount() {
        return ticketCount.getCount();
    }

    public int getTotalAmount() {
        return totalAmount.getAmount();
    }
}
