package lotto.model;

import static lotto.Constants.Constants.TICKET_PRICE;
import static lotto.exception.LottoErrorCode.PURCHASE_AMOUNT_NOT_POSITIVE;
import static lotto.exception.LottoErrorCode.PURCHASE_AMOUNT_NOT_PRICE_UNIT;

import java.util.ArrayList;
import java.util.List;
import lotto.exception.LottoException;

public class LottoTicketFactory {

    public List<Lotto> generateTickets(final int purchaseAmount) {
        final int purchasedCount = getTicketCount(purchaseAmount);

        final List<Lotto> lottoTickets = new ArrayList<>();
        for (int ticketCount = 0; ticketCount < purchasedCount; ticketCount++) {
            lottoTickets.add(LottoTicket.newInstance());
        }

        return lottoTickets;
    }

    private int getTicketCount(final int purchaseAmount) {
        validateTicket(purchaseAmount);
        return purchaseAmount / TICKET_PRICE;
    }

    private void validateTicket(final int purchaseAmount) {
        validateTicketPricePositive(purchaseAmount);
        validateTicketPriceUnit(purchaseAmount);
    }

    private void validateTicketPricePositive(final int purchaseAmount) {
        if (purchaseAmount <= 0) {
            throw new LottoException(PURCHASE_AMOUNT_NOT_POSITIVE);
        }
    }

    private void validateTicketPriceUnit(final int purchaseAmount) {
        if (purchaseAmount % TICKET_PRICE != 0) {
            throw new LottoException(PURCHASE_AMOUNT_NOT_PRICE_UNIT);
        }
    }

}