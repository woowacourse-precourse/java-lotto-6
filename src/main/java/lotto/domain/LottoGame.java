package lotto.domain;

import java.util.List;

public class LottoGame {

    private final TicketDispenser<Lotto> ticketDispenser;

    public LottoGame(TicketDispenser<Lotto> ticketDispenser) {
        this.ticketDispenser = ticketDispenser;
    }

    public PurchasedLottoTickets purchaseLottoTickets(String cost) {
        int paymentCost = convertStringCostToInt(cost);
        List<Lotto> purchasedLotto = ticketDispenser.buyAutoCreatedTicket(paymentCost);
        return new PurchasedLottoTickets(purchasedLotto);
    }

    private int convertStringCostToInt(String cost) {
        try {
            return Integer.parseInt(cost);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("유효하지 않은 금액입니다.");
        }
    }

    public Lotto createWinningLotto(List<Integer> numbers) {
        return ticketDispenser.createWinningTicket(() -> numbers);
    }

}
