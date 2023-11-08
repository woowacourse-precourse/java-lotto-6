package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.constant.LottoConstants;
import lotto.vo.TicketCount;
import lotto.vo.TotalAmount;

public class LottoPurchase {
    private final TotalAmount totalAmount;
    private final TicketCount ticketCount;

    private LottoPurchase(TotalAmount totalAmount, TicketCount ticketCount) {
        this.totalAmount = totalAmount;
        this.ticketCount = ticketCount;
    }

    public static LottoPurchase from(TotalAmount totalAmount) {
        TicketCount ticketCount = totalAmount.calculateTicketCount();
        return new LottoPurchase(totalAmount, ticketCount);
    }

    public LottoTickets generateTickets() {
        List<Lotto> tickets = new ArrayList<>();
        ticketCount.forEach(() -> {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LottoConstants.MIN_NUMBER,
                    LottoConstants.MAX_NUMBER, LottoConstants.LOTTO_COUNT);
            tickets.add(new Lotto(numbers));
        });
        return LottoTickets.from(tickets);
    }

    public int getTicketCount() {
        return ticketCount.getCount();
    }

    public int getTotalAmount() {
        return totalAmount.getAmount();
    }
}
