package lotto.service;

import lotto.model.collections.LottoPurchaseAmount;
import lotto.model.collections.LottoTicketCount;

import static lotto.constant.LottoConfig.TICKET_PRICE;

public class LottoTicketService {
    public LottoTicketCount convertMoneyToTickets(LottoPurchaseAmount purchaseAmount){
        int ticketCountValue = purchaseAmount.getAmount()/ TICKET_PRICE.getValue();
        return new LottoTicketCount(ticketCountValue);
    }
}
